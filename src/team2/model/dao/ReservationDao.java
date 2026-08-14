package team2.model.dao;

import team2.model.dto.ReservationDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationDao extends BaseDao{
    private ReservationDao(){}
    private static final ReservationDao instance = new ReservationDao();
    public static ReservationDao getInstance() {
        return instance;
    }


    public boolean reservSave(ReservationDto reservationDto) {
        String sql = "insert into reservation(telNo, people) values (?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,reservationDto.getTelNo());
            ps.setInt(2,reservationDto.getPeople());
            int i = ps.executeUpdate();
            if(i == 1){
                return true;
            }
        } catch (SQLException e) {
            System.out.println("예외 발생 " + e);
        }
        return false;
    }

    public ArrayList<ReservationDto> reservFindAll() {
        ArrayList<ReservationDto> reservList = new ArrayList<>();
        String sql = "select * from reservation";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ReservationDto reservationDto = new ReservationDto();
                reservationDto.setReservNo(rs.getInt("reservNo"));
                reservationDto.setTelNo(rs.getString("telNo"));
                reservationDto.setPeople(rs.getInt("people"));
                reservList.add(reservationDto);
            }
        } catch (SQLException e) {
            System.out.println("예외 발생 " + e);
        }
        return reservList;
    }

    public boolean reservUpdate(String telNo, int people) {
        String sql = "update reservation set people = ? where telNo = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,people);
            ps.setString(2,telNo);
            int i = ps.executeUpdate();
            if(i==1){
                return true;
            }
        } catch (SQLException e) {
            System.out.println("예외 발생 " + e);
        }
        return false;
    }

    public boolean reservDelete(String telNo) {
        String sql = "delete from reservation where telNo = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,telNo);
            int i = ps.executeUpdate();
            if (i == 1){
                return true;
            }
        } catch (SQLException e) {
            System.out.println("예외 발생 " + e);
        }
        return false;
    }
}
