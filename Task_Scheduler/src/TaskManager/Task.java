package TaskManager;
import java.time.LocalTime;
public class Task {
	private String description;
	private LocalTime startTime;
	private LocalTime endTime;
	private String priority;
	private String status;
	
	public Task(String description, LocalTime st, LocalTime en, String priority, String status) {
		this.description = description;
		this.startTime = st;
		this.endTime = en;
		this.priority = priority;
		this.status = status;
	}
	
	//conflict funciton
	public boolean conflictsWith(Task that) {
		return this.startTime.isBefore(that.endTime) && this.endTime.isAfter(that.startTime);
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String desc) {
		this.description = desc;
	}
	
	public LocalTime getStartTime() {
		return startTime;
	}
	
	public void setStartTime(LocalTime st) {
		this.startTime = st;
	}
	
	public LocalTime getEndTime() {
		return endTime;
	}
	
	public void setEndTime(LocalTime end) {
		this.endTime = end;
	}
	
	public String getPriority() {
		return priority;
	}
	
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		/*
		 * 07:00 - 08:00: Morning Exercise [High
		 */
		return startTime+"-"+endTime+": "+description+" ["+priority+"] "+status;
	}
	
}
