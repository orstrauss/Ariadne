package eu.artist.repo.scanner.builder;

import com.google.common.base.Objects;
import eu.artist.repo.scanner.builder.SampleResourceVisitor;
import eu.artist.repo.scanner.builder.ScanBuilder2SampleDeltaVisitor;
import eu.artist.repo.scanner.builder.XMLErrorHandler;
import java.io.InputStream;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.xml.sax.SAXException;

@SuppressWarnings("all")
public class ScanBuilder2 extends IncrementalProjectBuilder {
  public final static String BUILDER_ID = "TestPlugin.scanBuilder";
  
  public final static String MARKER_TYPE = "TestPlugin.xmlProblem";
  
  private final SAXParserFactory parserFactory = SAXParserFactory.newInstance();
  
  protected IProject[] build(final int kind, final Map<String,String> args, final IProgressMonitor monitor) throws CoreException {
    IProject[] _xblockexpression = null;
    {
      if ((kind == IncrementalProjectBuilder.FULL_BUILD)) {
        this.fullBuild(monitor);
      } else {
        IProject _project = this.getProject();
        final IResourceDelta delta = this.getDelta(_project);
        boolean _equals = Objects.equal(delta, null);
        if (_equals) {
          this.fullBuild(monitor);
        } else {
          this.incrementalBuild(delta, monitor);
        }
      }
      _xblockexpression = null;
    }
    return _xblockexpression;
  }
  
  protected void clean(final IProgressMonitor monitor) throws CoreException {
    IProject _project = this.getProject();
    _project.deleteMarkers(ScanBuilder2.MARKER_TYPE, true, IResource.DEPTH_INFINITE);
  }
  
  protected Object fullBuild(final IProgressMonitor monitor) throws CoreException {
    Object _xtrycatchfinallyexpression = null;
    try {
      IProject _project = this.getProject();
      final Procedure1<IResource> _function = new Procedure1<IResource>() {
        public void apply(final IResource it) {
          ScanBuilder2.this.checkXML(it);
        }
      };
      SampleResourceVisitor _sampleResourceVisitor = new SampleResourceVisitor(_function);
      _project.accept(_sampleResourceVisitor);
    } catch (final Throwable _t) {
      if (_t instanceof CoreException) {
        final CoreException e = (CoreException)_t;
        _xtrycatchfinallyexpression = null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  protected void incrementalBuild(final IResourceDelta delta, final IProgressMonitor monitor) throws CoreException {
    final Procedure1<IResource> _function = new Procedure1<IResource>() {
      public void apply(final IResource it) {
        ScanBuilder2.this.checkXML(it);
      }
    };
    ScanBuilder2SampleDeltaVisitor _scanBuilder2SampleDeltaVisitor = new ScanBuilder2SampleDeltaVisitor(_function);
    delta.accept(_scanBuilder2SampleDeltaVisitor);
  }
  
  public void checkXML(final IResource resource) {
    boolean _and = false;
    if (!(resource instanceof IFile)) {
      _and = false;
    } else {
      String _name = resource.getName();
      boolean _endsWith = _name.endsWith(".xml");
      _and = _endsWith;
    }
    if (_and) {
      final IFile file = ((IFile) resource);
      this.deleteMarkers(file);
      final XMLErrorHandler reporter = new XMLErrorHandler(file);
      try {
        SAXParser _parser = this.getParser();
        InputStream _contents = file.getContents();
        _parser.parse(_contents, reporter);
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e1 = (Exception)_t;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
  }
  
  public Object deleteMarkers(final IFile file) {
    Object _xtrycatchfinallyexpression = null;
    try {
      file.deleteMarkers(ScanBuilder2.MARKER_TYPE, false, IResource.DEPTH_ZERO);
    } catch (final Throwable _t) {
      if (_t instanceof CoreException) {
        final CoreException ce = (CoreException)_t;
        _xtrycatchfinallyexpression = null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  private SAXParser getParser() throws ParserConfigurationException, SAXException {
    return this.parserFactory.newSAXParser();
  }
}
