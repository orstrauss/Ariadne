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

import org.eclipse.core.resources.IFile;

/**
 * Interface for file type specific explorers that try to extract type specific information from a specific
 * file type.
 * 
 * @author Oliver Strauß
 */
public interface IContentTypeScanner {

	/**
	 * The content type this explorer can handle.
	 * 
	 * @return the content type this explorer can handle
	 */
	public String contentTypeId();

	/**
	 * Explores a file resource and tries to extract type specific information from it.
	 * 
	 * @param the
	 *            input file
	 * @return an entity of the WCM model containing the extracted information
	 */
	public Artefact exploreContent(IFile file);
}
