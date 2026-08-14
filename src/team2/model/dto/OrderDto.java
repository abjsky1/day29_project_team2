package team2.model.dto;

public class OrderDto {
    private int no;
    private int mno;
    private int amount;
    private String pname;

    
    public OrderDto(int no, int mno, int amount, String pname) {
        this.no = no;
        this.mno = mno;
        this.amount = amount;
        this.pname = pname;
    }
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public int getMno() {
        return mno;
    }
    public void setMno(int mno) {
        this.mno = mno;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }

    
}
