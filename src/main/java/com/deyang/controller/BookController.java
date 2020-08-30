package com.deyang.controller;

import com.deyang.bean.Book;
import com.deyang.bean.History;
import com.deyang.service.IBookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author deyang
 * @date 2020/8/18 - 15:09
 */
@Controller
public class BookController {
    @Autowired
    private IBookService bookService;
    @RequestMapping("/getBooks")
    public ModelAndView getBooks(@RequestParam(name = "page",defaultValue = "1")Integer pageID,@RequestParam(name = "size",defaultValue = "10")Integer pageSIZE){
        ModelAndView view=new ModelAndView();
        PageHelper.startPage(pageID,pageSIZE);
        List<Book> books=bookService.getBooks();
        PageInfo<Book> info=new PageInfo<>(books,5);
        view.addObject("info",info);
        view.setViewName("book-List");
        return view;
    }
    @RequestMapping("/delBookById")
    public String delBookById(@RequestParam(value = "id",required = true)Integer id){
        bookService.delBookById(id);
        return "redirect:getBooks";
    }
    @RequestMapping("/saveBook")
    public ModelAndView saveBook(Book book){
        ModelAndView view=new ModelAndView();
        bookService.save(book);
        view.setViewName("book-add");
        return view;
    }
    @RequestMapping("/jieBook")
    public ModelAndView jieBook(History history){
        ModelAndView view=new ModelAndView();
        bookService.jieBook(history);
        view.setViewName("goBook");
        return view;
    }
    @RequestMapping("/huanBook")
    public ModelAndView huanBook(History history){
        ModelAndView view=new ModelAndView();
        bookService.huanBook(history);
        view.setViewName("toBook");
        return view;
    }
    @RequestMapping("/aHistory")
    public ModelAndView aHistory(@RequestParam(name = "page",defaultValue = "1")Integer pageID,@RequestParam(name = "size",defaultValue = "10")Integer pageSIZE){
        ModelAndView view=new ModelAndView();
        PageHelper.startPage(pageID,pageSIZE);
        List<History> histories=bookService.aHistory();
        PageInfo<History> info=new PageInfo<>(histories,5);
        view.addObject("info",info);
        view.setViewName("aHistory");
        return view;
    }
    @RequestMapping("/history")
    public ModelAndView history(HttpServletRequest request, @RequestParam(name = "page",defaultValue = "1")Integer pageID, @RequestParam(name = "size",defaultValue = "10")Integer pageSIZE){
        ModelAndView view=new ModelAndView();
        String user = request.getRemoteUser();
        PageHelper.startPage(pageID,pageSIZE);
        List<History> histories=bookService.history(user);
        PageInfo<History> info=new PageInfo<>(histories,5);
        view.addObject("info",info);
        view.setViewName("history");
        return view;
    }
}
