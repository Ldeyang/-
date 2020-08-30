package com.deyang.dao;

import com.deyang.bean.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author deyang
 * @date 2020/8/19 - 14:42
 */
@Repository
public interface IRoleDao {
    @Select("select * from role where id in(select roleId from user_role where userId=#{id})")
    public List<Role> getRoleById(Integer id);

    @Select("select * from role where id not in(select roleId from user_role where userId=#{id})")
    List<Role> addRole(Integer id);

    @Insert("insert into user_role(userId,roleId) values(#{arg0},#{arg1})")
    void addRoles(Integer id, Integer integer);

    @Delete("Delete from user_role where userId=#{arg0} and roleId=#{arg1}")
    void delRoles(Integer id, Integer integer);
}
