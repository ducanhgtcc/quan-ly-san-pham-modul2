package supermarket.menu;

import supermarket.manager.ManagerAccount;
import supermarket.manager.ManagerOrder1;
import supermarket.manager.ManagerProduct1;
import supermarket.model.Order;
import supermarket.model.Product;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuCustomer {
    public static List<Product> PRODUCTS1 = new ArrayList<Product>();
    public static List<Order> ORDERS1 = new ArrayList<Order>();
    static public String username;
    public static void showMenuCustomer() {
        System.out.println("Danh sách các chức năng của khách hàng");
        System.out.println("1. Đăng ký");
        System.out.println("2. Đăng nhập");
        System.out.println("3. Thay đổi mật khẩu");
        System.out.println("4. Mua hàng");
        System.out.println("5. Hiển thị danh sách đơn hàng");
        System.out.println("6. Thoát");
    }

    public static void menuCustomer() {

        int choice = 0;
        do {
            showMenuCustomer();
            Scanner inputs = new Scanner(System.in);
            try {
                System.out.println("Chọn chức năng: ");
                choice = Integer.parseInt(inputs.nextLine());
                ManagerOrder1 managerOrder1 = new ManagerOrder1();
                ManagerProduct1 managerProduct1 = new ManagerProduct1();

                switch (choice) {
                    case 1:
                        ManagerAccount.dangKy();
                        break;
                    case 2:
                        ManagerAccount.dangNhap();
                        break;
                    case 3:
                        ManagerAccount.doiMatkhau();
                        break;
                    case 4:
                        managerOrder1.order();
                        break;
                    case 5:
                        managerOrder1.show();
                        break;
                    case 6:
                        Runtime.getRuntime().exec("clear");
                        return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Bạn đã nhập sai giá trị, xin vui lòng nhập lại!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (choice != 6);
        System.out.println("Cám ơn bạn đã sử dụng phần mềm!");
    }
}
