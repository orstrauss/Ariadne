/*******************************************************************************
 * Copyright (c) 2014 ARTIST project
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package eu.artist.reusevol.wcm.ide.connector.modeling.utils;

/**
 * Utility class holding a set of constants for the modeling connector.
 * 
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @author Oliver Strauﬂ
 * @since 1.0
 */
public interface IModelingConnectorConstants {
	/**
	 * "@since".
	 */
	String AT_SINCE = "@since"; //$NON-NLS-1$

	/**
	 * Static.
	 */
	String STATIC = "static"; //$NON-NLS-1$

	/**
	 * Final.
	 */
	String FINAL = "final"; //$NON-NLS-1$

	/**
	 * The qualified name of the deprecated annotation.
	 */
	String DEPRECATED_ANNOTATION = "java.lang.Deprecated"; //$NON-NLS-1$
}
