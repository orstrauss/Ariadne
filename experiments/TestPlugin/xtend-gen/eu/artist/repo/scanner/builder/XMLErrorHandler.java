package eu.artist.repo.scanner.builder;

import eu.artist.repo.scanner.builder.ScanBuilder2;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

@SuppressWarnings("all")
public class XMLErrorHandler extends DefaultHandler {
  private final IFile file;
  
  public XMLErrorHandler(final IFile file) {
    this.file = file;
  }
  
  public void addMarker(final SAXParseException e, final int severity) {
    String _message = e.getMessage();
    int _lineNumber = e.getLineNumber();
    this.addMarker(this.file, _message, _lineNumber, severity);
  }
  
  public void addMarker(final IFile file, final String message, final int lineNumber, final int severity) {
    try {
      IMarker _createMarker = file.createMarker(ScanBuilder2.MARKER_TYPE);
      final Procedure1<IMarker> _function = new Procedure1<IMarker>() {
        public void apply(final IMarker it) {
          try {
            it.setAttribute(IMarker.MESSAGE, message);
            it.setAttribute(IMarker.SEVERITY, severity);
            int _xifexpression = (int) 0;
            if ((lineNumber != (-1))) {
              _xifexpression = lineNumber;
            } else {
              _xifexpression = 1;
            }
            it.setAttribute(IMarker.LINE_NUMBER, _xifexpression);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      ObjectExtensions.<IMarker>operator_doubleArrow(_createMarker, _function);
    } catch (final Throwable _t) {
      if (_t instanceof CoreException) {
        final CoreException e = (CoreException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void error(final SAXParseException exception) throws SAXException {
    this.addMarker(exception, IMarker.SEVERITY_ERROR);
  }
  
  public void fatalError(final SAXParseException exception) throws SAXException {
    this.addMarker(exception, IMarker.SEVERITY_ERROR);
  }
  
  public void warning(final SAXParseException exception) throws SAXException {
    this.addMarker(exception, IMarker.SEVERITY_WARNING);
  }
}
