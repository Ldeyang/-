package com.deyang.controller;

import com.deyang.bean.Role;
import com.deyang.bean.User;
import com.deyang.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author deyang
 * @date 2020/8/20 - 19:47
 */
@Controller
public class RoleController {
    @Autowired
    private IRoleService iRoleService;
    @RequestMapping("/addRole")
    public ModelAndView addRole(@RequestParam(name = "id",required = true)Integer id){
        ModelAndView view=new ModelAndView();
        List<Role> roles=iRoleService.addRole(id);
        view.addObject("id",id);
        view.addObject("roles",roles);
        view.setViewName("user-role-add");
        return view;
    }
    @RequestMapping("/delRole")
    public ModelAndView delRole(@RequestParam(name = "id",required = true)Integer id){
        ModelAndView view=new ModelAndView();
        List<Role> roles=iRoleService.delRole(id);
        view.addObject("id",id);
        view.addObject("roles",roles);
        view.setViewName("user-role-del");
        return view;
    }
    @RequestMapping("/addRoles")
    public String addRoles(@RequestParam(name = "userId",required = true)Integer id,@RequestParam(name = "ids",required = true)List<Integer> ids){
        iRoleService.addRoles(id,ids);
        return "redirect:userList";
    }
    @RequestMapping("/delRoles")
    public String delRoles(@RequestParam(name = "userId",required = true)Integer id,@RequestParam(name = "ids",required = true)List<Integer> ids){
        iRoleService.delRoles(id,ids);
        return "redirect:userList";
    }
}
