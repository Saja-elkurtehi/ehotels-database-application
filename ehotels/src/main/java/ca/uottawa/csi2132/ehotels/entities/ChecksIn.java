package ca.uottawa.csi2132.ehotels.entities;

import java.time.LocalDate;

public class ChecksIn {
    private Long customerId;
    private Long roomId;
    private Long employeeId;
    private LocalDate checkInDate;
    private Long bookingId;

    public ChecksIn() {
    }

    public ChecksIn(Long customerId, Long roomId, Long employeeId, LocalDate checkInDate, Long bookingId) {
        this.customerId = customerId;
        this.roomId = roomId;
        this.employeeId = employeeId;
        this.checkInDate = checkInDate;
        this.bookingId = bookingId;
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

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }
}
