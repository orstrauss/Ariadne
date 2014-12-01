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
import eu.artist.reusevol.wcm.model.modeling.ModelingFactory;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.xml.sax.SAXException;

/**
 * @author Oliver Strauß
 */
public class XMLContentTypeScanner implements IContentTypeScanner {

	/**
	 * {@inheritDoc}
	 * 
	 * @see eu.artist.reusevol.wcm.ide.connector.modeling.scanner.IContentTypeScanner#contentTypeId()
	 */
	@Override
	public String contentTypeId() {
		return "org.eclipse.core.runtime.xml"; //$NON-NLS-1$
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
		result.setIdentifier(file.getFullPath().toPortableString());

		try {
			XMLInfoExtractionHandler handler = XMLInfoExtractionHandler.getInfo(file.getContents());
			result.setDescription(handler.getPrefixes().get(""));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		}

		return result;
	}
}
