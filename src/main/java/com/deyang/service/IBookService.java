package com.deyang.service;

import com.deyang.bean.Book;
import com.deyang.bean.History;

import java.util.List;

/**
 * @author deyang
 * @date 2020/8/19 - 11:48
 */
public interface IBookService {
    List<Book> getBooks();

    void save(Book book);

    void jieBook(History history);

    void huanBook(History history);

    List<History> history(String user);

    List<History> aHistory();

    void delBookById(Integer id);
}
