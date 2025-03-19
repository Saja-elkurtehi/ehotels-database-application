package ca.uottawa.csi2132.ehotels.entities;

public class HotelChainPhone {
    private Long hotelChainId;
    private String phone;

    public HotelChainPhone() {
    }

    public HotelChainPhone(Long hotelChainId, String phone) {
        this.hotelChainId = hotelChainId;
        this.phone = phone;
    }

    public Long getHotelChainId() {
        return hotelChainId;
    }

    public void setHotelChainId(Long hotelChainId) {
        this.hotelChainId = hotelChainId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
