package team2.model.dao;


public class OrderDao {
    private OrderDao(){};
    private static final OrderDao instance = new OrderDao();
    public static OrderDao getInstance() {return instance;}

    
}
