package service;

import Mapper.UserMapper;
import config.MysqlConfig;
import org.apache.ibatis.session.SqlSession;
import pojo.User;

import java.io.IOException;


public class UserService {

    public static UserMapper mapper() throws IOException {
        MysqlConfig mysqlConfig = new MysqlConfig();
        SqlSession sqlSession = mysqlConfig.mysqlConnect();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper ;
    }
}
