package com.javaWeb.web;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.javaBean.bean.Employee;
import com.javaDao.dao.EmployeeDao;

@WebServlet("/register")
public class EmployeeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EmployeeDao employeeDao;

    public void init() {
        employeeDao = new EmployeeDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    	String first_name = request.getParameter("first_name");
		 String last_name = request.getParameter("last_name");
		 String month = request.getParameter("month");
		 String day = request.getParameter("day");
		 String year = request.getParameter("year");
		 String address = request.getParameter("address");
		 String city = request.getParameter("city");
		 String state = request.getParameter("state");
		 String postal_code = request.getParameter("postal_code");
		 String phone = request.getParameter("phone");
		 String email = request.getParameter("email");
		 String linkedin = request.getParameter("linkedin");
		 String motivation_letter = request.getParameter("motivation_letter");
		 
        Employee employee = new Employee();
        employee.setFirst_name(first_name);
        employee.setLast_name(last_name);
        employee.setMonth(month);
        employee.setDay(day);
        employee.setYear(year);
        employee.setAddress(address);
        employee.setCity(city);
        employee.setState(state);
        employee.setPostal_code(postal_code);
        employee.setPhone(phone);
        employee.setEmail(email);
        employee.setLinkedin(linkedin);
        employee.setMotivation_letter(motivation_letter);

        try {
            employeeDao.registerEmployee(employee);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response.sendRedirect("employeedetails.jsp");
    }
}