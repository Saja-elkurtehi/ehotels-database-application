package ca.uottawa.csi2132.ehotels.entities;

public class HotelChain {
    private Long hotelChainId;
    private Integer numOfHotels;
    private String address;

    public HotelChain() {
    }

    public HotelChain(Long hotelChainId, Integer numOfHotels, String address) {
        this.hotelChainId = hotelChainId;
        this.numOfHotels = numOfHotels;
        this.address = address;
    }

    public Long getHotelChainId() {
        return hotelChainId;
    }

    public void setHotelChainId(Long hotelChainId) {
        this.hotelChainId = hotelChainId;
    }

    public Integer getNumOfHotels() {
        return numOfHotels;
    }

    public void setNumOfHotels(Integer numOfHotels) {
        this.numOfHotels = numOfHotels;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
