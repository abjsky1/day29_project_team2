package team2.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import team2.model.dto.OrderDto;

public class OrderDao extends BaseDao{
    private OrderDao(){};
    private static final OrderDao instance = new OrderDao();
    public static OrderDao getInstance() {return instance;}

    public boolean order(OrderDto){

    }

    public ArrayList<OrderDto> findAll(){

    }

    public boolean update(OrderDto){

    }

    public boolean delete(int no){

    }

}
