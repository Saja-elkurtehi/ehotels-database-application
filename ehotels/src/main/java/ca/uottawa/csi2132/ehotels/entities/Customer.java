package ca.uottawa.csi2132.ehotels.entities;

import java.time.LocalDate;

public class Customer {
    private Long customerId;
    private String SSN;
    private String fullName;
    private String address;
    private LocalDate registrationDate;

    public Customer() {
    }

    public Customer(Long customerId, String SSN, String fullName, String address, LocalDate registrationDate) {
        this.customerId = customerId;
        this.SSN = SSN;
        this.fullName = fullName;
        this.address = address;
        this.registrationDate = registrationDate;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
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

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
