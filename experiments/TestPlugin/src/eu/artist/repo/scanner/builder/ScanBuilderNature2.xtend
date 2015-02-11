package eu.artist.repo.scanner.builder

import org.eclipse.core.resources.ICommand
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IProjectNature
import org.eclipse.core.runtime.CoreException

class ScanBuilderNature2 implements IProjectNature {
	public val static String NATURE_ID = "TestPlugin.scanBuilderNature";
	var IProject project;
	
	override configure() throws CoreException {
		val ICommand[] oldCommands = builderCommands;		
		if (isBuilderPresent(oldCommands)) return;		
		builderCommands = appendBuilderTo(oldCommands);
	}
	
	private def getBuilderCommands() throws CoreException {
		getProject().description.buildSpec
	}
	
	private def isBuilderPresent(ICommand[] commands) {
		commands.filter([builderName == ScanBuilder.BUILDER_ID]).size > 0
	}
	
	private def setBuilderCommands(ICommand[] newCommands)
			throws CoreException {
		val description = getProject().description
		description.buildSpec = newCommands
		getProject().setDescription(description, null)
	}
	
	private def appendBuilderTo(ICommand[] oldCommands) throws CoreException {
		appendCommand(oldCommands, createBuilderCommand())
	}	
	
	private def appendCommand(ICommand[] oldCommands, ICommand newCommand) {
		var ICommand[] newCommands = newArrayOfSize(oldCommands.length + 1)
		System.arraycopy(oldCommands, 0, newCommands, 0, oldCommands.length)
		newCommands.set(newCommands.length - 1, newCommand)
		return newCommands
	}	

	private def createBuilderCommand() throws CoreException {
		var newCommand = getProject().description.newCommand()
		newCommand.builderName = ScanBuilder.BUILDER_ID
		newCommand
	}	
	
	override deconfigure() throws CoreException {
		builderCommands = builderCommands.filter[!builderName.equals(ScanBuilder.BUILDER_ID)]	
	}
	
	override getProject() {
		project
	}
	
	override setProject(IProject newProject) {
		project = newProject
	}	
}