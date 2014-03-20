/*******************************************************************************
 * Copyright (c) 2014 ARTIST Project
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package eu.artist.reusevol.wcm.ide.connector.modeling.scanner;

import eu.artist.reusevol.wcm.model.modeling.Entity;
import eu.artist.reusevol.wcm.model.modeling.ModelingFactory;

import org.eclipse.core.resources.IFile;

/**
 * @author Oliver Strauﬂ
 */
public class DefaultContentTypeScanner implements IContentTypeScanner {

	/**
	 * {@inheritDoc}
	 * 
	 * @see eu.artist.reusevol.wcm.ide.connector.modeling.scanner.IContentTypeScanner#contentTypeId()
	 */
	@Override
	public String contentTypeId() {
		return "default"; //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see eu.artist.reusevol.wcm.ide.connector.modeling.scanner.IContentTypeScanner#exploreContent(org.eclipse.core.resources.IFile)
	 */
	@Override
	public Entity exploreContent(IFile file) {
		Entity result = ModelingFactory.eINSTANCE.createEntity();
		result.setName(file.getName());
		result.setIdentifier(file.getProjectRelativePath().toPortableString());
		return result;
	}
}
