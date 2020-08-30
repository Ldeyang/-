package com.deyang.service;

import com.deyang.bean.Role;

import java.util.List;

/**
 * @author deyang
 * @date 2020/8/20 - 19:53
 */
public interface IRoleService {
    List<Role> addRole(Integer id);

    void addRoles(Integer id, List<Integer> ids);

    List<Role> delRole(Integer id);

    void delRoles(Integer id, List<Integer> ids);
}
