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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * @author Oliver Strauﬂ
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
	public Entity exploreContent(IFile file) {
		Entity result = ModelingFactory.eINSTANCE.createEntity();
		result.setName(file.getName());
		result.setIdentifier(file.getProjectRelativePath().toPortableString());

		try {
			getVersion(file.getContents());
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

	private static class VersionHandler extends DefaultHandler {
		private int version = -1;

		/*
		 * @Override public void startElement(String uri, String localName, String qName, Attributes
		 * attributes) throws SAXException { System.out.println("URI       : " + uri);
		 * System.out.println("Local name: " + uri); System.out.println("Qname     : " + uri); for (int i = 0;
		 * i < attributes.getLength(); i++) { System.out.println("  Attribute " + attributes.getQName(i) + "("
		 * + attributes.getType(i) + ") = " + attributes.getValue(i)); } }
		 */

		@Override
		public void startPrefixMapping(String prefix, String uri) throws SAXException {
			System.out.printf("  Mapping: %s = %s", prefix, uri); //$NON-NLS-1$
		}

		public int getVersion() {
			return version;
		}
	}

	public static int getVersion(InputStream input) throws SAXException, FileNotFoundException, IOException {
		XMLReader xr;
		xr = XMLReaderFactory.createXMLReader();

		VersionHandler versionHandler = new VersionHandler();

		xr.setContentHandler(versionHandler);
		xr.setErrorHandler(versionHandler);
		xr.parse(new InputSource(input));

		return versionHandler.getVersion();
	}
}
