package eu.artist.repo.scanner.builder

import java.util.List
import java.util.concurrent.ExecutionException
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IProjectDescription
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IAdaptable
import org.eclipse.jface.viewers.ISelection
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.ui.handlers.HandlerUtil

class AddRemoveScanBuilderNatureHandler2 extends AbstractHandler {
	override Object execute(ExecutionEvent event) {
		val ISelection selection = HandlerUtil.getCurrentSelection(event);

		if (selection instanceof IStructuredSelection) {
			val items = (selection as IStructuredSelection).iterator
			while (items.hasNext) {
				val element = items.next()
				val IProject project = getProjectFromSelectionElement(element);
				if (project != null) {
					try {
						toggleNature(project)
					} catch (CoreException e) {
						throw new ExecutionException("Failed to toggle nature", e)
					}
				}
			}
		}
		null
	}
	
	private def IProject getProjectFromSelectionElement(Object element) {
		switch element {
			case IProject : element as IProject
			case IAdaptable : (element as IAdaptable).getAdapter(typeof(IProject)) as IProject
			default : null
		}
	}
	
	private def toggleNature(IProject project) throws CoreException {
		val IProjectDescription description = project.description
		val List<String> natures = description.getNatureIds();

		if (natures.contains(ScanBuilderNature.NATURE_ID)) {
			natures.remove(ScanBuilderNature.NATURE_ID)
		} else {
			natures.add(ScanBuilderNature.NATURE_ID)
		}

		// Add the nature
		description.natureIds = natures
		project.setDescription(description, null)
		Activator2.^default.print("Adding nature.")
	}	
}
