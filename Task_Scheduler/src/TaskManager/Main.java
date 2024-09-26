package TaskManager;

import java.time.LocalTime;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Main {
	static ScheduleManager manager = new ScheduleManager();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String user_input = "";
		while(!user_input.equals("close")) {
			System.out.println("Your today's activities Schedules");
			System.out.println("1. Add task\t2. View task\t3. Remove task\t4. Update task\t5. Update status\t6. close");
			user_input = sc.nextLine();
			
			switch(user_input) {
			case "Add task":
				addFun();		
				break;
			case "View task":
				System.out.println();
				viewFun();
				break;
			case "Remove task":
				removeFun();
				System.out.println("");
				break;
			case "Update task":
				updateFun();
				System.out.println("");
				break;
			case "Update status":
				updateStatus();
				break;
			default:
				manager.exit();
				System.out.println("Closing the task manager");
			}
		}

		
		sc.close();
	}

	private static void updateStatus() {
		// TODO Auto-generated method stub
		System.out.print("Provide the task description: ");
		String desc = sc.nextLine();
		System.out.print("Provide the current status  : ");
		String status = sc.nextLine();
		manager.updateStatus(desc, status);
		
	}

	private static void addFun() {
		// TODO Auto-generated method stub
		String desc, start_Time, end_Time, priority, status;
		System.out.print("Task description: ");
		desc = sc.nextLine();
		
		System.out.print("\nTask start time(hh:mm) : ");
		start_Time = sc.nextLine();
		start_Time = start_Time.trim();
		if(start_Time.length() > 5) {
			System.out.println("Invalid time entered");
			return;
		}
		String[] str1 = start_Time.split(":");
		int hour1 = Integer.parseInt(str1[0]);
		int minute1 = Integer.parseInt(str1[1]);
		if(hour1 > 24 || minute1 > 59 || hour1<0 || minute1<0) {
			invalidTime();
			return;
		}
		System.out.print("\nTask end time(hh:mm)   : ");
		end_Time = sc.nextLine();
		end_Time = end_Time.trim();
		if(end_Time.length()>5) {
			System.out.println("Invalid time entered");
			return;
		}
		str1 = end_Time.split(":");
		int hour2 = Integer.parseInt(str1[0]);
		int minute2 = Integer.parseInt(str1[1]);
		
		if(hour1 > 24 || minute1 > 59 || hour1<0 || minute1<0) {
			invalidTime();
			return;
		}
		System.out.print("\nTask Priority	: ");
		priority = sc.nextLine();
		
		System.out.print("\nTask Status: ");
		status = sc.nextLine();
		
		try {
			manager.addTask(new Task(desc,LocalTime.of(hour1,minute1),LocalTime.of(hour2,minute2), priority,status));
		}catch(TaskConflictException e) {
			System.out.println(e.getMessage());
		}
	}
		
	private static void removeFun() {
//		if(manager.taskSize() == 0) {
//			System.out.println("There are no tasks to remove");
//			return;
//		}
		System.out.print("Provide correct description of task: ");
		String desc = sc.nextLine();
		manager.removeTask(desc);
	}
	
	private  static void updateFun() {
		String old_desc,desc, start_Time, end_Time, priority, status;
		System.out.println("Provide old description of task: ");
		old_desc = sc.nextLine();
		System.out.println("New Task description: ");
		desc = sc.nextLine();
		
		System.out.println("New Task start time(hh:mm) : ");
		start_Time = sc.nextLine();
		start_Time = start_Time.trim();
		if(start_Time.length() > 5) {
			System.out.println("Invalid time entered");
			return;
		}
		String[] str1 = start_Time.split(":");
		int hour1 = Integer.parseInt(str1[0]);
		int minute1 = Integer.parseInt(str1[1]);
		if(hour1 > 24 || minute1 > 59 || hour1<0 || minute1<0) {
			invalidTime();
			return;
		}
		System.out.println("New Task end time(hh:mm)   : ");
		end_Time = sc.nextLine();
		end_Time = end_Time.trim();
		if(end_Time.length()>5) {
			System.out.println("Invalid time entered");
			return;
		}
		str1 = end_Time.split(":");
		int hour2 = Integer.parseInt(str1[0]);
		int minute2 = Integer.parseInt(str1[1]);
		if(hour1 > 24 || minute1 > 59 || hour1<0 || minute1<0) {
			invalidTime();
			return;
		}
		//Extracting hours and minutes from start_time and end_time
		
		System.out.print("New Task Priority	: ");
		priority = sc.nextLine();
		
		System.out.print("New Task Status: ");
		status = sc.nextLine();
		
		try {
			manager.updateTask(old_desc,desc,LocalTime.of(hour1,minute1),LocalTime.of(hour2,minute2), priority,status);
		}catch(TaskConflictException e) {
			System.out.println(e.getMessage());
		}
	}
    
	private static void invalidTime() {
		// TODO Auto-generated method stub
		System.out.println("Time format not matched, Please enter correct time");
		return;
	}
	
	private static void viewFun() {
		List<Task> task = new ArrayList<>();
		task = manager.viewTasks();
		if(task.size() == 0) {
			System.out.println("There are no tasks scheduled to show");
			return;
		}
		System.out.println("All scheduled task are given below.");
		for(int i=0; i<task.size(); i++) {
			System.out.println(task.get(i));
		}
		System.out.println();
	}
}//class border


	
