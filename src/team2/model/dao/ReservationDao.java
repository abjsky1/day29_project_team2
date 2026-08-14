package team2.model.dao;

import team2.model.dto.ReservationDto;

import java.util.ArrayList;

public class ReservationDao {
    private ReservationDao(){}
    private static final ReservationDao instance = new ReservationDao();
    public static ReservationDao getInstance() {
        return instance;
    }


    public boolean reservSave() {

        return false;
    }

    public ArrayList<ReservationDto> reservFindAll() {

    }

    public boolean reservUpdate(String telNo, int people) {
        return false;
    }

    public boolean reservDelete(String telNo) {
        return false;
    }
}
