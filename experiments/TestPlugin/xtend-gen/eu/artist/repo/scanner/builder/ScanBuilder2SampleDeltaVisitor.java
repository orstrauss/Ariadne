package eu.artist.repo.scanner.builder;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ScanBuilder2SampleDeltaVisitor implements IResourceDeltaVisitor {
  private Procedure1<? super IResource> action;
  
  public ScanBuilder2SampleDeltaVisitor(final Procedure1<? super IResource> action) {
    this.action = action;
  }
  
  public boolean visit(final IResourceDelta delta) throws CoreException {
    boolean _xblockexpression = false;
    {
      final IResource resource = delta.getResource();
      int _kind = delta.getKind();
      switch (_kind) {
        case IResourceDelta.CHANGED:
          this.action.apply(resource);
          break;
        case IResourceDelta.ADDED:
          this.action.apply(resource);
          break;
        case IResourceDelta.REMOVED:
          break;
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("DV: Visiting ");
      IPath _fullPath = resource.getFullPath();
      _builder.append(_fullPath, "");
      _builder.append(" with kind ");
      int _kind_1 = delta.getKind();
      _builder.append(_kind_1, "");
      InputOutput.<String>println(_builder.toString());
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
}
