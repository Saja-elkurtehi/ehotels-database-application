package ca.uottawa.csi2132.ehotels.entities;

public class HotelChainEmail {
    private Long hotelChainId;
    private String email;

    public HotelChainEmail() {
    }

    public HotelChainEmail(Long hotelChainId, String email) {
        this.hotelChainId = hotelChainId;
        this.email = email;
    }

    public Long getHotelChainId() {
        return hotelChainId;
    }

    public void setHotelChainId(Long hotelChainId) {
        this.hotelChainId = hotelChainId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
