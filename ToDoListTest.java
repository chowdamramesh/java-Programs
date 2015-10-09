 import java.util.*;
 import java.text.SimpleDateFormat;
 import java.text.*;
//import java.util.ArrayList;
import java.util.Date;
public class ToDoListTest {
  public static void main(String[] args) {
    /* The following code creates an object of TodoList and adds tasks */
    /* Constructor takes a user's name as input in order to display */
    ToDoList list = new ToDoList("Praveen");
    System.out.println(list.getName());
    /* creates an object of task with the task name */
    Task t1 = new Task("Buy groceries");
    /* adds the task to todo list */
    list.addTask(t1);
    t1.setDueDate("23/08/15 11:00:00");

    Task t2 = new Task("Recharge mobile phone");
    list.addTask(t2);
    t2.markAsDone();
    t2.setDueDate("19/08/15 11:00:00");

    Task t3 = new Task("Send the document on todo list");
    list.addTask(t3);
    t3.setDueDate("22/08/15 11:00:00");

    Task t4 = new Task("Clarify the questions posted on slack");
    list.addTask(t4);
    t4.markAsDone();
    t4.setDueDate("8/08/15 11:00:00");

    Task t5 = new Task("Send a thank you note to Ram");
    list.addTask(t5);
    t5.setDueDate("8/08/15 11:00:00");

    Task t6 = new Task("Register for the Airtel 5K run");
    list.addTask(t6);
    t6.setDueDate("21/08/15 11:00:00");

    Task t7 = new Task("Book movie tickets for Saturday");
    list.addTask(t7);
    t7.setDueDate("19/08/15 11:00:00");
    
    Task t8 = new Task("Install digital proctor for sparks and codeninjas");
    list.addTask(t8);
    t8.setDueDate("10/08/15 11:00:00");

    Task t9 = new Task("Create the specification for dashboard project");
    list.addTask(t9);
    t9.setDueDate("8/08/15 11:00:00");

    Task t10 = new Task("Prepare question paper for assessment 3");
    list.addTask(t10);
    t10.setDueDate("22/08/15 09:00:00");

    Task t11 = new Task("Get some sleep!");
    list.addTask(t11);
    t11.setDueDate("8/08/15 12:00:00");

    /* print all the tasks with task name */
    System.out.println("-----Print all the tasks that are in the list-----");
    
    list.printAllTasks();
    
    /* find all the tasks that match the keyword digital proctor */
    /* i need user input to mark the task wheter it is done or not.
    */
    System.out.println("-----search results for digital proctor-----");
    Task[] tasks = list.findTask("digital proctor");
    for (Task t : tasks) {
        if(t!=null) {
        	System.out.println(t);
        }
    }
    /* find all the tasks that match the keyword digital proctor */
    System.out.println("\n");
    System.out.println("-----Overdue task list-----");
    
    Task[] tasks1 = list.getOverdueTasks();
    
    for (Task t : tasks1) {
        if(t==null) {
            break;
        }
      System.out.println(t);
    }
    /* find all the tasks that match the given date */
    System.out.println("-----Tasks list that match a date-----");
    tasks = list.getTask("19/08/15 11:00:00");
    for (Task t : tasks) {

        if(t!=null)
            System.out.println(t);
    }
    /* find all the tasks that are pending */
    System.out.println("\n");
    System.out.println("-----Tasks list that are not done-----");
    Task[] tasks2 = list.getPendingTasks();
    for (Task t : tasks2) {
        if(t!=null)
            System.out.println(t);
    }
    /* All the tasks that you want to remove and printing the remaining tasks*/
    list.removeTask(t11);
    list.removeTask(t6);
    System.out.println("\n");
    System.out.println("-----Printing all the tasks that are remaining in the list-----");
    list.printAllTasks();
  }
}


/**
* ToDoList Class is used add nameOfPerson and adds the tasks and
* mark it as done and find the task and getTheTask from the
* given ,printallTasks,removeTheTask,getOveDue tasks.
*/
class ToDoList {
  /**
  * nameOfPerson is string to store name of person.
  */
  private String nameOfPerson;
  /**
  * dateUsed is Date type to store date.
  */
  private Date dateUsed;
  /**
  * tasks is Task[] array type to store tasks.
  */
  private Task[] tasks;
  /**
  * size is int to store total tasks for the person.
  */
  private int size;
  /**
  * taskCount is int to store taskcount.
  */
  private int taskCount;

  /**
  * ToDoList constructor which takes the String as parameter
  * and set the size to 11 and create tasks with the size equal to 11.
  * and taskcount equals to zero.
  * @param name which is a string type.
  */
  public ToDoList(final String name) {
    this.size = 11;
    taskCount = 0;
    tasks = new Task[size];
    this.nameOfPerson = name;
  }

  /**
  * In this method.
  * @return nameOfPersom It return the nameOfPerson which is a String type.
  */
  public String getName() {
    return nameOfPerson;
  }

  /**
  * In this method it is used to add task to array.
  * @param task It take the Task Type as parameter.
  * and adds to the tasks array
  */
  public void addTask(final Task task) {
    if (taskCount < size) {
      tasks[taskCount++] = task;
    }
  }

  /**
  * In this method we remove the task by compare with the all tasks.
  * @param task We take task which is a Task type.
  */
  public void removeTask(final Task task) {
    int i = 0;
    for (i = 0; i < taskCount; i++) {
      if (tasks[i].equals(task)) {
        break;
      }
    }
    tasks[i] = null;
  }

  /**
  * In this method print all the tasks.
  * Print all the tasks from the tasks Array.
  */
  public void printAllTasks() {
    //for (Task t : tasks)
    int i = 0;
    for (i = 0; i < taskCount; i++) {
      if (tasks[i] != null) {
        System.out.println(tasks[i]);
      }
    }
  }
  /**
  * In this method find the task accotrding to the given taskName.
  * @param taskName It takes the string.
  * @return tasksFound array which contains the all the tasks which
  * are obtined after the compare with the given String and from all
  * task which we are given.
  */
  public Task[] findTask(final String taskName) {
    Task[] tasksFound = new Task[taskCount];
    int r = 0;
    for (int i = 0; i < taskCount; i++) {
      if ((tasks[i].getTaskName()).contains(taskName)) {
        tasksFound[r++] = tasks[i];
      }
    }
    return tasksFound;
  }

  /**
  * In this method get the task according to the given dateAndTime.
  * @param dateAndTime It takes the string.
  * @return taskAtDate array which contains the all the tasks which
  * are obtined after the compare with the given date and time from
  * all task which we are given.
  */
  public Task[] getTask(final String dateAndTime) {
    Task[] taskAtDate = new Task[taskCount];
    int k = 0;
    Date date;
    dateUsed = null;
    SimpleDateFormat date1 = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
    try {
      dateUsed = date1.parse(dateAndTime);
     } catch (Exception e) {
      e.printStackTrace();
     }
    for (int i = 0; i < taskCount; i++) {
      date = tasks[i].getDueDate();
      if (date != null) {
        if ((date).compareTo(dateUsed) == 0) {
        taskAtDate[k] = tasks[i];
        k++;
        }
      }
    }
    return taskAtDate;
  }
  /**
  * In this method we get the pending tasks.
  * @return pendingTask array which contains the all the tasks which
  * are pending.
  */
  public Task[] getPendingTasks() {
    Task[] pendingTask = new Task[taskCount];
    int p = 0;
    boolean temp;
    for (int i = 0; i < taskCount; i++) {
      temp = tasks[i].getMarkAsDone();
      if (!temp) {
        pendingTask[p] = tasks[i];
        p++;
      }
    }
    return pendingTask;
  }

  /**
  * In this method we get the over due tasks.
  * @return overDueTask array which contains the all the tasks which
  * are overDue after checking with the current date.
  */
  public Task[] getOverdueTasks() {
    Task[] overDueTask = new Task[taskCount];
    int j = 0;
    Date temp;
    dateUsed = null;
    SimpleDateFormat date1 = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
    String s = getCurrentDateTime();
      try {
        dateUsed = date1.parse(s);
      } catch (Exception e) {
        System.out.println(e);
      }
      for (int i = 0; i < taskCount; i++) {
        temp = tasks[i].getDueDate();
        if (temp != null) {
          if (temp.before(dateUsed)) {
            overDueTask[j] = tasks[i];
            j++;
          }
        }
      }
      return overDueTask;
    }

    /**
    * In this method we get the current Date and time.
    * @return current date in the String type.
    */
    public String getCurrentDateTime() {
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
      Date date = new Date();
      return (dateFormat.format(date));
    }

}
/**
*	Task Class is used to setName and setDuedate and mention 
* if the task is done or not.
*/
class Task {
	/**
	* taskName a string to store name of task.
	*/
	private String taskName;
	/**
	* dueDate is a Date type to store the dueDate.
	*/
	private Date dueDate;
	/**
	* doneTheTask is boolean type to store the true or false.
	*/
	private boolean doneTheTask;
	/**
	*	Constructor for the Task class.
	* It takes String as parameter and add to 
	* taskName and makes the doneThe task as false 
	* for every object.
	*/
	public Task(String taskName) {
		this.taskName = taskName;
		boolean doneTheTask = false;
	}
	/**
	*	In this method it return taskname.
	* @return taskName it return the taskName which is a String type.
	*/
	public String getTaskName() {
		return taskName;
	}
	/**
	*	In SetDueDate method it set the given date to dueDate instance variable.
	*	@param date it takes the String.
	*/
	public void setDueDate(String date) {
		 SimpleDateFormat date1 = new SimpleDateFormat ("dd/MM/yy HH:mm:ss");
		 try {
		 	dueDate = date1.parse(date);
		 } catch(Exception d) {
		 			System.out.println(d);
		 	}
	}
	/**
	*	In this method return duedate.
	* @return dueDate it return the dueDate which is a Date type.
	*/
	public Date getDueDate() {
		return dueDate;
	}
	/**
	*	In the markAsDone method it set the doneTheTask to true.
	*/
	public void markAsDone() {
		doneTheTask = true;
	}
	/**
	*	In this method it return boolean according to tht doneThetask.
	* @return doneTheTask it return the doneTheTask which is a boolean type.
	*/
	public boolean getMarkAsDone() {
		return doneTheTask;
	}
	/**
	*	In this methods it return the TaskName and dueDate.
	* @return String
	*/
	public String toString() {
		String all = taskName + "\n";
		if(dueDate != null)
		all = all + dueDate;
		return all;
	}
}
