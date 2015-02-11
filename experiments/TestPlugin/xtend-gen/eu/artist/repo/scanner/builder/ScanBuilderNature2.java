package eu.artist.repo.scanner.builder;

import com.google.common.base.Objects;
import eu.artist.repo.scanner.builder.ScanBuilder;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class ScanBuilderNature2 implements IProjectNature {
  public final static String NATURE_ID = "TestPlugin.scanBuilderNature";
  
  private IProject project;
  
  public void configure() throws CoreException {
    final ICommand[] oldCommands = this.getBuilderCommands();
    boolean _isBuilderPresent = this.isBuilderPresent(oldCommands);
    if (_isBuilderPresent) {
      return;
    }
    ICommand[] _appendBuilderTo = this.appendBuilderTo(oldCommands);
    this.setBuilderCommands(_appendBuilderTo);
  }
  
  private ICommand[] getBuilderCommands() throws CoreException {
    IProject _project = this.getProject();
    IProjectDescription _description = _project.getDescription();
    return _description.getBuildSpec();
  }
  
  private boolean isBuilderPresent(final ICommand[] commands) {
    final Function1<ICommand,Boolean> _function = new Function1<ICommand,Boolean>() {
      public Boolean apply(final ICommand it) {
        String _builderName = it.getBuilderName();
        return Boolean.valueOf(Objects.equal(_builderName, ScanBuilder.BUILDER_ID));
      }
    };
    Iterable<ICommand> _filter = IterableExtensions.<ICommand>filter(((Iterable<ICommand>)Conversions.doWrapArray(commands)), _function);
    int _size = IterableExtensions.size(_filter);
    return (_size > 0);
  }
  
  private void setBuilderCommands(final ICommand[] newCommands) throws CoreException {
    IProject _project = this.getProject();
    final IProjectDescription description = _project.getDescription();
    description.setBuildSpec(newCommands);
    IProject _project_1 = this.getProject();
    _project_1.setDescription(description, null);
  }
  
  private ICommand[] appendBuilderTo(final ICommand[] oldCommands) throws CoreException {
    ICommand _createBuilderCommand = this.createBuilderCommand();
    return this.appendCommand(oldCommands, _createBuilderCommand);
  }
  
  private ICommand[] appendCommand(final ICommand[] oldCommands, final ICommand newCommand) {
    int _length = oldCommands.length;
    int _plus = (_length + 1);
    ICommand[] newCommands = new ICommand[_plus];
    int _length_1 = oldCommands.length;
    System.arraycopy(oldCommands, 0, newCommands, 0, _length_1);
    int _length_2 = newCommands.length;
    int _minus = (_length_2 - 1);
    newCommands[_minus] = newCommand;
    return newCommands;
  }
  
  private ICommand createBuilderCommand() throws CoreException {
    ICommand _xblockexpression = null;
    {
      IProject _project = this.getProject();
      IProjectDescription _description = _project.getDescription();
      ICommand newCommand = _description.newCommand();
      newCommand.setBuilderName(ScanBuilder.BUILDER_ID);
      _xblockexpression = newCommand;
    }
    return _xblockexpression;
  }
  
  public void deconfigure() throws CoreException {
    ICommand[] _builderCommands = this.getBuilderCommands();
    final Function1<ICommand,Boolean> _function = new Function1<ICommand,Boolean>() {
      public Boolean apply(final ICommand it) {
        String _builderName = it.getBuilderName();
        boolean _equals = _builderName.equals(ScanBuilder.BUILDER_ID);
        return Boolean.valueOf((!_equals));
      }
    };
    Iterable<ICommand> _filter = IterableExtensions.<ICommand>filter(((Iterable<ICommand>)Conversions.doWrapArray(_builderCommands)), _function);
    this.setBuilderCommands(((ICommand[])Conversions.unwrapArray(_filter, ICommand.class)));
  }
  
  public IProject getProject() {
    return this.project;
  }
  
  public void setProject(final IProject newProject) {
    this.project = newProject;
  }
}
