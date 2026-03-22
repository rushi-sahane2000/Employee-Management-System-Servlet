package com.cfs.web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet("/employee-reg")
public class EmployeeRegServlet extends HttpServlet {
    private static final String KEY="employee_list";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empId=req.getParameter("empId");
        String empName=req.getParameter("empName");
        String empType=req.getParameter("empType");
        String project=req.getParameter("project");

        Employee employee=new Employee(empId,empName,empType,project);

        List<Employee> list=getOrCreateList();

        list.add(employee);

        resp.sendRedirect(req.getContextPath() + "/employee");

    }

    private  List<Employee> getOrCreateList() {
        ServletContext ctx = getServletContext();
        synchronized (ctx) {
            List<Employee> list = (List<Employee>) ctx.getAttribute(KEY);

            if (list == null) {
                list = Collections.synchronizedList(new ArrayList<>());
                ctx.setAttribute(KEY, list);
            }
            return list;
        }
    }
}
