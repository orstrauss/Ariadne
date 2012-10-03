/**
 */
package fr.obeo.ariadne.model.tasks;

import fr.obeo.ariadne.model.core.CorePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see fr.obeo.ariadne.model.tasks.TasksFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel basePackage='fr.obeo.ariadne.model' editDirectory='/fr.obeo.ariadne.model.tasks.edit/src-gen' editorDirectory='/fr.obeo.ariadne.model.tasks.editor/src-gen' fileExtensions='ariadnetasks'"
 * @generated
 */
public interface TasksPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "tasks";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.obeo.fr/dsl/Ariadne/Tasks";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "ariadne-tasks";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TasksPackage eINSTANCE = fr.obeo.ariadne.model.tasks.impl.TasksPackageImpl.init();

  /**
   * The meta object id for the '{@link fr.obeo.ariadne.model.tasks.impl.TasksRepositoryImpl <em>Repository</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.obeo.ariadne.model.tasks.impl.TasksRepositoryImpl
   * @see fr.obeo.ariadne.model.tasks.impl.TasksPackageImpl#getTasksRepository()
   * @generated
   */
  int TASKS_REPOSITORY = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASKS_REPOSITORY__NAME = CorePackage.ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASKS_REPOSITORY__DESCRIPTION = CorePackage.ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Authors</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASKS_REPOSITORY__AUTHORS = CorePackage.ELEMENT__AUTHORS;

  /**
   * The feature id for the '<em><b>Properties</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASKS_REPOSITORY__PROPERTIES = CorePackage.ELEMENT__PROPERTIES;

  /**
   * The feature id for the '<em><b>Url</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASKS_REPOSITORY__URL = CorePackage.ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Repository</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASKS_REPOSITORY_FEATURE_COUNT = CorePackage.ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Repository</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASKS_REPOSITORY_OPERATION_COUNT = CorePackage.ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link fr.obeo.ariadne.model.tasks.impl.TaskImpl <em>Task</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.obeo.ariadne.model.tasks.impl.TaskImpl
   * @see fr.obeo.ariadne.model.tasks.impl.TasksPackageImpl#getTask()
   * @generated
   */
  int TASK = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK__NAME = CorePackage.ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK__DESCRIPTION = CorePackage.ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Authors</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK__AUTHORS = CorePackage.ELEMENT__AUTHORS;

  /**
   * The feature id for the '<em><b>Properties</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK__PROPERTIES = CorePackage.ELEMENT__PROPERTIES;

  /**
   * The feature id for the '<em><b>Url</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK__URL = CorePackage.ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK__IDENTIFIER = CorePackage.ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Task Entries</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK__TASK_ENTRIES = CorePackage.ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Elements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK__ELEMENTS = CorePackage.ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Task</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_FEATURE_COUNT = CorePackage.ELEMENT_FEATURE_COUNT + 4;

  /**
   * The number of operations of the '<em>Task</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_OPERATION_COUNT = CorePackage.ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link fr.obeo.ariadne.model.tasks.impl.TaskEntryImpl <em>Task Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.obeo.ariadne.model.tasks.impl.TaskEntryImpl
   * @see fr.obeo.ariadne.model.tasks.impl.TasksPackageImpl#getTaskEntry()
   * @generated
   */
  int TASK_ENTRY = 2;

  /**
   * The feature id for the '<em><b>Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_ENTRY__IDENTIFIER = 0;

  /**
   * The feature id for the '<em><b>Values</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_ENTRY__VALUES = 1;

  /**
   * The feature id for the '<em><b>Options</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_ENTRY__OPTIONS = 2;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_ENTRY__KIND = 3;

  /**
   * The number of structural features of the '<em>Task Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_ENTRY_FEATURE_COUNT = 4;

  /**
   * The number of operations of the '<em>Task Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_ENTRY_OPERATION_COUNT = 0;


  /**
   * Returns the meta object for class '{@link fr.obeo.ariadne.model.tasks.TasksRepository <em>Repository</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Repository</em>'.
   * @see fr.obeo.ariadne.model.tasks.TasksRepository
   * @generated
   */
  EClass getTasksRepository();

  /**
   * Returns the meta object for the attribute '{@link fr.obeo.ariadne.model.tasks.TasksRepository#getUrl <em>Url</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Url</em>'.
   * @see fr.obeo.ariadne.model.tasks.TasksRepository#getUrl()
   * @see #getTasksRepository()
   * @generated
   */
  EAttribute getTasksRepository_Url();

  /**
   * Returns the meta object for class '{@link fr.obeo.ariadne.model.tasks.Task <em>Task</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Task</em>'.
   * @see fr.obeo.ariadne.model.tasks.Task
   * @generated
   */
  EClass getTask();

  /**
   * Returns the meta object for the attribute '{@link fr.obeo.ariadne.model.tasks.Task#getUrl <em>Url</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Url</em>'.
   * @see fr.obeo.ariadne.model.tasks.Task#getUrl()
   * @see #getTask()
   * @generated
   */
  EAttribute getTask_Url();

  /**
   * Returns the meta object for the attribute '{@link fr.obeo.ariadne.model.tasks.Task#getIdentifier <em>Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Identifier</em>'.
   * @see fr.obeo.ariadne.model.tasks.Task#getIdentifier()
   * @see #getTask()
   * @generated
   */
  EAttribute getTask_Identifier();

  /**
   * Returns the meta object for the containment reference list '{@link fr.obeo.ariadne.model.tasks.Task#getTaskEntries <em>Task Entries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Task Entries</em>'.
   * @see fr.obeo.ariadne.model.tasks.Task#getTaskEntries()
   * @see #getTask()
   * @generated
   */
  EReference getTask_TaskEntries();

  /**
   * Returns the meta object for the reference list '{@link fr.obeo.ariadne.model.tasks.Task#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Elements</em>'.
   * @see fr.obeo.ariadne.model.tasks.Task#getElements()
   * @see #getTask()
   * @generated
   */
  EReference getTask_Elements();

  /**
   * Returns the meta object for class '{@link fr.obeo.ariadne.model.tasks.TaskEntry <em>Task Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Task Entry</em>'.
   * @see fr.obeo.ariadne.model.tasks.TaskEntry
   * @generated
   */
  EClass getTaskEntry();

  /**
   * Returns the meta object for the attribute '{@link fr.obeo.ariadne.model.tasks.TaskEntry#getIdentifier <em>Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Identifier</em>'.
   * @see fr.obeo.ariadne.model.tasks.TaskEntry#getIdentifier()
   * @see #getTaskEntry()
   * @generated
   */
  EAttribute getTaskEntry_Identifier();

  /**
   * Returns the meta object for the attribute list '{@link fr.obeo.ariadne.model.tasks.TaskEntry#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Values</em>'.
   * @see fr.obeo.ariadne.model.tasks.TaskEntry#getValues()
   * @see #getTaskEntry()
   * @generated
   */
  EAttribute getTaskEntry_Values();

  /**
   * Returns the meta object for the attribute list '{@link fr.obeo.ariadne.model.tasks.TaskEntry#getOptions <em>Options</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Options</em>'.
   * @see fr.obeo.ariadne.model.tasks.TaskEntry#getOptions()
   * @see #getTaskEntry()
   * @generated
   */
  EAttribute getTaskEntry_Options();

  /**
   * Returns the meta object for the attribute '{@link fr.obeo.ariadne.model.tasks.TaskEntry#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see fr.obeo.ariadne.model.tasks.TaskEntry#getKind()
   * @see #getTaskEntry()
   * @generated
   */
  EAttribute getTaskEntry_Kind();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  TasksFactory getTasksFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each operation of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link fr.obeo.ariadne.model.tasks.impl.TasksRepositoryImpl <em>Repository</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.obeo.ariadne.model.tasks.impl.TasksRepositoryImpl
     * @see fr.obeo.ariadne.model.tasks.impl.TasksPackageImpl#getTasksRepository()
     * @generated
     */
    EClass TASKS_REPOSITORY = eINSTANCE.getTasksRepository();

    /**
     * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TASKS_REPOSITORY__URL = eINSTANCE.getTasksRepository_Url();

    /**
     * The meta object literal for the '{@link fr.obeo.ariadne.model.tasks.impl.TaskImpl <em>Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.obeo.ariadne.model.tasks.impl.TaskImpl
     * @see fr.obeo.ariadne.model.tasks.impl.TasksPackageImpl#getTask()
     * @generated
     */
    EClass TASK = eINSTANCE.getTask();

    /**
     * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TASK__URL = eINSTANCE.getTask_Url();

    /**
     * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TASK__IDENTIFIER = eINSTANCE.getTask_Identifier();

    /**
     * The meta object literal for the '<em><b>Task Entries</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TASK__TASK_ENTRIES = eINSTANCE.getTask_TaskEntries();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TASK__ELEMENTS = eINSTANCE.getTask_Elements();

    /**
     * The meta object literal for the '{@link fr.obeo.ariadne.model.tasks.impl.TaskEntryImpl <em>Task Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.obeo.ariadne.model.tasks.impl.TaskEntryImpl
     * @see fr.obeo.ariadne.model.tasks.impl.TasksPackageImpl#getTaskEntry()
     * @generated
     */
    EClass TASK_ENTRY = eINSTANCE.getTaskEntry();

    /**
     * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TASK_ENTRY__IDENTIFIER = eINSTANCE.getTaskEntry_Identifier();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TASK_ENTRY__VALUES = eINSTANCE.getTaskEntry_Values();

    /**
     * The meta object literal for the '<em><b>Options</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TASK_ENTRY__OPTIONS = eINSTANCE.getTaskEntry_Options();

    /**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TASK_ENTRY__KIND = eINSTANCE.getTaskEntry_Kind();

  }

} //TasksPackage