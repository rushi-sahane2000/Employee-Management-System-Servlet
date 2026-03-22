package com.cfs.web;

public class Employee {
    private String empId;
    private String empName;
    private String empType;
    private String project;


    public Employee(String empId, String empName, String empType, String project) {
        this.empId = empId;
        this.empName = empName;
        this.empType = empType;
        this.project = project;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empType='" + empType + '\'' +
                ", project='" + project + '\'' +
                '}';
    }
}
