package team2.controller;

import team2.model.dao.InventoryDao;
import team2.model.dto.InventoryDto;

public class InventoryController {

    private InventoryController(){}
    private static final InventoryController instance = new InventoryController();
    public static InventoryController getInstance(){ return instance; }

    //[*] MVC패턴 흐름의 dao 싱글톤 호출
    private InventoryDao id = InventoryDao.getInstance();


    public boolean inventoryOrder(InventoryDto inventoryDto){
        boolean result = id.inventoryOrder(inventoryDto);
        return result;

    }
}
