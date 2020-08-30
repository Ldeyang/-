package com.deyang.service;

import com.deyang.bean.Role;
import com.deyang.dao.IRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author deyang
 * @date 2020/8/20 - 19:54
 */
@Service
public class IRoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao iRoleDao;
    @Override
    public List<Role> addRole(Integer id) {
        List<Role> roles=iRoleDao.addRole(id);
        return roles;
    }

    @Override
    public void addRoles(Integer id, List<Integer> ids) {
        for (Integer integer:ids){
            iRoleDao.addRoles(id,integer);
        }
    }

    @Override
    public List<Role> delRole(Integer id) {
        return iRoleDao.getRoleById(id);
    }
    @Override
    public void delRoles(Integer id, List<Integer> ids) {
        for (Integer integer:ids){
            iRoleDao.delRoles(id,integer);
        }
    }
}
