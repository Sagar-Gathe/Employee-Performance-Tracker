package com.model;

import java.time.LocalDate;

public class Employee {

	private int empId;
	private String empName;
	private String empDept;
	private int taskComp;
	private LocalDate date;
    private int totalTasks;
    private int tasksAllotted;
    private int remainingTasks;
    
    
	public Employee() {
		super();
	}


	public Employee(int empId, String empName, String empDept, int taskComp, LocalDate date, int totalTasks,
			int tasksAllotted, int remainingTasks) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empDept = empDept;
		this.taskComp = taskComp;
		this.date = date;
		this.totalTasks = totalTasks;
		this.tasksAllotted = tasksAllotted;
		this.remainingTasks = remainingTasks;
	}


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getEmpDept() {
		return empDept;
	}


	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}


	public int getTaskComp() {
		return taskComp;
	}


	public void setTaskComp(int taskComp) {
		this.taskComp = taskComp;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public int getTotalTasks() {
		return totalTasks;
	}


	public void setTotalTasks(int totalTasks) {
		this.totalTasks = totalTasks;
	}


	public int getTasksAllotted() {
		return tasksAllotted;
	}


	public void setTasksAllotted(int tasksAllotted) {
		this.tasksAllotted = tasksAllotted;
	}


	public int getRemainingTasks() {
		return remainingTasks;
	}


	public void setRemainingTasks(int remainingTasks) {
		this.remainingTasks = remainingTasks;
	}
	
	
  

	

}
