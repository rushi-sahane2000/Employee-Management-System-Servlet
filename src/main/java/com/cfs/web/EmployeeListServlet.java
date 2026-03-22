package com.cfs.web;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

@WebServlet("/employee")
public class EmployeeListServlet extends HttpServlet {
        private static final String KEY="employee_list";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                resp.setContentType("text/html");
        List<Employee> list=getList();

        PrintWriter out = resp.getWriter();

        out.println("<html><body>");
        out.println("<h2>All Employees ("+list.size()+")</h2>");

        out.println("<a href='index.html'>+ Add Employee </a> <br>");
        out.println("<br>");
        out.println("<br>");
        out.println("<table border='1' >");
        out.println("<tr><th>#</th><th>EmpId</th><th>EmpName</th><th>EmpType</th><th>Project</th></tr>");

        int i=1;
        for (Employee s:list)
        {
            out.println("<tr>");
            out.println("<td>"+(i++)+"</td>");
            out.println("<td>"+s.getEmpId()+"</td>");
            out.println("<td>"+s.getEmpName()+"</td>");
            out.println("<td>"+s.getEmpType()+"</td>");
            out.println("<td>"+s.getProject()+"</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body></html>");
    }

    private List<Employee> getList()
    {
        ServletContext ctx=getServletContext();
        List<Employee>list = (List<Employee>) ctx.getAttribute(KEY);

        return (list==null)? Collections.emptyList(): list;
    }
}
