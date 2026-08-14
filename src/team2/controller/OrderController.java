package team2.controller;

import java.util.ArrayList;

import team2.model.dao.OrderDao;
import team2.model.dto.OrderDto;

public class OrderController {
    private OrderController(){};
    private static final OrderController instance = new OrderController();
    public static OrderController getInstance(){return instance;}

    OrderDao od = OrderDao.getInstance();

    public boolean order(OrderDto orderDto){
        
    }
    
    public ArrayList<OrderDto> findAll(){
        
        
    }

    public boolean update(OrderDto orderDto){

    }

    public boolean delete(int no){
        
    }


}
