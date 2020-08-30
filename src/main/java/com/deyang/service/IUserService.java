package com.deyang.service;

import com.deyang.bean.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * @author deyang
 * @date 2020/8/19 - 13:56
 */
public interface IUserService extends UserDetailsService {
    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;

    List<User> getUsers();

    void saveUser(User user);

    User findUserById(Integer id);

    void delUserById(Integer id);

    void setUserPassword(String name, String password1);

    void addBlacklist(Integer id);

    List<User> blacklist();

    void delBlacklist(Integer id);
}
