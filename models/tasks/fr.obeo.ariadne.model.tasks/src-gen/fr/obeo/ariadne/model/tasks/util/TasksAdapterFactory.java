/**
 */
package fr.obeo.ariadne.model.tasks.util;

import fr.obeo.ariadne.model.core.Element;

import fr.obeo.ariadne.model.tasks.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see fr.obeo.ariadne.model.tasks.TasksPackage
 * @generated
 */
public class TasksAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static TasksPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TasksAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = TasksPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TasksSwitch<Adapter> modelSwitch =
    new TasksSwitch<Adapter>()
    {
      @Override
      public Adapter caseTasksRepository(TasksRepository object)
      {
        return createTasksRepositoryAdapter();
      }
      @Override
      public Adapter caseTask(Task object)
      {
        return createTaskAdapter();
      }
      @Override
      public Adapter caseTaskEntry(TaskEntry object)
      {
        return createTaskEntryAdapter();
      }
      @Override
      public Adapter caseElement(Element object)
      {
        return createElementAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link fr.obeo.ariadne.model.tasks.TasksRepository <em>Repository</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.obeo.ariadne.model.tasks.TasksRepository
   * @generated
   */
  public Adapter createTasksRepositoryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.obeo.ariadne.model.tasks.Task <em>Task</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.obeo.ariadne.model.tasks.Task
   * @generated
   */
  public Adapter createTaskAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.obeo.ariadne.model.tasks.TaskEntry <em>Task Entry</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.obeo.ariadne.model.tasks.TaskEntry
   * @generated
   */
  public Adapter createTaskEntryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.obeo.ariadne.model.core.Element <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.obeo.ariadne.model.core.Element
   * @generated
   */
  public Adapter createElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //TasksAdapterFactory