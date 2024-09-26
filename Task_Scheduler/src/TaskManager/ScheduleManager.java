package TaskManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.SimpleFormatter;

public class ScheduleManager {
	private static ScheduleManager instance = null;
	
	//Creating a logging instance
	private static final Logger logger = Logger.getLogger(ScheduleManager.class.getName());
	static {
        try {
        	// Disabling the default consoleLogger 
        	Logger rootLogger = Logger.getLogger("");
        	Handler[] handlers = rootLogger.getHandlers();
        	for(Handler handler: handlers) {
        		rootLogger.removeHandler(handler);
        	}
        	
//        	rootLogger.setLevel(Level.OFF);
            // Log data will be stored in Task Scheduler.log file
            FileHandler fileHandler = new FileHandler("Task Scheduler.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.INFO);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to set up file handler for logger", e);
        }
    }
	//stores all the task
	private List<Task> tasks;
	protected ScheduleManager() {
		tasks = new ArrayList<>();
	}
	
	//Returns the single instance of schedule manager
	public static ScheduleManager getInstance() {
		if(instance == null) {
			instance = new ScheduleManager();
		}
		return instance;
	}
	public int taskSize() {
		return tasks.size();
	}
	public void addTask(Task task) throws TaskConflictException {
		logger.log(Level.INFO, "Adding a task in schedule: {0} ", task.getDescription());
		if(hasConflict(task)) {
			logger.log(Level.WARNING,"Failed to add task {0} due to conflict ",task.getDescription());
			throw new TaskConflictException("Conflict occurred.");
		}
		tasks.add(task);
		logger.log(Level.INFO, "Task {0} added successfully ",task.getDescription());
		System.out.println("Task added successfully, There is no conflict");
	}
	
	public void removeTask(String description) {
		logger.log(Level.INFO,"Trying to remove the task {0} ",description);
		boolean removed = false;
		for(Task task:tasks) {
			if(task.getDescription().equals(description)) {
				tasks.remove(task);
				logger.log(Level.INFO,"Task removed successfully {0}",description);
				removed = true;
				break;
			}
		}
		if(removed) {
			System.out.println("Task removed successfully");
		}else {
			logger.log(Level.INFO,"Task not found {0} ",description);
			System.out.println("Task does not exist/found");
		}
	}
	public void updateStatus(String description, String status) {
		logger.log(Level.INFO,"Trying to update the status of task {0} ",description);
		for(Task task: tasks) {
			if(task.getDescription().equals(description)) {
				task.setStatus(status);
				logger.log(Level.INFO,"Status of task {0} updated successfully ",description);
				System.out.println("Status updated successfully");
				return;
			}
		}
		logger.log(Level.WARNING,"Task not found ",description);
		System.out.println("Task does not exist");
	}
	public void updateTask(String description, String newDesc, LocalTime newStartTime,
			LocalTime newEndTime, String newPriority, String newStatus) throws TaskConflictException{
		logger.log(Level.INFO,"Trying to update a task {0}",description);
		for(Task task: tasks) {
			if(task.getDescription().equals(description)) {
				if(hasConflict(new Task(newDesc, newStartTime, newEndTime, newPriority, newStatus))) {
					logger.log(Level.WARNING,"Task conflicts occurred ",description);
					throw new TaskConflictException("");
				}
				task.setDescription(newDesc);
				task.setStartTime(newStartTime);
				task.setEndTime(newEndTime);
				task.setPriority(newPriority);
				task.setStatus(newStatus);
				logger.log(Level.INFO, "Task updated successfully ",newDesc);
				System.out.println("Task updated successfully");
				return;
			}
		}
	}
	
	public List<Task> viewTasks(){
		logger.log(Level.INFO, "Checking out all the task");
		tasks.sort(Comparator.comparing(Task::getStartTime));
		return tasks;
	}
	
	public List<Task> viewTasksByPriority(String priority){
		return tasks.stream()
				.filter(task->task.getPriority().equalsIgnoreCase(priority))
				.collect(Collectors.toList());
	}
	
	private boolean hasConflict(Task newTask) {
		for(Task task: tasks) {
			if(task.conflictsWith(newTask)) {
				System.out.println("Task conflicts with existing task: "+task.getDescription());
				return true;
			}
		}
		return false;
	}
	void exit() {
		logger.log(Level.INFO,"Task scheduler closed");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

