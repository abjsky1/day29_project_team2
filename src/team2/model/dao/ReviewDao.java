package team2.model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import team2.model.dto.ReivewDto;

public class ReviewDao extends BaseDao {
    private ReviewDao() {

    }

    private static final ReviewDao instance = new ReviewDao();

    public static ReviewDao getInstance() {
        return instance;
    }

    // [1] 리뷰 등록 DAO
    public boolean reivSave(ReivewDto reivewDto) {
        try {
            String sql = "INSERT INTO REIVEW(MNO , REIVCONTENT , REIVSCOPE ) VALUES( ? , ? , ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, reivewDto.getMno());
            ps.setString(2, reivewDto.getReivContent());
            ps.setInt(3, reivewDto.getReivScope());

            int result = ps.executeUpdate();

            if (result == 1)
                return true;

        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

}