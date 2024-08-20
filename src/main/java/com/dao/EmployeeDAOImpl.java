package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.model.Employee;
import com.utility.DBUtility;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public int saveEmployee(Employee emp) {

		Connection con = null;
		try {
			con = DBUtility.getDBConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String sql = "Insert into emp values(?,?,?,?,?,?,?,?)";
		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, emp.getEmpId());
			ps.setString(2, emp.getEmpName());
			ps.setString(3, emp.getEmpDept());
			LocalDate localDate = emp.getDate();
			Date sqlDate = Date.valueOf(localDate); // Correctly convert LocalDate to java.sql.Date
			ps.setDate(4, sqlDate);
			ps.setInt(5, emp.getTotalTasks());
			ps.setInt(6, emp.getTasksAllotted());
			ps.setInt(7, emp.getRemainingTasks());
			ps.setInt(8, emp.getTaskComp());
			
			return ps.executeUpdate();

		} catch (Exception e) {
			System.out.println("Exception " + e);
		}
		return 0;
	}

	@Override
	public int DeleteEmployee(int id) {
		Connection con = null;
		try {
			con = DBUtility.getDBConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql = "delete from emp where empid=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			return ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	@Override
	public int updateEmployee(Employee emp) {

		Connection con = null;
		try {
			con = DBUtility.getDBConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql = "Update emp set EmpName=? , EmpDept=? , EvalutionDate=?, totalTasks=?,tasksAllotted=?,remainingTasks=?,tasksCompleted=? where empid=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, emp.getEmpName());
			ps.setString(2, emp.getEmpDept());
			

			// Convert LocalDate to java.sql.Date
			LocalDate localDate = emp.getDate();
			Date sqlDate = Date.valueOf(localDate); // Correct conversion
			ps.setDate(3, sqlDate);
			ps.setInt(4, emp.getTotalTasks());
			ps.setInt(5, emp.getTasksAllotted());
			ps.setInt(6, emp.getRemainingTasks());
			ps.setInt(7, emp.getTaskComp());
			ps.setInt(8, emp.getEmpId());
			return ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

		return 0;
	}

	@Override
	public List<Employee> getAllEmployee() {

		List<Employee> list = new ArrayList<Employee>();
		Connection con = null;
		try {
			con = DBUtility.getDBConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String sql = "Select * from emp";
		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpId(rs.getInt(1));
				emp.setEmpName(rs.getString(2));
				emp.setEmpDept(rs.getString(3));
				// Convert java.sql.Date to java.time.LocalDate
				Date sqlDate = rs.getDate(4);
				if (sqlDate != null) {
					LocalDate localDate = sqlDate.toLocalDate();
					emp.setDate(localDate);
				}
				emp.setTotalTasks(rs.getInt(5));
				emp.setTasksAllotted(rs.getInt(6));
				emp.setRemainingTasks(rs.getInt(7));
				emp.setTaskComp(rs.getInt(8));
				
				list.add(emp);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return list;
	}

	@Override
	public Employee getEmployeeById(int id) {

		Connection con = null;
		try {
			con = DBUtility.getDBConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String sql = "select * from emp where empId=?";

		Employee emp = new Employee();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				emp.setEmpId(rs.getInt(1));
				emp.setEmpName(rs.getString(2));
				emp.setEmpDept(rs.getString(3));
				// Convert java.sql.Date to java.time.LocalDate
				Date sqlDate = rs.getDate(4);
				if (sqlDate != null) {
					LocalDate localDate = sqlDate.toLocalDate();
					emp.setDate(localDate);
				}
				
				emp.setTotalTasks(rs.getInt(5));
				emp.setTasksAllotted(rs.getInt(6));
				emp.setRemainingTasks(rs.getInt(7));
				emp.setTaskComp(rs.getInt(8));

			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return emp;
	}

}
