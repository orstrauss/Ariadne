/*******************************************************************************
 * Copyright (c) 2014 ARTIST Project
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
 * @author Oliver Strauﬂ
 */
public class XMLInfoExtractionHandler extends DefaultHandler {
	private boolean isRootChecked = false;

	private Map<String, String> prefixes = new HashMap<String, String>();

	private String rootElementName = null;

	private String rootElementUri = null;

	private XMLInfoExtractionHandler() {

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

		// for (int i = 0; i < attributes.getLength(); i++) {
		// System.out.println("  Attribute " + attributes.getQName(i) + "(" + attributes.getType(i)
		// + ") = " + attributes.getValue(i));
		// }

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
