/*******************************************************************************
 * Copyright (c) 2014 ARTIST Project
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package eu.artist.reusevol.wcm.ide.connector.modeling.scanner;

import eu.artist.reusevol.wcm.ide.connector.modeling.utils.XMLInfoExtractionHandler;
import eu.artist.reusevol.wcm.model.modeling.Artefact;
import eu.artist.reusevol.wcm.model.modeling.Model;
import eu.artist.reusevol.wcm.model.modeling.ModelingFactory;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.xml.sax.SAXException;

/**
 * A scanner for UML2 models.
 * 
 * @author Oliver Strau�
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
			result.setDescription(handler.getPrefixes().get("uml"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		}

		result.setName(file.getName());
		result.setIdentifier(file.getProjectRelativePath().toPortableString());
		return result;
	}
}