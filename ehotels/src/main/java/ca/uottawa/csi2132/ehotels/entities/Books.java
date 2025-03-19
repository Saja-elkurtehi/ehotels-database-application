package ca.uottawa.csi2132.ehotels.entities;

public class Books {
    private Long bookingId;
    private Long customerId;
    private Long roomId;

    public Books() {
    }

    public Books(Long bookingId, Long customerId, Long roomId) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.roomId = roomId;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
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
}
