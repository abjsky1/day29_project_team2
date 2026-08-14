package team2.controller;

import team2.model.dao.ReservationDao;
import team2.model.dto.ReservationDto;

import java.util.ArrayList;

public class ReservationController {
    private ReservationController(){};
    private static final ReservationController instance = new ReservationController();
    public static ReservationController getInstance(){
        return instance;
    }

    private ReservationDao resd = ReservationDao.getInstance();


    public boolean reservSave(ReservationDto reservationDto) {
        return resd.reservSave(reservationDto);
    }

    public ArrayList<ReservationDto> reservFindAll() {
        return resd.reservFindAll();
    }

    public boolean reservUpdate(String telNo, int people) {
        return resd.reservUpdate(telNo,people);
    }

    public boolean reservDelete(String telNo) {
        return resd.reservDelete(telNo);
    }
}
