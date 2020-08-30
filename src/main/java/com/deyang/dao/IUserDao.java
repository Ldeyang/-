package com.deyang.dao;

import com.deyang.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author deyang
 * @date 2020/8/19 - 14:25
 */
@Repository
public interface IUserDao {
    @Select("select * from user where username=#{s}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "xId",column = "xid"),
            @Result(property = "phone",column = "phone"),
            @Result(property = "password",column = "password"),
            @Result(property = "ZT",column = "ZT"),
            @Result(property = "roles" ,column = "id",javaType = List.class,many = @Many(select="com.deyang.dao.IRoleDao.getRoleById")),
    })
    User getUser(String s);

    @Select("select userName from user where id=#{id}")
    String getUserName(Integer id);

    @Select("select * from user")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "xId",column = "xid"),
            @Result(property = "phone",column = "phone"),
            @Result(property = "password",column = "password"),
            @Result(property = "ZT",column = "ZT"),
    })
    List<User> getUsers();

    @Insert("insert into user(xid,phone,username,password,ZT) values(#{xId},#{phone},#{username},#{password},0)")
    void saveUser(User user);

    @Select("select * from user where id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "xId",column = "xid"),
            @Result(property = "phone",column = "phone"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "ZT",column = "ZT"),
            @Result(property = "roles",column = "id",javaType = List.class,many = @Many(select="com.deyang.dao.IRoleDao.getRoleById")),
    })
    User findUserById(Integer id);

    @Delete("delete from user_role where userId=#{id}")
    void delUserAndRoleById(Integer id);

    @Delete("delete from user where id=#{id}")
    void delUserById(Integer id);

    @Update("update user set password=#{arg1} where username=#{arg0}")
    void setUserPassword(String name, String encode);

    @Update("update user set ZT=1 where Id=#{id}")
    void addBlacklist(Integer id);

    @Select("select * from user where ZT=1")
    List<User> getBlacklist();

    @Update("update user set ZT=0 where id=#{id}")
    void delBlacklist(Integer id);
}
