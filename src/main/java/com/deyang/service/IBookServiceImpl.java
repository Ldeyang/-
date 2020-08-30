package com.deyang.service;

import com.deyang.bean.Book;
import com.deyang.bean.History;
import com.deyang.dao.IBookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author deyang
 * @date 2020/8/19 - 11:43
 */
@Service
@Transactional
public class IBookServiceImpl implements IBookService {
    @Autowired
    private IBookDao iBookDao;
    @Override
    public List<Book> getBooks() {
        return iBookDao.getBooks();
    }

    @Override
    public void save(Book book) {
        iBookDao.save(book);
    }

    @Override
    public void jieBook(History history) {
        iBookDao.jieBook(history);
        iBookDao.setbBorrow(1,history.getBookId());
    }

    @Override
    public void huanBook(History history) {
        iBookDao.huanBook(history);
        iBookDao.setbBorrow(0,history.getBookId());
    }

    @Override
    public List<History> history(String user) {
        return iBookDao.history(user);
    }

    @Override
    public List<History> aHistory() {
        return iBookDao.aHistory();
    }

    @Override
    public void delBookById(Integer id) {
        iBookDao.delBookById(id);
    }
}
