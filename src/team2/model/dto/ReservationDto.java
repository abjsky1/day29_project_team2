package team2.model.dto;

public class ReservationDto {
    int reservNo;
    String telNo;
    int people;

    public ReservationDto(){}

    public ReservationDto(int reservNo, String telNo, int people) {
        this.reservNo = reservNo;
        this.telNo = telNo;
        this.people = people;
    }

    public int getReservNo() {
        return reservNo;
    }

    public void setReservNo(int reservNo) {
        this.reservNo = reservNo;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "reservationDto{" +
                "reservNo=" + reservNo +
                ", telNo='" + telNo + '\'' +
                ", people=" + people +
                '}';
    }
}
