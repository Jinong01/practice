package View;

import Mapper.UserMapper;

import org.apache.ibatis.annotations.Insert;
import pojo.User;
import service.UserService;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.Scanner;

import static service.UserService.*;

public class MainView {
    public Scanner sc = new Scanner(System.in);
    public UserVIew uv = new UserVIew();
    public void mainPage() throws IOException {
        while (true) {
            System.out.println("1.Sign up  2.Login  *.Exit");
            int choose = 0;

            try {
                choose = sc.nextInt();
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다.");
                sc.nextLine();
                continue;
            }

            switch (choose) {
                case 1:
                    System.out.println("New ID : "); String user_id = sc.next();
                    System.out.println("New PWD : "); String user_pwd = sc.next();
                    mapper().insert(user_id,user_pwd);
                    System.out.println("Signup Success!!");
                    break;

                case 2:
                    System.out.println("ID : "); String logId = sc.next();
                    System.out.println("PWD : "); String logPwd = sc.next();
                    Integer result = (mapper().login(logId,logPwd));

                        if (result != null){
                            System.out.println("Login Success!!");
                            uv.userView();
                        } else if(result == null){
                            System.out.println("Login Fail!!");
                        }
                    break;

                default:
                    System.out.println("GoodBye~");
                    return;
            }
        }
    }
}
