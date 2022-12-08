package supermarket.manager;

import supermarket.menu.MenuCustomer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ManagerAccount {
    static Scanner scanner = new Scanner(System.in);
    static Map<String, String> map = new HashMap<>();

    static {
        if (map.size() == 0) {
            map.put("Admin", "Admin");
        }
    }

    public static void dangKy() {
        System.out.println("Nhập tên đăng nhập");
        String username = scanner.nextLine();

        System.out.println("Nhập mật khẩu");
        String password = scanner.nextLine();

        if (!map.containsKey(username)) {
            map.put(username, password);
        }
    }

    public static boolean dangNhapAdmin() {
        System.out.println("Nhập tên đăng nhập");
        String username = scanner.nextLine();

        System.out.println("Nhập mật khẩu");
        String password = scanner.nextLine();

        if (username.equals("Admin") && password.equals(map.get("Admin"))) {
            System.out.println("Đăng nhập Admin thành công!");
            return true;
        } else {
            System.out.println("Đăng nhập thất bại!!!");
            return false;
        }
    }

    public static void dangNhap() {
        System.out.println("Nhập tên đăng nhập");
        String username = scanner.nextLine();

        System.out.println("Nhập mật khẩu");
        String password = scanner.nextLine();

        if (map.containsKey(username) && map.get(username).equals(password)) {
            System.out.println("Đăng nhập thành công!");
            MenuCustomer.username = username;
        } else {
            System.out.println("Đăng nhập thất bại!!!");
        }
    }

    public static void doiMatkhau() {
        while (true) {
            System.out.println("Nhập tên đăng nhập");
            String username = scanner.nextLine();

            System.out.println("Nhập mật khẩu cũ");
            String oldpassword = scanner.nextLine();

            if (map.containsKey(username) && map.get(username).equals(oldpassword)) {
                System.out.println("Nhập mật khẩu mới");
                String newPassword = scanner.nextLine();

                map.put(username, newPassword);
                System.out.println("Đổi mật khẩu thành công!");
                break;
            } else {
                System.out.println("Mật khẩu cũ không đúng, mời nhập lại!");
            }
        }
    }
}
