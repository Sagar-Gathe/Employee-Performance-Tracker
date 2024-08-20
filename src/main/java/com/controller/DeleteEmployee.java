package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOImpl;
@WebServlet("/DeleteEmployee")
public class DeleteEmployee extends HttpServlet {

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
		 
		 String id = req.getParameter("empid");
		 System.out.println("id + "+ id);
		 int id1 = Integer.parseInt(id);
		 System.out.println("id + "+ id1);
		 
		 int i = dao.DeleteEmployee(id1);
		 
		 try { 
			 if(i>0) {
				 out.print("Data Deleted Successfully");
			 }else {
				 out.print("Unable to Delete data");
			 }
			 
			 RequestDispatcher rd = req.getRequestDispatcher("/ReadEmployee");
		     rd.include(req, resp);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		 
		
		 
	}


	
	
	
	

}
