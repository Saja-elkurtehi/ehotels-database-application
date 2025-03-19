package ca.uottawa.csi2132.ehotels.entities;

import java.time.LocalDate;

public class Renting {
    private Long rentingId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String status;

    public Renting() {
    }

    public Renting(Long rentingId, LocalDate checkInDate, LocalDate checkOutDate, String status) {
        this.rentingId = rentingId;
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
