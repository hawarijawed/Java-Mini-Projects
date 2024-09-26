package TaskManager;

public class TaskConflictException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TaskConflictException(String message) {
		super(message);
	}
}
