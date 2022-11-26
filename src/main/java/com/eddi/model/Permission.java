package com.eddi.model;

public enum Permission {
    EMPLOYEE_READ("employee.read"),
    EMPLOYEE_CREATE("employee.create"),
    DEPARTMENT_READ("department.read"),
    DEPARTMENT_CREATE("department.create"),
    REPORT_READ("report.read"),
    REPORT_CREATE("report.create"),
    MEETING_READ("meeting.read"),
    MEETING_CREATE("meeting.create"),
    ADMIN_VIEW("admin.view");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
