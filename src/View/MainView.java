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
    public UserService us = new UserService();

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
                    us.signup();
                    break;

                case 2:
                     User user = us.login();
                     uv.userPage(user);
                    break;

                default:
                    System.out.println("GoodBye~");
                    return;
            }
        }
    }
}
