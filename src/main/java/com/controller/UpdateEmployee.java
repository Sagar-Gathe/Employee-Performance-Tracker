package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOImpl;
import com.model.Employee;
@WebServlet("/UpdateEmployee")
public class UpdateEmployee extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private EmployeeDAO dao;
    
	@Override
	public void init() throws ServletException {
		
		dao = new EmployeeDAOImpl();
	
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");	
		PrintWriter out = resp.getWriter();
		
		String id = req.getParameter("eid");
		String name =req.getParameter("ename");
		String dept = req.getParameter("dept");
		String task =req.getParameter("task");
		String date =req.getParameter("date");
		
		String totaltask = req.getParameter("totalTasks");
		String tasksAllotted =req.getParameter("tasksAllotted");
		String remainingTasks = req.getParameter("remainingTasks");
		
		int totaltask1 = Integer.parseInt(totaltask);
		int tasksAllotted1 = Integer.parseInt(tasksAllotted);
		int remainingTasks1 =Integer.parseInt(remainingTasks);
		
		System.out.println("totaltask1 : "+totaltask1);
		System.out.println("tasksAllotted : "+tasksAllotted);
		System.out.println("remainingTasks1 : "+remainingTasks1);
		
		int id1 = Integer.parseInt(id);
		int task1 = Integer.parseInt(task);
		LocalDate date1 = LocalDate.parse(date);
		Employee emp = new Employee(id1,name,dept,task1,date1,totaltask1,tasksAllotted1,remainingTasks1);

		int i = dao.updateEmployee(emp);
		if(i>0) {
			out.print("Data Updated Successfully!!");
		}else {
			out.print("Unable to Update Data");
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/ReadEmployee");
		rd.include(req, resp);
		
	}


	
	
	

}
