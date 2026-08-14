package team2.controller;

public class ReservationController {
    private ReservationController(){};
    private static final ReservationController instance = new ReservationController();
    public static ReservationController getInstance(){
        return instance;
    }
}
