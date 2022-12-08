package supermarket.menu;

import supermarket.manager.ManagerAccount;
import supermarket.manager.ManagerProduct;

import supermarket.model.Order;
import supermarket.model.Product;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuAdmin {
    public static List<Product> PRODUCTS = new ArrayList<Product>();
    public static List<Order> ORDERS = new ArrayList<Order>();
    public static void showMenuAdmin() {
        System.out.println("Danh sách các chức năng của Admin");
        System.out.println("1. Thay đổi mật khẩu");
        System.out.println("2. Thêm sản phẩm");
        System.out.println("3. Sửa sản phẩm");
        System.out.println("4. Hiển thị danh sách sản phẩm");
        System.out.println("5. Thoát");
    }

    public static void menuAdmin() {
        if (ManagerAccount.dangNhapAdmin() == false) {
            return;
        }

        int choice = 0;

        do {
            showMenuAdmin();
            Scanner inputs = new Scanner(System.in);
            try {
                System.out.println("Chọn chức năng: ");
                choice = Integer.parseInt(inputs.nextLine());
                ManagerProduct managerProduct = new ManagerProduct();

                switch (choice) {
                    case 1:
                        ManagerAccount.doiMatkhau();
                        break;
                    case 2:
                        managerProduct.insert();
                        break;
                    case 3:
                        managerProduct.update();
                        break;
                    case 4:
                        managerProduct.show();
                        break;
                    case 5:
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
