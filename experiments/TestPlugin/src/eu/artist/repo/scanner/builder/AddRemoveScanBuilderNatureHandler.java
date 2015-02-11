package eu.artist.repo.scanner.builder;

import java.util.Iterator;

import org.eclipse.core.commands.*;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

public class AddRemoveScanBuilderNatureHandler extends AbstractHandler {

	private ISelection selection;

	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		//
		if (selection instanceof IStructuredSelection) {
			for (Iterator<?> it = ((IStructuredSelection) selection).iterator(); it
					.hasNext();) {
				Object element = it.next();
				IProject project = getProjectFromSelectionElement(element);
				if (project != null) {
					try {
						toggleNature(project);
					} catch (CoreException e) {
						//TODO log something
						throw new ExecutionException("Failed to toggle nature",
								e);
					}
				}
			}
		}

		return null;
	}

	private IProject getProjectFromSelectionElement(Object element) {
		IProject project = null;
		if (element instanceof IProject) {
			project = (IProject) element;
		} else if (element instanceof IAdaptable) {
			project = (IProject) ((IAdaptable) element)
					.getAdapter(IProject.class);
		}
		return project;
	}

	/**
	 * Toggles sample nature on a project
	 *
	 * @param project
	 *            to have sample nature added or removed
	 */
	private void toggleNature(IProject project) throws CoreException {
		IProjectDescription description = project.getDescription();
		String[] natures = description.getNatureIds();

		for (int i = 0; i < natures.length; ++i) {
			if (ScanBuilderNature.NATURE_ID.equals(natures[i])) {
				// Remove the nature
				String[] newNatures = removeNatureAtIndex(natures, i);
				description.setNatureIds(newNatures);
				project.setDescription(description, null);
				Activator.getDefault().print("Removing nature.");
				return;
			}
		}

		// Add the nature
		description.setNatureIds(addNature(natures));
		project.setDescription(description, null);
		Activator.getDefault().print("Adding nature.");
	}

	private String[] addNature(String[] natures) {
		String[] newNatures = new String[natures.length + 1];
		System.arraycopy(natures, 0, newNatures, 0, natures.length);
		newNatures[natures.length] = ScanBuilderNature.NATURE_ID;
		return newNatures;
	}

	private String[] removeNatureAtIndex(String[] natures, int i) {
		String[] newNatures = new String[natures.length - 1];
		System.arraycopy(natures, 0, newNatures, 0, i);
		System.arraycopy(natures, i + 1, newNatures, i, natures.length - i - 1);
		return newNatures;
	}

}