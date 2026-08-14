package team2.model.dao;

import java.util.ArrayList;

import team2.model.dao.BaseDao;

public class ReivewDao {
    private ReivewDao() {

    }

    private static final ReivewDao instance = new ReivewDao();

    public static ReivewDao getInstance() {
        return instance;
    }
}
