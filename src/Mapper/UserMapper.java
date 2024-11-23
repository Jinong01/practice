package Mapper;

import org.apache.ibatis.annotations.*;
import pojo.User;

import java.sql.ResultSet;

public interface UserMapper {

    @Select("select * from user where user_id = #{logId} and user_pwd = #{logPwd};")
    Integer login (@Param("logId") String logID , @Param("logPwd") String logPwd);

    @Insert("insert into user (user_id , user_pwd) values ( #{user_id} , #{user_pwd} );")
    void insert (@Param("user_id") String user_id , @Param("user_pwd") String user_pwd);

    @Delete("delete from user where user_pwd = #{user_pwd};")
    void delete (String user_pwd);

    @Update("update user set user_pwd = #{newPwd} where user_id = #{user_id} and user_pwd = #{nowPwd};")
    void update (@Param("user_id")String user_id , @Param("nowPwd")String nowPwd , @Param("newPwd")String newPwd );


}
