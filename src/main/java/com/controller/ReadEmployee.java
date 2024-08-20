package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOImpl;
import com.model.Employee;
@WebServlet("/ReadEmployee")
public class ReadEmployee extends HttpServlet {

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
	          out.print("<link rel='stylesheet' href='css/table.css'>");
	          out.print("<script src='https://cdn.jsdelivr.net/npm/chart.js'></script>"); // Include Chart.js library
	          out.print("</head>");
	          
	          List<Employee> list = dao.getAllEmployee ();
	          Iterator<Employee> itr= list.iterator();
	          
	          out.print("<table id='customers'>");
	          out.print("<tr>");
	          out.print("<th>"+"Employee ID"+"</th>");
	          out.print("<th>"+"Employee Name"+"</th>");
	          out.print("<th>"+"Employee Dept"+"</th>");
	          out.print("<th>"+"Total Task"+"</th>");
	          out.print("<th>"+"Task Alloted"+"</th>");
	          out.print("<th>"+"Task Completed"+"</th>");
	          out.print("<th>"+"Remaining Task"+"</th>");
	          out.print("<th>"+"Date"+"</th>");
	          out.print("<th>"+"DELETE"+"</th>");
	          out.print("<th>"+"UPDATE"+"</th>");
	          out.print("</tr>");
	          
	          while (itr.hasNext()) {
	        	  out.print("<tr>");
	        	  Employee emp = itr.next();
	        	  out.print("<td>"+emp.getEmpId()+"</td>");
	        	  out.print("<td>"+emp.getEmpName()+"</td>");
	        	  out.print("<td>"+emp.getEmpDept()+"</td>");
	        	  out.print("<td>"+emp.getTotalTasks()+"</td>");
	        	  out.print("<td>"+emp.getTasksAllotted()+"</td>");
	        	  out.print("<td>"+emp.getRemainingTasks()+"</td>");
	        	  out.print("<td>"+emp.getTaskComp()+"</td>");
	        	  out.print("<td>"+emp.getDate()+"</td>");
	     
	        	  out.print("<td>");
	        	  out.print("<a href='DeleteEmployee?empid="+emp.getEmpId()+"'>"+"DELETE"+"</a>");
	        	  out.print("</td>");
	        	  
	        	  out.print("<td>");
	        	  out.print("<a href='UpdateForm?empid="+emp.getEmpId()+"'>"+"UPDATE"+"</a>");
	        	  out.print("</td>");
	        	  out.print("</tr>");
	        	 
			}
	          
	          out.print("</table>");
	          out.print("<br>");
	          
	          // Add Performance Analysis button
	          out.print("<button id='performanceButton'>Performance Analysis</button>");
	          
	          // Add canvas for the chart
	          out.print("<canvas id='performanceChart' width='400' height='200' style='display:none;'></canvas>");
	          
	          // Add JavaScript for chart generation
	          out.print("<script>");
	          out.print("document.getElementById('performanceButton').addEventListener('click', function() {");
	          out.print("var chartCanvas = document.getElementById('performanceChart');");
	          out.print("chartCanvas.style.display = 'block';");
	          
	          out.print("const employees = [");
	          for (Employee emp : list) {
	              out.print("{");
	              out.print("name: '" + emp.getEmpName() + "',");
//	              out.print("totalTasks: " + emp.getTotalTasks() + ",");
	              out.print("tasksAllotted: " + emp.getTasksAllotted() + ",");
	              out.print("remainingTasks: " + emp.getRemainingTasks() + ",");
	              out.print("tasksCompleted: " + emp.getTaskComp());
	              out.print("},");
	          }
	          out.print("];");
	          
	          out.print("const labels = employees.map(emp => emp.name);");
//	          out.print("const totalTasks = employees.map(emp => emp.totalTasks);");
	          out.print("const tasksAllotted = employees.map(emp => emp.tasksAllotted);");
	          out.print("const remainingTasks = employees.map(emp => emp.remainingTasks);");
	          out.print("const tasksCompleted = employees.map(emp => emp.tasksCompleted);");
	          
	          out.print("const ctx = chartCanvas.getContext('2d');");
	          out.print("const performanceChart = new Chart(ctx, {");
	          out.print("type: 'bar',");
	          out.print("data: {");
	          out.print("labels: labels,");
	          out.print("datasets: [");
//	          out.print("{ label: 'Total Tasks', data: totalTasks, backgroundColor: 'rgba(54, 162, 235, 0.2)', borderColor: 'rgba(54, 162, 235, 1)', borderWidth: 1 },");
	          out.print("{ label: 'Tasks Allotted', data: tasksAllotted, backgroundColor: 'rgba(255, 206, 86, 0.2)', borderColor: 'rgba(255, 206, 86, 1)', borderWidth: 1 },");
	          out.print("{ label: 'Remaining Tasks', data: remainingTasks, backgroundColor: 'rgba(75, 192, 192, 0.2)', borderColor: 'rgba(75, 192, 192, 1)', borderWidth: 1 },");
	          out.print("{ label: 'Tasks Completed', data: tasksCompleted, backgroundColor: 'rgba(153, 102, 255, 0.2)', borderColor: 'rgba(153, 102, 255, 1)', borderWidth: 1 }");
	          out.print("]");
	          out.print("},");
	          out.print("options: { scales: { y: { beginAtZero: true } } }");
	          out.print("});");
	          out.print("});");
	          out.print("</script>");
	}  


}
