/**
 */
package fr.obeo.ariadne.model.code.provider;


import fr.obeo.ariadne.model.code.CodeFactory;
import fr.obeo.ariadne.model.code.CodePackage;
import fr.obeo.ariadne.model.code.Operation;

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
 * This is the item provider adapter for a {@link fr.obeo.ariadne.model.code.Operation} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class OperationItemProvider
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
  public OperationItemProvider(AdapterFactory adapterFactory)
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

      addQualifiedNamePropertyDescriptor(object);
      addVisibilityPropertyDescriptor(object);
      addStaticPropertyDescriptor(object);
      addAbstractPropertyDescriptor(object);
      addFinalPropertyDescriptor(object);
      addImmutablePropertyDescriptor(object);
      addTransientPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Qualified Name feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addQualifiedNamePropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Operation_qualifiedName_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Operation_qualifiedName_feature", "_UI_Operation_type"),
         CodePackage.Literals.OPERATION__QUALIFIED_NAME,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Visibility feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addVisibilityPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Operation_visibility_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Operation_visibility_feature", "_UI_Operation_type"),
         CodePackage.Literals.OPERATION__VISIBILITY,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Static feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addStaticPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Operation_static_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Operation_static_feature", "_UI_Operation_type"),
         CodePackage.Literals.OPERATION__STATIC,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Abstract feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addAbstractPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Operation_abstract_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Operation_abstract_feature", "_UI_Operation_type"),
         CodePackage.Literals.OPERATION__ABSTRACT,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Final feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addFinalPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Operation_final_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Operation_final_feature", "_UI_Operation_type"),
         CodePackage.Literals.OPERATION__FINAL,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Immutable feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addImmutablePropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Operation_immutable_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Operation_immutable_feature", "_UI_Operation_type"),
         CodePackage.Literals.OPERATION__IMMUTABLE,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Transient feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addTransientPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Operation_transient_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Operation_transient_feature", "_UI_Operation_type"),
         CodePackage.Literals.OPERATION__TRANSIENT,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
      childrenFeatures.add(CodePackage.Literals.OPERATION__PARAMETERS);
      childrenFeatures.add(CodePackage.Literals.OPERATION__TYPING_DEPENDENCY);
      childrenFeatures.add(CodePackage.Literals.OPERATION__INHERITANCE_DEPENDENCY);
      childrenFeatures.add(CodePackage.Literals.OPERATION__REFERENCE_DEPENDENCIES);
      childrenFeatures.add(CodePackage.Literals.OPERATION__ANNOTATION_DEPENDENCIES);
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
   * This returns Operation.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object)
  {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/Operation"));
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
    String label = ((Operation)object).getName();
    return label == null || label.length() == 0 ?
      getString("_UI_Operation_type") :
      getString("_UI_Operation_type") + " " + label;
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

    switch (notification.getFeatureID(Operation.class))
    {
      case CodePackage.OPERATION__QUALIFIED_NAME:
      case CodePackage.OPERATION__VISIBILITY:
      case CodePackage.OPERATION__STATIC:
      case CodePackage.OPERATION__ABSTRACT:
      case CodePackage.OPERATION__FINAL:
      case CodePackage.OPERATION__IMMUTABLE:
      case CodePackage.OPERATION__TRANSIENT:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
        return;
      case CodePackage.OPERATION__PARAMETERS:
      case CodePackage.OPERATION__TYPING_DEPENDENCY:
      case CodePackage.OPERATION__INHERITANCE_DEPENDENCY:
      case CodePackage.OPERATION__REFERENCE_DEPENDENCIES:
      case CodePackage.OPERATION__ANNOTATION_DEPENDENCIES:
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
        (CodePackage.Literals.OPERATION__PARAMETERS,
         CodeFactory.eINSTANCE.createParameter()));

    newChildDescriptors.add
      (createChildParameter
        (CodePackage.Literals.OPERATION__TYPING_DEPENDENCY,
         CodeFactory.eINSTANCE.createTypingDependency()));

    newChildDescriptors.add
      (createChildParameter
        (CodePackage.Literals.OPERATION__INHERITANCE_DEPENDENCY,
         CodeFactory.eINSTANCE.createInheritanceDependency()));

    newChildDescriptors.add
      (createChildParameter
        (CodePackage.Literals.OPERATION__REFERENCE_DEPENDENCIES,
         CodeFactory.eINSTANCE.createReferenceDependency()));

    newChildDescriptors.add
      (createChildParameter
        (CodePackage.Literals.OPERATION__ANNOTATION_DEPENDENCIES,
         CodeFactory.eINSTANCE.createAnnotationDependency()));
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
    return CodeEditPlugin.INSTANCE;
  }

}
