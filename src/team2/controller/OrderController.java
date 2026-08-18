package team2.controller;

import java.util.ArrayList;

import team2.model.dao.OrderDao;
import team2.model.dto.InventoryDto;
import team2.model.dto.OrderDto;

public class OrderController {
    private OrderController(){};
    private static final OrderController instance = new OrderController();
    public static OrderController getInstance(){return instance;}

    OrderDao od = OrderDao.getInstance();

    public boolean order(OrderDto orderDto){
        boolean result = od.order(orderDto);
        return result;
    }
    
    public ArrayList<OrderDto> findAll(){
        ArrayList<OrderDto> result = od.findAll();
        return result;
    }

    public boolean update(OrderDto orderDto){
        boolean result = od.update(orderDto);
        return result;
    }

    public boolean delete(int no){
        boolean result = od.delete(no);
        return result;
    }

    public ArrayList<InventoryDto> showMenu(){
        return od.showMenu();
    }

}
