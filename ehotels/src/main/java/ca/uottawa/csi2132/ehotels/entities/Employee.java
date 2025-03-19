package ca.uottawa.csi2132.ehotels.entities;

public class Employee {
    private Long employeeId;
    private Integer SSN;
    private String fullName;
    private String address;

    public Employee() {
    }

    public Employee(Long employeeId, Integer SSN, String fullName, String address) {
        this.employeeId = employeeId;
        this.SSN = SSN;
        this.fullName = fullName;
        this.address = address;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getSSN() {
        return SSN;
    }

    public void setSSN(Integer SSN) {
        this.SSN = SSN;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
