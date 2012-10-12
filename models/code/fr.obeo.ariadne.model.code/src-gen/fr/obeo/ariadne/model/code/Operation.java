/**
 */
package fr.obeo.ariadne.model.code;

import fr.obeo.ariadne.model.core.VersionedElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.obeo.ariadne.model.code.Operation#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link fr.obeo.ariadne.model.code.Operation#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link fr.obeo.ariadne.model.code.Operation#isStatic <em>Static</em>}</li>
 *   <li>{@link fr.obeo.ariadne.model.code.Operation#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link fr.obeo.ariadne.model.code.Operation#isFinal <em>Final</em>}</li>
 *   <li>{@link fr.obeo.ariadne.model.code.Operation#isImmutable <em>Immutable</em>}</li>
 *   <li>{@link fr.obeo.ariadne.model.code.Operation#isTransient <em>Transient</em>}</li>
 *   <li>{@link fr.obeo.ariadne.model.code.Operation#getParameters <em>Parameters</em>}</li>
 *   <li>{@link fr.obeo.ariadne.model.code.Operation#getTypingDependencies <em>Typing Dependencies</em>}</li>
 *   <li>{@link fr.obeo.ariadne.model.code.Operation#getInheritanceDependencies <em>Inheritance Dependencies</em>}</li>
 *   <li>{@link fr.obeo.ariadne.model.code.Operation#getReferenceDependencies <em>Reference Dependencies</em>}</li>
 *   <li>{@link fr.obeo.ariadne.model.code.Operation#getAnnotationDependencies <em>Annotation Dependencies</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.obeo.ariadne.model.code.CodePackage#getOperation()
 * @model
 * @generated
 */
public interface Operation extends VersionedElement
{
  /**
   * Returns the value of the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Qualified Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Qualified Name</em>' attribute.
   * @see #setQualifiedName(String)
   * @see fr.obeo.ariadne.model.code.CodePackage#getOperation_QualifiedName()
   * @model unique="false"
   * @generated
   */
  String getQualifiedName();

  /**
   * Sets the value of the '{@link fr.obeo.ariadne.model.code.Operation#getQualifiedName <em>Qualified Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Qualified Name</em>' attribute.
   * @see #getQualifiedName()
   * @generated
   */
  void setQualifiedName(String value);

  /**
   * Returns the value of the '<em><b>Visibility</b></em>' attribute.
   * The literals are from the enumeration {@link fr.obeo.ariadne.model.code.VisibilityKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Visibility</em>' attribute.
   * @see fr.obeo.ariadne.model.code.VisibilityKind
   * @see #setVisibility(VisibilityKind)
   * @see fr.obeo.ariadne.model.code.CodePackage#getOperation_Visibility()
   * @model unique="false"
   * @generated
   */
  VisibilityKind getVisibility();

  /**
   * Sets the value of the '{@link fr.obeo.ariadne.model.code.Operation#getVisibility <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Visibility</em>' attribute.
   * @see fr.obeo.ariadne.model.code.VisibilityKind
   * @see #getVisibility()
   * @generated
   */
  void setVisibility(VisibilityKind value);

  /**
   * Returns the value of the '<em><b>Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Static</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Static</em>' attribute.
   * @see #setStatic(boolean)
   * @see fr.obeo.ariadne.model.code.CodePackage#getOperation_Static()
   * @model unique="false"
   * @generated
   */
  boolean isStatic();

  /**
   * Sets the value of the '{@link fr.obeo.ariadne.model.code.Operation#isStatic <em>Static</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Static</em>' attribute.
   * @see #isStatic()
   * @generated
   */
  void setStatic(boolean value);

  /**
   * Returns the value of the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Abstract</em>' attribute.
   * @see #setAbstract(boolean)
   * @see fr.obeo.ariadne.model.code.CodePackage#getOperation_Abstract()
   * @model unique="false"
   * @generated
   */
  boolean isAbstract();

  /**
   * Sets the value of the '{@link fr.obeo.ariadne.model.code.Operation#isAbstract <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Abstract</em>' attribute.
   * @see #isAbstract()
   * @generated
   */
  void setAbstract(boolean value);

  /**
   * Returns the value of the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Final</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Final</em>' attribute.
   * @see #setFinal(boolean)
   * @see fr.obeo.ariadne.model.code.CodePackage#getOperation_Final()
   * @model unique="false"
   * @generated
   */
  boolean isFinal();

  /**
   * Sets the value of the '{@link fr.obeo.ariadne.model.code.Operation#isFinal <em>Final</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Final</em>' attribute.
   * @see #isFinal()
   * @generated
   */
  void setFinal(boolean value);

  /**
   * Returns the value of the '<em><b>Immutable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Immutable</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Immutable</em>' attribute.
   * @see #setImmutable(boolean)
   * @see fr.obeo.ariadne.model.code.CodePackage#getOperation_Immutable()
   * @model unique="false"
   * @generated
   */
  boolean isImmutable();

  /**
   * Sets the value of the '{@link fr.obeo.ariadne.model.code.Operation#isImmutable <em>Immutable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Immutable</em>' attribute.
   * @see #isImmutable()
   * @generated
   */
  void setImmutable(boolean value);

  /**
   * Returns the value of the '<em><b>Transient</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transient</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transient</em>' attribute.
   * @see #setTransient(boolean)
   * @see fr.obeo.ariadne.model.code.CodePackage#getOperation_Transient()
   * @model unique="false"
   * @generated
   */
  boolean isTransient();

  /**
   * Sets the value of the '{@link fr.obeo.ariadne.model.code.Operation#isTransient <em>Transient</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Transient</em>' attribute.
   * @see #isTransient()
   * @generated
   */
  void setTransient(boolean value);

  /**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
   * The list contents are of type {@link fr.obeo.ariadne.model.code.Parameter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference list.
   * @see fr.obeo.ariadne.model.code.CodePackage#getOperation_Parameters()
   * @model containment="true"
   * @generated
   */
  EList<Parameter> getParameters();

  /**
   * Returns the value of the '<em><b>Typing Dependencies</b></em>' containment reference list.
   * The list contents are of type {@link fr.obeo.ariadne.model.code.TypingDependency}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Typing Dependencies</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Typing Dependencies</em>' containment reference list.
   * @see fr.obeo.ariadne.model.code.CodePackage#getOperation_TypingDependencies()
   * @model containment="true"
   * @generated
   */
  EList<TypingDependency> getTypingDependencies();

  /**
   * Returns the value of the '<em><b>Inheritance Dependencies</b></em>' containment reference list.
   * The list contents are of type {@link fr.obeo.ariadne.model.code.InheritanceDependency}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inheritance Dependencies</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inheritance Dependencies</em>' containment reference list.
   * @see fr.obeo.ariadne.model.code.CodePackage#getOperation_InheritanceDependencies()
   * @model containment="true"
   * @generated
   */
  EList<InheritanceDependency> getInheritanceDependencies();

  /**
   * Returns the value of the '<em><b>Reference Dependencies</b></em>' containment reference list.
   * The list contents are of type {@link fr.obeo.ariadne.model.code.ReferenceDependency}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reference Dependencies</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reference Dependencies</em>' containment reference list.
   * @see fr.obeo.ariadne.model.code.CodePackage#getOperation_ReferenceDependencies()
   * @model containment="true"
   * @generated
   */
  EList<ReferenceDependency> getReferenceDependencies();

  /**
   * Returns the value of the '<em><b>Annotation Dependencies</b></em>' containment reference list.
   * The list contents are of type {@link fr.obeo.ariadne.model.code.AnnotationDependency}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Annotation Dependencies</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Annotation Dependencies</em>' containment reference list.
   * @see fr.obeo.ariadne.model.code.CodePackage#getOperation_AnnotationDependencies()
   * @model containment="true"
   * @generated
   */
  EList<AnnotationDependency> getAnnotationDependencies();

} // Operation
