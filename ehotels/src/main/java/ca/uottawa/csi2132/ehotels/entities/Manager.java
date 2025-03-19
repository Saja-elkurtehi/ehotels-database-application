package ca.uottawa.csi2132.ehotels.entities;

public class Manager {
    private Long employeeId;
    private Long hotelId;

    public Manager() {
    }

    public Manager(Long employeeId, Long hotelId) {
        this.employeeId = employeeId;
        this.hotelId = hotelId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }
}
