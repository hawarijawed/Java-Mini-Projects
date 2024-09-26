package TaskManager;
import java.time.LocalTime;
public class TaskFactory {
	public static Task createTask(String desc, LocalTime st, LocalTime en, String priority, String status) {
		return new Task(desc, st, en, priority, status);
	}
}
