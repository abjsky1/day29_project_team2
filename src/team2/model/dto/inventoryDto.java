package team2.model.dto;

public class InventoryDto {

    private int no;
    private String menuName;
    private int menuQty;
    private int requestQty;

    public InventoryDto(){}
    
    public InventoryDto(int no, int requestQty) {
        this.no = no;
        this.requestQty = requestQty;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuQty() {
        return menuQty;
    }

    public void setMenuQty(int menuQty) {
        this.menuQty = menuQty;
    }

    public int getRequestQty() {
        return requestQty;
    }

    public void setRequestQty(int requestQty) {
        this.requestQty = requestQty;
    }

    @Override
    public String toString() {
        return "InventoryDto [no=" + no + ", menuName=" + menuName + ", menuQty=" + menuQty + ", requestQty="
                + requestQty + "]";
    }

    
   

}
