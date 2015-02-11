package eu.artist.repo.scanner.builder;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class SampleResourceVisitor implements IResourceVisitor {
  private Procedure1<? super IResource> action;
  
  public SampleResourceVisitor(final Procedure1<? super IResource> action) {
    this.action = action;
  }
  
  public boolean visit(final IResource resource) {
    boolean _xblockexpression = false;
    {
      IPath _fullPath = resource.getFullPath();
      String _plus = ("V : Visiting " + _fullPath);
      InputOutput.<String>println(_plus);
      this.action.apply(resource);
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
}
