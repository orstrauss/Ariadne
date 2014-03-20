/*******************************************************************************
 * Copyright (c) 2014 ARTIST project
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package eu.artist.reusevol.wcm.ide.connector.modeling.explorer;

import eu.artist.reusevol.wcm.ide.connector.modeling.scanner.ContentTypeScannerManager;
import eu.artist.reusevol.wcm.ide.connector.modeling.utils.ModelingConnectorMessage;
import eu.artist.reusevol.wcm.model.modeling.Artefact;
import eu.artist.reusevol.wcm.model.modeling.MegaModel;
import eu.artist.reusevol.wcm.model.modeling.ModelingFactory;

import fr.obeo.ariadne.ide.connector.core.explorer.AbstractAriadneExplorer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Explorer dedicated to pick up modeling artefacts and populate a mega-model.
 * 
 * @author Oliver Strauﬂ
 * @since 1.0
 */
public class ModelingExplorer extends AbstractAriadneExplorer {

	private final ContentTypeScannerManager manager;

	public ModelingExplorer() {
		this.manager = new ContentTypeScannerManager();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.ariadne.ide.connector.core.explorer.AbstractAriadneExplorer#getName()
	 */
	@Override
	public String getName() {
		return ModelingConnectorMessage.getString("ModelingExplorer.Name"); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.ariadne.ide.connector.core.explorer.AbstractAriadneExplorer#getExplorerKind()
	 */
	@Override
	public String getExplorerKind() {
		return AbstractAriadneExplorer.OTHER_EXPLORER_KIND;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.ariadne.ide.connector.core.explorer.AbstractAriadneExplorer#explore(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public IStatus explore(IProgressMonitor monitor) {
		long start = System.currentTimeMillis();

		List<Resource> resources = new ArrayList<>();
		for (IProject project : this.projects) {
			if (project.isAccessible() && project.isOpen()) {
				MegaModel ariadneComponent = this.doExplore(project, monitor);
				// Save the data computed
				resources.add(ariadneComponent.eResource());
			}
		}

		// Force the resolution of the proxies first

		for (Resource resource : resources) {
			try {
				HashMap<String, String> options = new HashMap<String, String>();
				resource.save(options);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		for (Resource resource : resources) {
			resource.unload();
		}

		long end = System.currentTimeMillis();

		System.out.print("Time: " + (end - start) + "ms");

		return Status.OK_STATUS;
	}

	/**
	 * Launches the exploration of the given project.
	 * 
	 * @param project
	 *            The project to explore
	 * @param monitor
	 *            The progress monitor
	 * @return The MegaModel representing the artefacts in the project.
	 */
	public MegaModel doExplore(IProject project, IProgressMonitor monitor) {
		MegaModel wcModel = this.getOrCreateMegaModel(project);

		try {
			ExplorationVisitor visitor = new ExplorationVisitor(wcModel);
			project.accept(visitor);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return wcModel;
	}

	private class ExplorationVisitor implements IResourceVisitor {
		private final MegaModel wcModel;

		public ExplorationVisitor(MegaModel model) {
			this.wcModel = model;
		}

		@Override
		public boolean visit(IResource resource) {
			// Skip folders
			if (resource instanceof IContainer) {
				return true;
			}

			// System.out.println("V : Visiting " + resource.getFullPath()); //$NON-NLS-1$
			IFile file = (IFile)resource;

			Artefact entity;
			try {
				entity = manager.exploreFile(file);
				if (entity != null) {
					wcModel.getElements().add(entity);
					System.out.println("Entity: " + entity); //$NON-NLS-1$
				}

			} catch (CoreException e) {
				e.printStackTrace();
			}

			return true;
		}
	}

	/**
	 * Gets or creates the MegaModel matching the given project.
	 * 
	 * @param project
	 *            The project
	 * @return The WCM MegaModel representing the project
	 */
	private MegaModel getOrCreateMegaModel(IProject project) {
		MegaModel model = null;

		List<MegaModel> models = this.ariadneProject.getMegaModels();
		for (MegaModel aModel : models) {
			if (project.getName().equals(aModel.getIdentifier())) {
				model = aModel;

				// Delete previous content since we are doing a full scan.
				model.getElements().clear();

				break;
			}
		}

		if (model == null) {
			model = ModelingFactory.eINSTANCE.createMegaModel();
			model.setIdentifier(project.getName());
			this.ariadneProject.getMegaModels().add(model);
		}
		return model;
	}
}
