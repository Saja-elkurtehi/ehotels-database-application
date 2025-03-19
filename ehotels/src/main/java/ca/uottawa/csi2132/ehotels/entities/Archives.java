package ca.uottawa.csi2132.ehotels.entities;

public class Archives {
    private Long archiveId;
    private Long rentingId;
    private Long bookingId;

    // No-argument constructor
    public Archives() {
    }

    // All-argument constructor
    public Archives(Long archiveId, Long rentingId, Long bookingId) {
        this.archiveId = archiveId;
        this.rentingId = rentingId;
        this.bookingId = bookingId;
    }

    public Long getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(Long archiveId) {
        this.archiveId = archiveId;
    }

    public Long getRentingId() {
        return rentingId;
    }

    public void setRentingId(Long rentingId) {
        this.rentingId = rentingId;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }
}
