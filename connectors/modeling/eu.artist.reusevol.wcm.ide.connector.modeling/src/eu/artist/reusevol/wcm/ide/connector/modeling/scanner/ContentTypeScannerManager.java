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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.content.IContentType;

/**
 * Registers supported ContentTypeExplorers and dispatches exploration to suitable explorers based on the
 * content type of the file to be explored.
 * 
 * @author Oliver Strauß
 */
public class ContentTypeScannerManager {
	private final Map<String, IContentTypeScanner> explorers;

	public ContentTypeScannerManager() {
		this.explorers = new HashMap<String, IContentTypeScanner>();

		register(new DefaultContentTypeScanner());
		register(new XMLContentTypeScanner());
		register(new UML2ContentTypeScanner());
	}

	public void register(IContentTypeScanner explorer) {
		explorers.put(explorer.contentTypeId(), explorer);
	}

	public void unRegister(IContentTypeScanner explorer) {
		explorers.remove(explorer.contentTypeId());
	}

	/**
	 * Explores the given file by delegating to a suitable explorer. Explorers are selected based on the
	 * file's content type starting from concrete to general content types. The first matching explorer is
	 * executed.
	 * 
	 * @param file
	 *            the file to explore
	 * @return an instance of Artefact as result of the exploration
	 * @throws CoreException
	 */
	public Artefact exploreFile(IFile file) throws CoreException {
		IContentDescription contentDescription = file.getContentDescription();

		if (contentDescription != null) {
			IContentType contentType = contentDescription.getContentType();
			System.out.print("Trying content type ");
			while (contentType != null) {
				System.out.print(contentType.getId() + " -> ");
				if (explorers.containsKey(contentType.getId())) {
					return explorers.get(contentType.getId()).exploreContent(file);
				}
				contentType = contentType.getBaseType();
			}
		}
		System.out.println();

		return null; // explorers.get(DefaultContentTypeScanner.ID).exploreContent(file);
	}
}
