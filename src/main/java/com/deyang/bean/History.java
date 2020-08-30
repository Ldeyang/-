package com.deyang.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author deyang
 * @date 2020/8/20 - 12:11
 */
public class History {
    private Integer id;
    private Integer userId;
    private String userName;
    private Integer bookId;
    private String bookName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date borrowDate;
    private String borrowDateStr;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date returnDate;
    private String returnDateStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getBorrowDateStr() {
        if (borrowDate!=null){
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");
            borrowDateStr=format.format(borrowDate);
        }
        return borrowDateStr;
    }

    public void setBorrowDateStr(String borrowDateStr) {
        this.borrowDateStr = borrowDateStr;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getReturnDateStr() {
        if (returnDate!=null){
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");
            returnDateStr=format.format(returnDate);
        }
        return returnDateStr;
    }

    public void setReturnDateStr(String returnDateStr) {
        this.returnDateStr = returnDateStr;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", borrowDate=" + borrowDate +
                ", borrowDateStr=" + borrowDateStr +
                ", returnDate=" + returnDate +
                ", returnDateStr=" + returnDateStr +
                '}';
    }
}
