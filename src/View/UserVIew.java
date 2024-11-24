package View;
import pojo.User;
import service.UserService;
import java.io.IOException;
import java.util.Scanner;



public class UserVIew {
    public Scanner sc = new Scanner(System.in);
    public UserService us = new UserService();


    public void userPage(User user) throws IOException {

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
                    us.update(user);
                    break;

                case 2:
                    us.delete(user);
                    return;

                default:
                    return;
            }
        }

    }
}
