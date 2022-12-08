import supermarket.menu.MenuAdmin;
import supermarket.menu.MenuCustomer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Admin");
            System.out.println("2. Khách hàng");
            System.out.println("3. Thoát");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    MenuAdmin.menuAdmin();
                    break;
                case 2:
                    MenuCustomer.menuCustomer();
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }
}
