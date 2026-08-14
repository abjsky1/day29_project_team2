package team2.controller;

import team2.model.dao.ReservationDao;

public class ReservationController {
    private ReservationController(){};
    private static final ReservationController instance = new ReservationController();
    public static ReservationController getInstance(){
        return instance;
    }

    private ReservationDao resd = ReservationDao.getInstance();


}
