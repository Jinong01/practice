package View;
import service.UserService;
import com.mysql.cj.jdbc.integration.c3p0.MysqlConnectionTester;
import service.UserService;

import java.io.IOException;
import java.util.Scanner;

import static service.UserService.mapper;

public class UserVIew {
    public Scanner sc = new Scanner(System.in);

    public void userView() throws IOException {
        while (true){
            System.out.println("1.Update  2.Delete  *.Logout");
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
                    System.out.println("ID : "); String user_id = sc.next();
                    System.out.println("PWD : "); String nowPwd = sc.next();
                    System.out.println("New PWD : "); String newPwd = sc.next();
                    mapper().update(user_id,nowPwd,newPwd);
                    System.out.println("Update Success!!");
                    break;

                case 2:
                    System.out.println("PWD 확인 : "); String user_pwd = sc.next();
                    mapper().delete(user_pwd);
                    System.out.println("Delete Success!!");
                    break;

                default:
                    return;
            }
        }

    }
}
