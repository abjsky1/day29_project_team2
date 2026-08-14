package team2.model.dao;

public class InventoryDao extends BaseDao{

    private InventoryDao(){}
    private static final InventoryDao instance = new InventoryDao();
    public static InventoryDao getInstance(){ return instance; }

}
