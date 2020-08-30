package com.deyang.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author deyang
 * @date 2020/8/19 - 16:50
 */
@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/book-add")
    public ModelAndView bookAdd(){
        ModelAndView view=new ModelAndView();
        view.setViewName("book-add");
        return view;
    }
  
    @RequestMapping("/main")
    public ModelAndView main(){
        ModelAndView view=new ModelAndView();
        view.setViewName("main");
        return view;
    }
    @RequestMapping("/goBook")
    public ModelAndView goBook(){
        ModelAndView view=new ModelAndView();
        view.setViewName("goBook");
        return view;
    }
    @RequestMapping("/toBook")
    public ModelAndView toBook(){
        ModelAndView view=new ModelAndView();
        view.setViewName("toBook");
        return view;
    }
    @RequestMapping("/userAdd")
    public ModelAndView userAdd(){
        ModelAndView view=new ModelAndView();
        view.setViewName("user-add");
        return view;
    }
}
