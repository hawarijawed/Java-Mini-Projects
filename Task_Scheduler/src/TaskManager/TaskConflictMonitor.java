package TaskManager;

public class TaskConflictMonitor {
	public void notifyConflict(Task task) {
		System.out.println("Conflict occurred with task: "+task.getDescription());
	}
}
