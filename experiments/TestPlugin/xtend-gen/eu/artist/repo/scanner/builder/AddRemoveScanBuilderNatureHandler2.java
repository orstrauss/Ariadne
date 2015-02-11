package eu.artist.repo.scanner.builder;

import com.google.common.base.Objects;
import eu.artist.repo.scanner.builder.Activator2;
import eu.artist.repo.scanner.builder.ScanBuilderNature;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class AddRemoveScanBuilderNatureHandler2 extends AbstractHandler {
  public Object execute(final ExecutionEvent event) {
    try {
      Object _xblockexpression = null;
      {
        final ISelection selection = HandlerUtil.getCurrentSelection(event);
        if ((selection instanceof IStructuredSelection)) {
          final Iterator items = ((IStructuredSelection) selection).iterator();
          boolean _hasNext = items.hasNext();
          boolean _while = _hasNext;
          while (_while) {
            {
              final Object element = items.next();
              final IProject project = this.getProjectFromSelectionElement(element);
              boolean _notEquals = (!Objects.equal(project, null));
              if (_notEquals) {
                try {
                  this.toggleNature(project);
                } catch (final Throwable _t) {
                  if (_t instanceof CoreException) {
                    final CoreException e = (CoreException)_t;
                    throw new ExecutionException("Failed to toggle nature", e);
                  } else {
                    throw Exceptions.sneakyThrow(_t);
                  }
                }
              }
            }
            boolean _hasNext_1 = items.hasNext();
            _while = _hasNext_1;
          }
        }
        _xblockexpression = null;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private IProject getProjectFromSelectionElement(final Object element) {
    IProject _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(element,IProject.class)) {
        _matched=true;
        _switchResult = ((IProject) element);
      }
    }
    if (!_matched) {
      if (Objects.equal(element,IAdaptable.class)) {
        _matched=true;
        Object _adapter = ((IAdaptable) element).getAdapter(IProject.class);
        _switchResult = ((IProject) _adapter);
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    return _switchResult;
  }
  
  private void toggleNature(final IProject project) throws CoreException {
    final IProjectDescription description = project.getDescription();
    final List<String> natures = (List<String>)Conversions.doWrapArray(description.getNatureIds());
    boolean _contains = natures.contains(ScanBuilderNature.NATURE_ID);
    if (_contains) {
      natures.remove(ScanBuilderNature.NATURE_ID);
    } else {
      natures.add(ScanBuilderNature.NATURE_ID);
    }
    description.setNatureIds(((String[])Conversions.unwrapArray(natures, String.class)));
    project.setDescription(description, null);
    Activator2 _default = Activator2.getDefault();
    _default.print("Adding nature.");
  }
}
