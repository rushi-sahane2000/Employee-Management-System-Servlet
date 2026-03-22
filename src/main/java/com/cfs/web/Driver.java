package com.cfs.web;

public class Driver {

    public Driver(Project_Assign projectAssign) {
    }

    public static void main(String[] args) {
        Project_Assign frontendProject=new FrontendProject();
        frontendProject.project();
        Project_Assign backendProject=new BackendProject();
        backendProject.project();
        Project_Assign devopsProject=new DevopsProject();
        devopsProject.project();

    }
}
