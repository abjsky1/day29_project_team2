package team2.model.dto;

public class ReivewDto {
    private int mno;
    private String reivContent;
    private int reivScope;

    public ReivewDto() {
    }

    public ReivewDto(int mno, String reivContent, int reivScope) {
        this.mno = mno;
        this.reivContent = reivContent;
        this.reivScope = reivScope;
    }

    public int getMno() {
        return mno;
    }

    public void setMno(int mno) {
        this.mno = mno;
    }

    public String getReivContent() {
        return reivContent;
    }

    public void setReivContent(String reivContent) {
        this.reivContent = reivContent;
    }

    public int getReivScope() {
        return reivScope;
    }

    public void setReivScope(int reivScope) {
        this.reivScope = reivScope;
    }

}
