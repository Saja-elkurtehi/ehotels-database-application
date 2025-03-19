package ca.uottawa.csi2132.ehotels.entities;

public class Room {
    private Long roomId;
    private Long hotelId;
    private Long price;
    private Boolean extension;
    private Short capacity;
    private String viewType;
    private String anyProblems;

    public Room() {
    }

    public Room(Long roomId, Long hotelId, Long price, Boolean extension, Short capacity, String viewType, String anyProblems) {
        this.roomId = roomId;
        this.hotelId = hotelId;
        this.price = price;
        this.extension = extension;
        this.capacity = capacity;
        this.viewType = viewType;
        this.anyProblems = anyProblems;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Boolean getExtension() {
        return extension;
    }

    public void setExtension(Boolean extension) {
        this.extension = extension;
    }

    public Short getCapacity() {
        return capacity;
    }

    public void setCapacity(Short capacity) {
        this.capacity = capacity;
    }

    public String getViewType() {
        return viewType;
    }

    public void setViewType(String viewType) {
        this.viewType = viewType;
    }

    public String getAnyProblems() {
        return anyProblems;
    }

    public void setAnyProblems(String anyProblems) {
        this.anyProblems = anyProblems;
    }
}
