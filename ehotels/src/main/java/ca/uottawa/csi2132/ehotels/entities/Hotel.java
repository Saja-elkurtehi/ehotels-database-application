package ca.uottawa.csi2132.ehotels.entities;

public class Hotel {
    private Long hotelId;
    private Long hotelChainId;
    private Short rating;
    private Integer numOfRooms;
    private String address;

    public Hotel() {
    }

    public Hotel(Long hotelId, Long hotelChainId, Short rating, Integer numOfRooms, String address) {
        this.hotelId = hotelId;
        this.hotelChainId = hotelChainId;
        this.rating = rating;
        this.numOfRooms = numOfRooms;
        this.address = address;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Long getHotelChainId() {
        return hotelChainId;
    }

    public void setHotelChainId(Long hotelChainId) {
        this.hotelChainId = hotelChainId;
    }

    public Short getRating() {
        return rating;
    }

    public void setRating(Short rating) {
        this.rating = rating;
    }

    public Integer getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(Integer numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
