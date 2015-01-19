/*******************************************************************************
 * Copyright (c) 2014 Fraunhofer IAO.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Oliver Strauß (Fraunhofer IAO) - initial contribution
 *
 * Initially developed in the context of the ARTIST EU project http://www.artist-project.eu
 *******************************************************************************/

package eu.artist.reusevol.wcm.ide.connector.modeling.scanner;

import eu.artist.reusevol.wcm.model.modeling.Artefact;
import eu.artist.reusevol.wcm.model.modeling.ModelingFactory;

import org.eclipse.core.resources.IFile;

/**
 * Default scanner that is used if no other scanner has matched.
 * 
 * @author Oliver Strauß
 */
public class DefaultContentTypeScanner implements IContentTypeScanner {
	public static final String ID = "default"; //$NON-NLS-1$

	/**
	 * {@inheritDoc}
	 * 
	 * @see eu.artist.reusevol.wcm.ide.connector.modeling.scanner.IContentTypeScanner#contentTypeId()
	 */
	@Override
	public String contentTypeId() {
		return ID;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see eu.artist.reusevol.wcm.ide.connector.modeling.scanner.IContentTypeScanner#exploreContent(org.eclipse.core.resources.IFile)
	 */
	@Override
	public Artefact exploreContent(IFile file) {
		Artefact result = ModelingFactory.eINSTANCE.createArtefact();
		result.setName(file.getName());
		result.setIdentifier(file.getProjectRelativePath().toPortableString());
		return result;
	}
}
