package eu.artist.repo.scanner.builder

import org.eclipse.core.resources.IncrementalProjectBuilder
import org.eclipse.core.resources.IResourceDeltaVisitor
import org.eclipse.core.resources.IResourceDelta
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IFile
import java.util.Map
import org.eclipse.core.runtime.IProgressMonitor
import org.xml.sax.helpers.DefaultHandler
import org.xml.sax.SAXParseException
import org.eclipse.core.resources.IMarker
import org.xml.sax.SAXException
import javax.xml.parsers.SAXParserFactory
import javax.xml.parsers.ParserConfigurationException
import org.eclipse.core.resources.IResourceVisitor

class ScanBuilder2 extends IncrementalProjectBuilder {
	public static val String BUILDER_ID = "TestPlugin.scanBuilder";
	public static val String MARKER_TYPE = "TestPlugin.xmlProblem";
	
	val SAXParserFactory parserFactory = SAXParserFactory.newInstance()
	
	protected override build(int kind, Map<String, String> args, IProgressMonitor monitor) throws CoreException {
		if (kind == FULL_BUILD) {
			fullBuild(monitor);
		} else {
			val IResourceDelta delta = getDelta(getProject());
			if (delta == null) {
				fullBuild(monitor);
			} else {
				incrementalBuild(delta, monitor);
			}
		}
		null
	}
	
	protected override clean(IProgressMonitor monitor) throws CoreException {
		// delete markers set and files created
		project.deleteMarkers(MARKER_TYPE, true, IResource::DEPTH_INFINITE);
	}
	
	protected def fullBuild(IProgressMonitor monitor) throws CoreException {
		try {
			project.accept(new SampleResourceVisitor() [ checkXML(it) ]);
		} catch (CoreException e) {
		}
	}
	
	protected def incrementalBuild(IResourceDelta delta, IProgressMonitor monitor) throws CoreException {
		// the visitor does the work.
		delta.accept(new ScanBuilder2SampleDeltaVisitor() [ checkXML(it) ]);
	}			
	
	def void checkXML(IResource resource) {
		if (resource instanceof IFile && resource.name.endsWith(".xml")) {
			val IFile file = resource as IFile;
			deleteMarkers(file);
			val XMLErrorHandler reporter = new XMLErrorHandler(file);
			try {
				parser.parse(file.contents, reporter);
			} catch (Exception e1) {
			}
		}
	}

	def deleteMarkers(IFile file) {
		try {
			file.deleteMarkers(ScanBuilder2::MARKER_TYPE, false, IResource.DEPTH_ZERO);
		} catch (CoreException ce) {
		}
	}
	
	private def getParser() throws ParserConfigurationException, SAXException {
		parserFactory.newSAXParser();
	}
}

class SampleResourceVisitor implements IResourceVisitor {
	(IResource) => void action
	
	new((IResource) => void action) {
		this.action = action
	}
	
	override visit(IResource resource) {
		println("V : Visiting " + resource.fullPath)
		action.apply(resource)
		//return true to continue visiting children.
		true
	}
}

class ScanBuilder2SampleDeltaVisitor implements IResourceDeltaVisitor {
	(IResource) => void action
	
	new((IResource) => void action) {
		this.action = action
	}
	
	override visit(IResourceDelta delta) throws CoreException {
		val IResource resource = delta.resource

		switch delta.kind {
			case IResourceDelta.CHANGED:
				action.apply(resource)
			case IResourceDelta.ADDED:
				action.apply(resource)
			case IResourceDelta.REMOVED: {
			}
		}
		println('''DV: Visiting «resource.fullPath» with kind «delta.kind»''')

		//return true to continue visiting children.
		true
	}
}

class XMLErrorHandler extends DefaultHandler {
	val IFile file;

	public new(IFile file) {
		this.file = file;
	}

	def addMarker(SAXParseException e, int severity) {
		addMarker(file, e.getMessage(), e.getLineNumber(), severity);
	}

	def void addMarker(IFile file, String message, int lineNumber, int severity) {
		try {
			file.createMarker(ScanBuilder2::MARKER_TYPE) => [
				setAttribute(IMarker.MESSAGE, message)
				setAttribute(IMarker.SEVERITY, severity)
				setAttribute(IMarker.LINE_NUMBER, if (lineNumber != -1) lineNumber else 1)
			]
		} catch (CoreException e) {
		}
	}

	override error(SAXParseException exception) throws SAXException {
		addMarker(exception, IMarker.SEVERITY_ERROR);
	}

	override fatalError(SAXParseException exception) throws SAXException {
		addMarker(exception, IMarker.SEVERITY_ERROR);
	}

	override warning(SAXParseException exception) throws SAXException {
		addMarker(exception, IMarker.SEVERITY_WARNING);
	}
}
