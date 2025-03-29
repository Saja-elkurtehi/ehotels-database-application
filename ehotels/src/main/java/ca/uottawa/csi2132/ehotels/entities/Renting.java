package ca.uottawa.csi2132.ehotels.entities;

import java.time.LocalDate;

public class Renting {
    private Long rentingId;
    private Long customerId;
    private Long roomId;
    private Long employeeId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String status;

    public Renting() {
    }

    public Renting(Long rentingId, Long customerId, Long roomId, Long employeeId, LocalDate checkInDate,
            LocalDate checkOutDate, String status) {
        this.rentingId = rentingId;
        this.customerId = customerId;
        this.roomId = roomId;
        this.employeeId = employeeId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = status;
    }

    public Long getRentingId() {
        return rentingId;
    }

    public void setRentingId(Long rentingId) {
        this.rentingId = rentingId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
