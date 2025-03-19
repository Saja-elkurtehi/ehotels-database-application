package ca.uottawa.csi2132.ehotels.entities;

public class RoomAmenity {
    private Long roomId;
    private String amenity;

    public RoomAmenity() {
    }

    public RoomAmenity(Long roomId, String amenity) {
        this.roomId = roomId;
        this.amenity = amenity;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getAmenity() {
        return amenity;
    }

    public void setAmenity(String amenity) {
        this.amenity = amenity;
    }
}
