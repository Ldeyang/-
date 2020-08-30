package com.deyang.service;

import com.deyang.bean.Role;
import com.deyang.bean.User;
import com.deyang.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author deyang
 * @date 2020/8/19 - 13:58
 */
@Service("IUserServiceImpl")
@Transactional
public class IUserServiceImpl implements IUserService {
    @Autowired
    private IUserDao iUserDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=iUserDao.getUser(s);
        System.out.println(user);
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),user.getZT()==0?true:false,true,true,true,getAuthorities(user.getRoles()));
    }

    @Override
    public List<User> getUsers() {
        return iUserDao.getUsers();
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        iUserDao.saveUser(user);
    }

    @Override
    public User findUserById(Integer id) {
        User user=iUserDao.findUserById(id);
        return user;
    }

    @Override
    public void delUserById(Integer id) {
        iUserDao.delUserAndRoleById(id);
        iUserDao.delUserById(id);
    }

    @Override
    public void setUserPassword(String name, String password1) {
        String encode = bCryptPasswordEncoder.encode(password1);
        iUserDao.setUserPassword(name,encode);
    }

    @Override
    public void addBlacklist(Integer id) {
        iUserDao.addBlacklist(id);
    }

    @Override
    public List<User> blacklist() {
        return iUserDao.getBlacklist();
    }

    @Override
    public void delBlacklist(Integer id) {
        iUserDao.delBlacklist(id);
    }

    private static List<SimpleGrantedAuthority> getAuthorities(List<Role> Roles) {
        List<SimpleGrantedAuthority> list=new ArrayList<>();
        for(Role role: Roles){
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRolename()));
        }
        return list;
    }
}
