package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOImpl;
import com.model.Employee;
@WebServlet("/UpdateForm")
public class UpdateForm extends HttpServlet {

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
		   
		   out.print("<head>");
			out.print("<link rel='stylesheet' href='css/form.css'>");
			out.print("</head>");

			int id = Integer.parseInt(req.getParameter("empid"));
			Employee emp = null;

			emp = dao.getEmployeeById(id);

			out.print("<div>");
			out.print("<h2>Update Employee Details!!!<h2><br>");
			out.print("<form action='UpdateEmployee' method='get'>");
			out.print("<input type='number' name='eid' value='" + emp.getEmpId() + "'readonly >");
			out.print("<br>");
			out.print("<input type='text' name='ename'  value='" + emp.getEmpName() + "'>");
			out.print("<br>");
			out.print("<input type='text' name='dept' value='" + emp.getEmpDept()+ "'>");
			out.print("<br>");
			out.print("<input type='number' name='totalTasks' value='" + emp.getTotalTasks()+ "'readonly>");
			out.print("<br>");
			out.print("<input type='number' name='tasksAllotted' value='" + emp.getTasksAllotted()+ "'readonly>");
			out.print("<br>");
			out.print("<input type='number' name='remainingTasks' value='" + emp.getRemainingTasks()+ "'>");
			out.print("<br>");
			out.print("<input type='number' name='task' value='" +emp.getTaskComp() + "'>");
			out.print("<br>");
			out.print("<input type='date' name='date' value='" +emp.getDate() + "'>");
			out.print("<br>");
			out.print("<input type='submit' value='UPDATE'>");
			out.print("</form>");
			out.print("</div>");
	}


	
	
	

}
