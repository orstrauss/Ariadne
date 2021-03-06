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
package fr.obeo.ariadne.model.continuousintegration.provider;


import fr.obeo.ariadne.model.continuousintegration.BuildJob;
import fr.obeo.ariadne.model.continuousintegration.ContinuousintegrationFactory;
import fr.obeo.ariadne.model.continuousintegration.ContinuousintegrationPackage;

import fr.obeo.ariadne.model.core.CoreFactory;

import fr.obeo.ariadne.model.core.provider.VersionedElementItemProvider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link fr.obeo.ariadne.model.continuousintegration.BuildJob} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BuildJobItemProvider
  extends VersionedElementItemProvider
  implements
    IEditingDomainItemProvider,
    IStructuredItemContentProvider,
    ITreeItemContentProvider,
    IItemLabelProvider,
    IItemPropertySource
{
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BuildJobItemProvider(AdapterFactory adapterFactory)
  {
    super(adapterFactory);
  }

  /**
   * This returns the property descriptors for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object)
  {
    if (itemPropertyDescriptors == null)
    {
      super.getPropertyDescriptors(object);

      addUrlPropertyDescriptor(object);
      addBuildTechnologyKindsPropertyDescriptor(object);
      addBuildKindsPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Url feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addUrlPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_BuildJob_url_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_BuildJob_url_feature", "_UI_BuildJob_type"),
         ContinuousintegrationPackage.Literals.BUILD_JOB__URL,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Build Technology Kinds feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addBuildTechnologyKindsPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_BuildJob_buildTechnologyKinds_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_BuildJob_buildTechnologyKinds_feature", "_UI_BuildJob_type"),
         ContinuousintegrationPackage.Literals.BUILD_JOB__BUILD_TECHNOLOGY_KINDS,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Build Kinds feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addBuildKindsPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_BuildJob_buildKinds_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_BuildJob_buildKinds_feature", "_UI_BuildJob_type"),
         ContinuousintegrationPackage.Literals.BUILD_JOB__BUILD_KINDS,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
   * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
   * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object)
  {
    if (childrenFeatures == null)
    {
      super.getChildrenFeatures(object);
      childrenFeatures.add(ContinuousintegrationPackage.Literals.BUILD_JOB__ENTRIES);
      childrenFeatures.add(ContinuousintegrationPackage.Literals.BUILD_JOB__PROMOTION_LOCATIONS);
      childrenFeatures.add(ContinuousintegrationPackage.Literals.BUILD_JOB__BUILD_ARTIFACTS);
    }
    return childrenFeatures;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EStructuralFeature getChildFeature(Object object, Object child)
  {
    // Check the type of the specified child object and return the proper feature to use for
    // adding (see {@link AddCommand}) it as a child.

    return super.getChildFeature(object, child);
  }

  /**
   * This returns BuildJob.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object)
  {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/BuildJob"));
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object)
  {
    String label = ((BuildJob)object).getName();
    return label == null || label.length() == 0 ?
      getString("_UI_BuildJob_type") :
      getString("_UI_BuildJob_type") + " " + label;
  }

  /**
   * This handles model notifications by calling {@link #updateChildren} to update any cached
   * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void notifyChanged(Notification notification)
  {
    updateChildren(notification);

    switch (notification.getFeatureID(BuildJob.class))
    {
      case ContinuousintegrationPackage.BUILD_JOB__URL:
      case ContinuousintegrationPackage.BUILD_JOB__BUILD_TECHNOLOGY_KINDS:
      case ContinuousintegrationPackage.BUILD_JOB__BUILD_KINDS:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
        return;
      case ContinuousintegrationPackage.BUILD_JOB__ENTRIES:
      case ContinuousintegrationPackage.BUILD_JOB__PROMOTION_LOCATIONS:
      case ContinuousintegrationPackage.BUILD_JOB__BUILD_ARTIFACTS:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
        return;
    }
    super.notifyChanged(notification);
  }

  /**
   * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
   * that can be created under this object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object)
  {
    super.collectNewChildDescriptors(newChildDescriptors, object);

    newChildDescriptors.add
      (createChildParameter
        (ContinuousintegrationPackage.Literals.BUILD_JOB__ENTRIES,
         CoreFactory.eINSTANCE.createEntry()));

    newChildDescriptors.add
      (createChildParameter
        (ContinuousintegrationPackage.Literals.BUILD_JOB__PROMOTION_LOCATIONS,
         ContinuousintegrationFactory.eINSTANCE.createPromotionLocation()));

    newChildDescriptors.add
      (createChildParameter
        (ContinuousintegrationPackage.Literals.BUILD_JOB__BUILD_ARTIFACTS,
         ContinuousintegrationFactory.eINSTANCE.createBuildArtifact()));
  }

  /**
   * Return the resource locator for this item provider's resources.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ResourceLocator getResourceLocator()
  {
    return ContinuousintegrationEditPlugin.INSTANCE;
  }

}
