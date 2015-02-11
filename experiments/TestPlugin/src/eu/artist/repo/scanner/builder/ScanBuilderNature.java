package eu.artist.repo.scanner.builder;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

public class ScanBuilderNature implements IProjectNature {

	/**
	 * ID of this project nature
	 */
	public static final String NATURE_ID = "TestPlugin.scanBuilderNature";

	private IProject project;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IProjectNature#configure()
	 */
	public void configure() throws CoreException {
		ICommand[] oldCommands = getBuilderCommands();

		if (isBuilderPresent(oldCommands)) return;
		
		setBuilderCommands(appendBuilderTo(oldCommands));
	}

	private ICommand[] getBuilderCommands() throws CoreException {
		return getProject().getDescription().getBuildSpec();
	}

	private boolean isBuilderPresent(ICommand[] commands) {
		for (int i = 0; i < commands.length; ++i) {
			if (commands[i].getBuilderName().equals(ScanBuilder.BUILDER_ID)) {
				return true;
			}
		}
		return false;
	}

	private void setBuilderCommands(ICommand[] newCommands)
			throws CoreException {
		IProjectDescription description = getProject().getDescription();
		description.setBuildSpec(newCommands);
		project.setDescription(description, null);
	}

	private ICommand[] appendBuilderTo(ICommand[] oldCommands) throws CoreException {
		return appendCommand(oldCommands, createBuilderCommand());
	}

	private ICommand[] appendCommand(ICommand[] oldCommands, ICommand newCommand) {
		ICommand[] newCommands = new ICommand[oldCommands.length + 1];
		System.arraycopy(oldCommands, 0, newCommands, 0, oldCommands.length);
		newCommands[newCommands.length - 1] = newCommand;
		return newCommands;
	}

	private ICommand createBuilderCommand() throws CoreException {
		ICommand newCommand = getProject().getDescription().newCommand();
		newCommand.setBuilderName(ScanBuilder.BUILDER_ID);
		return newCommand;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IProjectNature#deconfigure()
	 */
	public void deconfigure() throws CoreException {
		ICommand[] oldCommands = getBuilderCommands();
		for (int i = 0; i < oldCommands.length; ++i) {
			if (oldCommands[i].getBuilderName().equals(ScanBuilder.BUILDER_ID)) {
				ICommand[] newCommands = removeCommandAtIndex(oldCommands, i);
				setBuilderCommands(newCommands);			
				return;
			}
		}
	}

	private ICommand[] removeCommandAtIndex(ICommand[] commands, int index) {
		ICommand[] newCommands = new ICommand[commands.length - 1];
		System.arraycopy(commands, 0, newCommands, 0, index);
		System.arraycopy(commands, index + 1, newCommands, index,
				commands.length - index - 1);
		return newCommands;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IProjectNature#getProject()
	 */
	public IProject getProject() {
		return project;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IProjectNature#setProject(org.eclipse.core.resources.IProject)
	 */
	public void setProject(IProject project) {
		this.project = project;
	}

}
