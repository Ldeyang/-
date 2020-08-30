package com.deyang.dao;

import com.deyang.bean.Book;
import com.deyang.bean.History;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author deyang
 * @date 2020/8/19 - 11:44
 */
@Repository
public interface IBookDao {
    @Select("select * from book")
    List<Book> getBooks();

    @Select("select bName from book where id=#{id}")
    String getBookName(Integer id);

    @Insert("insert into book(bName,bAuthor,bHouse,bPrice,bBorrow,weiZhi) values(#{bName},#{bAuthor},#{bHouse},#{bPrice},#{bBorrow},#{weiZhi})")
    void save(Book book);

    @Insert("insert into history(userId,bookId,borrowDate) values(#{userId},#{bookId},#{borrowDate})")
    void jieBook(History history);

    @Update("update history a,(select max(id) id from history where bookId=#{bookId}) b set a.returnDate=#{returnDate} where a.id=b.id")
    void huanBook(History history);

    @Update("update book set bBorrow=#{arg0} where id=#{arg1}")
    void setbBorrow(int i,Integer p);

    @Select("select * from history where userId=(select id from user where username=#{user})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "userId",column = "userId"),
            @Result(property = "bookId",column = "bookId"),
            @Result(property = "bookName",column = "bookId",javaType = String.class,one = @One(select="com.deyang.dao.IBookDao.getBookName")),
            @Result(property = "borrowDate",column = "borrowDate"),
            @Result(property = "returnDate",column = "returnDate"),
    })
    List<History> history(String user);

    @Select("select * from history")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "userId",column = "userId"),
            @Result(property = "userName",column = "userId",javaType = String.class,one = @One(select="com.deyang.dao.IUserDao.getUserName")),
            @Result(property = "bookId",column = "bookId"),
            @Result(property = "bookName",column = "bookId",javaType = String.class,one = @One(select="com.deyang.dao.IBookDao.getBookName")),
            @Result(property = "borrowDate",column = "borrowDate"),
            @Result(property = "returnDate",column = "returnDate"),
    })
    List<History> aHistory();

    @Delete("delete from book where id=#{id}")
    void delBookById(Integer id);
}
