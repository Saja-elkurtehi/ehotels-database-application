package ca.uottawa.csi2132.ehotels.entities;

public class HotelPhone {
    private Long hotelId;
    private String phone;

    public HotelPhone() {
    }

    public HotelPhone(Long hotelId, String phone) {
        this.hotelId = hotelId;
        this.phone = phone;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
