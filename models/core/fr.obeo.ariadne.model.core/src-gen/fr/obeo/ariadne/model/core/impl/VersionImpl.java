/**
 * Copyright (c) 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Stephane Begaudeau (Obeo) - initial API and implementation
 */
package fr.obeo.ariadne.model.core.impl;

import fr.obeo.ariadne.model.core.CorePackage;
import fr.obeo.ariadne.model.core.Version;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Version</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.obeo.ariadne.model.core.impl.VersionImpl#getMajor <em>Major</em>}</li>
 *   <li>{@link fr.obeo.ariadne.model.core.impl.VersionImpl#getMinor <em>Minor</em>}</li>
 *   <li>{@link fr.obeo.ariadne.model.core.impl.VersionImpl#getPatch <em>Patch</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VersionImpl extends MinimalEObjectImpl.Container implements Version
{
  /**
   * The default value of the '{@link #getMajor() <em>Major</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMajor()
   * @generated
   * @ordered
   */
  protected static final int MAJOR_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getMajor() <em>Major</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMajor()
   * @generated
   * @ordered
   */
  protected int major = MAJOR_EDEFAULT;

  /**
   * The default value of the '{@link #getMinor() <em>Minor</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMinor()
   * @generated
   * @ordered
   */
  protected static final int MINOR_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getMinor() <em>Minor</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMinor()
   * @generated
   * @ordered
   */
  protected int minor = MINOR_EDEFAULT;

  /**
   * The default value of the '{@link #getPatch() <em>Patch</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPatch()
   * @generated
   * @ordered
   */
  protected static final int PATCH_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getPatch() <em>Patch</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPatch()
   * @generated
   * @ordered
   */
  protected int patch = PATCH_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VersionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return CorePackage.Literals.VERSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getMajor()
  {
    return major;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMajor(int newMajor)
  {
    int oldMajor = major;
    major = newMajor;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.VERSION__MAJOR, oldMajor, major));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getMinor()
  {
    return minor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMinor(int newMinor)
  {
    int oldMinor = minor;
    minor = newMinor;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.VERSION__MINOR, oldMinor, minor));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getPatch()
  {
    return patch;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPatch(int newPatch)
  {
    int oldPatch = patch;
    patch = newPatch;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.VERSION__PATCH, oldPatch, patch));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case CorePackage.VERSION__MAJOR:
        return getMajor();
      case CorePackage.VERSION__MINOR:
        return getMinor();
      case CorePackage.VERSION__PATCH:
        return getPatch();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case CorePackage.VERSION__MAJOR:
        setMajor((Integer)newValue);
        return;
      case CorePackage.VERSION__MINOR:
        setMinor((Integer)newValue);
        return;
      case CorePackage.VERSION__PATCH:
        setPatch((Integer)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case CorePackage.VERSION__MAJOR:
        setMajor(MAJOR_EDEFAULT);
        return;
      case CorePackage.VERSION__MINOR:
        setMinor(MINOR_EDEFAULT);
        return;
      case CorePackage.VERSION__PATCH:
        setPatch(PATCH_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case CorePackage.VERSION__MAJOR:
        return major != MAJOR_EDEFAULT;
      case CorePackage.VERSION__MINOR:
        return minor != MINOR_EDEFAULT;
      case CorePackage.VERSION__PATCH:
        return patch != PATCH_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (major: ");
    result.append(major);
    result.append(", minor: ");
    result.append(minor);
    result.append(", patch: ");
    result.append(patch);
    result.append(')');
    return result.toString();
  }

} //VersionImpl
