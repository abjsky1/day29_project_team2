package team2.model.dao;

public class ReservationDao {
    private ReservationDao(){}
    private static final ReservationDao instance = new ReservationDao();
    public static ReservationDao getInstance() {
        return instance;
    }


}
