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

import eu.artist.reusevol.wcm.ide.connector.modeling.utils.XMLInfoExtractionHandler;
import eu.artist.reusevol.wcm.model.modeling.Artefact;
import eu.artist.reusevol.wcm.model.modeling.Model;
import eu.artist.reusevol.wcm.model.modeling.ModelingFactory;

import org.eclipse.core.resources.IFile;

/**
 * A scanner for UML2 models.
 * 
 * @author Oliver Strauß
 */
public class UML2ContentTypeScanner implements IContentTypeScanner {
	public static final String ID = "org.eclipse.uml2.uml"; //$NON-NLS-1$

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
		Model result = ModelingFactory.eINSTANCE.createModel();
		try {
			XMLInfoExtractionHandler handler = XMLInfoExtractionHandler.getInfo(file.getContents());
			result.setNamespaceUri(handler.getPrefixes().get("uml")); //$NON-NLS-1$
		} catch (Exception e) {
			e.printStackTrace();
		}

		result.setName(file.getName());
		result.setIdentifier(file.getFullPath().toPortableString());
		return result;
	}
}
