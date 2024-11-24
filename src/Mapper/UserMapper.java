package Mapper;

import org.apache.ibatis.annotations.*;
import pojo.User;



public interface UserMapper {

    @Select("select * from user where user_id = #{userId} and user_pwd = #{userPwd};")
    User login (User user);

    @Insert("insert into user (user_id , user_pwd) values ( #{userId} , #{userPwd} );")
    void insert (User user);

    @Delete("delete from user where user_id = #{id};")
    void delete (String id);

    @Update("update user set user_pwd = #{newPwd} where user_id = #{userId} and user_pwd = #{nowPwd};")
    void update (@Param("userId") String userId , @Param("nowPwd") String nowPwd , @Param("newPwd") String newPwd);

    @Select("select count(id) from user")
    Integer checkDb ();

    @Select("select * from user where user_id = #{signId};")
    Integer check(String signId);
}
