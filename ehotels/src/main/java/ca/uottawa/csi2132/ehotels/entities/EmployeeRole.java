package ca.uottawa.csi2132.ehotels.entities;

public class EmployeeRole {
    private Long employeeId;
    private String role;

    public EmployeeRole() {
    }

    public EmployeeRole(Long employeeId, String role) {
        this.employeeId = employeeId;
        this.role = role;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
