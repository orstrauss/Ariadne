/*******************************************************************************
 * Copyright (c) 2014 Fraunhofer IAO.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Oliver Strauß (Fraunhofer IAO) - initial API
 *
 * Initially developed in the context of the ARTIST EU project http://www.artist-project.eu
 *******************************************************************************/
package eu.artist.reusevol.wcm.ide.connector.modeling.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * Class that extracts the name of the first element and the namespace mappings from an XML file.
 * 
 * @author Oliver Strauß
 */
public class XMLInfoExtractionHandler extends DefaultHandler {
	private boolean isRootChecked = false;

	private String rootElementName;

	private String rootElementUri;

	private final Map<String, String> prefixes;

	private final Map<String, String> schemaLocations;

	private XMLInfoExtractionHandler() {
		rootElementName = null;
		rootElementUri = null;
		prefixes = new HashMap<String, String>();
		schemaLocations = new HashMap<String, String>();
	}

	public static XMLInfoExtractionHandler getInfo(InputStream input) throws SAXException,
			FileNotFoundException, IOException {
		XMLReader xr;
		xr = XMLReaderFactory.createXMLReader();

		XMLInfoExtractionHandler handler = new XMLInfoExtractionHandler();

		xr.setContentHandler(handler);
		xr.setErrorHandler(handler);
		xr.parse(new InputSource(input));

		return handler;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes)
			throws SAXException {
		if (isRootChecked) {
			return;
		}
		rootElementName = qName;
		rootElementUri = uri;

		System.out.println("URI       : " + uri);
		System.out.println("Local name: " + localName);
		System.out.println("Qname     : " + qName);

		/*
		 * for (int i = 0; i < attributes.getLength(); i++) { System.out.println("  Attribute " +
		 * attributes.getQName(i) + "(" + attributes.getType(i) + ") = " + attributes.getValue(i)); String
		 * lName = attributes.getLocalName(i); if (lName.equalsIgnoreCase("schemaLocation")) { String mapping
		 * = attributes.getValue(i); String[] entries = mapping.split(" "); for (int j = 0; j <
		 * mapping.length(); j++) { String key = null; String value = null; if (j % 2 == 0) { key =
		 * entries[j]; } else { value = entries[j]; schemaLocations.put(key, value); } } } }
		 */
		isRootChecked = true;
	}

	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		prefixes.put(prefix, uri);
		System.out.printf("  Mapping: %s = %s%n", prefix, uri); //$NON-NLS-1$
	}

	public Map<String, String> getPrefixes() {
		return prefixes;
	}

	public String getName() {
		return rootElementName;
	}

	public String getUri() {
		return rootElementUri;
	}

}
