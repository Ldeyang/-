package com.deyang.bean;

/**
 * @author deyang
 * @date 2020/8/19 - 11:31
 */
public class Book {
    private Integer id;
    private String bName;
    private String bAuthor;
    private String bHouse;
    private Double bPrice;
    private Integer bBorrow;
    private String bBorrowStr;
    private String weiZhi;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getbAuthor() {
        return bAuthor;
    }

    public void setbAuthor(String bAuthor) {
        this.bAuthor = bAuthor;
    }

    public String getbHouse() {
        return bHouse;
    }

    public void setbHouse(String bHouse) {
        this.bHouse = bHouse;
    }

    public Double getbPrice() {
        return bPrice;
    }

    public void setbPrice(Double bPrice) {
        this.bPrice = bPrice;
    }

    public Integer getbBorrow() {
        return bBorrow;
    }

    public void setbBorrow(Integer bBorrow) {
        this.bBorrow = bBorrow;
    }

    public String getbBorrowStr() {
        if(getbBorrow()!=null){
            if(getbBorrow()==0){
                bBorrowStr="可借阅";
            }
            if(getbBorrow()==1){
                bBorrowStr="被借阅";
            }
        }
        return bBorrowStr;
    }

    public void setbBorrowStr(String bBorrowStr) {
        this.bBorrowStr = bBorrowStr;
    }

    public String getWeiZhi() {
        return weiZhi;
    }

    public void setWeiZhi(String weizhi) {
        this.weiZhi = weizhi;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bName='" + bName + '\'' +
                ", bAuthor='" + bAuthor + '\'' +
                ", bHouse='" + bHouse + '\'' +
                ", bPrice=" + bPrice +
                ", bBorrow=" + bBorrow +
                ", bBorrowStr='" + bBorrowStr + '\'' +
                ", weiZhi='" + weiZhi + '\'' +
                '}';
    }
}
