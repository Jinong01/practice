package service;

import Mapper.UserMapper;
import config.MysqlConfig;
import org.apache.ibatis.session.SqlSession;
import pojo.User;

import java.io.IOException;
import java.util.Scanner;


public class UserService {
    public Scanner sc = new Scanner(System.in);

    public static UserMapper mapper() throws IOException {
        SqlSession sqlSession = MysqlConfig.mysqlConnect();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper ;
    }

    public void signup() throws IOException {
        while (true) {
            System.out.println("New ID : "); String userId = sc.next();
            System.out.println("New PWD : "); String userPwd = sc.next();

            if (mapper().check(userId) == null) {
                User user = new User(userId, userPwd);
                mapper().insert(user);
                System.out.println("회원가입 성공!!");
                return;
            } else {
                System.out.println("중복된 아이디입니다!!");
            }
        }
    }

    public User login() throws IOException {
        if (mapper().checkDb() == null || mapper().checkDb() == 0){
            System.out.println("회원가입 먼저 하세요!!");
            return null;
        }
        while(true) {
            System.out.println("ID : "); String userId = sc.next();
            System.out.println("PWD : "); String userPwd = sc.next();

            User user = new User(userId,userPwd);

            if (mapper().login(user)!=null){
            System.out.println("로그인 성공!!");
            return user;
            } else{
                System.out.println("로그인 실패!!");
            }
        }
    }

    public void delete(User user) throws IOException {
        while(true) {
            System.out.println("ID : "); String userId = sc.next();
            System.out.println("PWD : "); String userPwd = sc.next();
            boolean result = userId.equals(user.getUserId()) && userPwd.equals(user.getUserPwd());
            if (result){
                mapper().delete(user.getUserId());
                System.out.println("회원탈퇴 성공!!");
                return;
            } else{
                System.out.println("정보가 틀립니다!!");
            }
        }
    }

    public void update(User user) throws IOException {
        System.out.println("현재 ID : "); String userId = sc.next();
        System.out.println("현재 PWD : "); String nowPwd = sc.next();
        System.out.println("변경할 PWD : "); String newPwd = sc.next();
        boolean result = userId.equals(user.getUserId()) && nowPwd.equals(user.getUserPwd());
        if (result){
        mapper().update(userId , nowPwd , newPwd);
        System.out.println("PWD 변경 성공!!");
        } else {
            System.out.println("정보가 틀립니다!!");
        }

    }
}
