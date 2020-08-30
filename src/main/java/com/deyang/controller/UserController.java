package com.deyang.controller;

import com.deyang.bean.User;
import com.deyang.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author deyang
 * @date 2020/8/20 - 10:44
 */
@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping("/userList")
    public ModelAndView userList(@RequestParam(value = "page",defaultValue = "1")Integer pageId,@RequestParam(value = "size",defaultValue = "2")Integer size){
        ModelAndView view=new ModelAndView();
        PageHelper.startPage(pageId,size);
        List<User> users=iUserService.getUsers();
        PageInfo<User> info=new PageInfo<>(users,5);
        view.addObject("info",info);
        view.setViewName("user-list");
        return view;
    }
    @RequestMapping("/saveUser")
    public String saveUser(User user){
        iUserService.saveUser(user);
        return "redirect:userList";
    }
    @RequestMapping("/findUserById")
    public ModelAndView findUserById(@RequestParam(name = "id",required = true)Integer id){
        ModelAndView view=new ModelAndView();
        User user=iUserService.findUserById(id);
        view.addObject("user",user);
        view.setViewName("user");
        return view;
    }
    @RequestMapping("/delUserById")
    public String delUserById(@RequestParam(name = "id",required = true)Integer id){
        iUserService.delUserById(id);
        return "redirect:userList";
    }
    @RequestMapping("/toUserPassword")
    public ModelAndView toUserPassword(){
        ModelAndView view=new ModelAndView();
        view.setViewName("toUserPassword");
        return view;
    }
    @RequestMapping("/addBlacklist")
    public String addBlacklist(@RequestParam(name = "id",required = true)Integer id){
        iUserService.addBlacklist(id);
        return "redirect:userList";
    }
    @RequestMapping("/delBlacklist")
    public String delBlacklist(@RequestParam(name = "id",required = true)Integer id){
        iUserService.delBlacklist(id);
        return "redirect:blacklist";
    }
    @RequestMapping("/blacklist")
    public ModelAndView blacklist(@RequestParam(value = "page",defaultValue = "1")Integer pageId,@RequestParam(value = "size",defaultValue = "2")Integer size){
        ModelAndView view=new ModelAndView();
        PageHelper.startPage(pageId,size);
        List<User> users=iUserService.blacklist();
        PageInfo<User> info=new PageInfo<>(users,5);
        view.addObject("info",info);
        view.setViewName("blacklist");
        return view;
    }
    @RequestMapping("/setUserPassword")
    public ModelAndView setUserPassword(HttpServletRequest request, @RequestParam(name = "password1",required = true)String password1, @RequestParam(name = "password2",required = true)String password2){
        ModelAndView view=new ModelAndView();
        String remoteUser = request.getRemoteUser();
        if(!password1.equals(password2)){
            view.addObject("i","密码不一致");
            view.setViewName("toUserPassword");
        }else {
            iUserService.setUserPassword(remoteUser,password1);
            view.addObject("i","");
            view.setViewName("main");
        }
        return view;
    }
}
