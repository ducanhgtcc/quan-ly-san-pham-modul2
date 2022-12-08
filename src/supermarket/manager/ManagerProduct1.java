package supermarket.manager;

import supermarket.menu.MenuAdmin;
import supermarket.menu.MenuCustomer;
import supermarket.model.Product;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ManagerProduct1 {
    public void insert() {
        Scanner inputs = new Scanner(System.in);
        System.out.println("Nhập thông tin sản phẩm: ");

        try {
            System.out.println("Mã: ");
            int id = Integer.parseInt(inputs.nextLine());

            System.out.println("Tên: ");
            String name = inputs.nextLine();

            System.out.println("Số lượng: ");
            int quantity = Integer.parseInt(inputs.nextLine());

            System.out.println("Ghi chú: ");
            String description = inputs.nextLine();

            System.out.println("Giá: ");
            double price = Double.parseDouble(inputs.nextLine());

            Product p = new Product(id, name, quantity, description, price);
            MenuCustomer.PRODUCTS1.add(p);
        } catch (InputMismatchException e) {
            System.out.println("Bạn đã nhập sai giá trị, xin vui lòng nhập lại!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void show() {
        System.out.println("Danh sách sản phẩm: ");
        String header = String.format("%s%15s%30s%15s%15s", "Mã", "Tên", "Số lượng", "Giá", "Ghi chú");
        System.out.println(header);
        for (Product p : MenuCustomer.PRODUCTS1) {
            String str = String.format("%d%15s%30d%15f%15s", p.getId(), p.getName(), p.getQuantity(),
                    p.getPrice(), p.getDescription());
            System.out.println(str);
        }
    }

    public void update() {
        Scanner inputs = new Scanner(System.in);

        try {
            System.out.println("Nhập mã: ");
            int id = inputs.nextInt();
            Product product = null;

            for (Product p : MenuCustomer.PRODUCTS1) {
                if (p.getId() == id) {
                    product = p;
                    break;
                }
            }

            if (product == null) {
                System.out.println("Mã sản phẩm không tồn tại. Xin vui lòng nhập lại!");
            }

            System.out.println("Thông tin sản phẩm");
            String str = String.format("%d%15s%30d%15f%15s", product.getId(), product.getName(), product.getQuantity(),
                    product.getPrice(), product.getDescription());
            System.out.println(str);

            for (int i = 0; i < MenuCustomer.PRODUCTS1.size(); i++) {
                if (id == MenuCustomer.PRODUCTS1.get(i).getId()) {
                    inputs.nextLine();

                    System.out.println("Tên: ");
                    String name = inputs.nextLine();

                    System.out.println("Số lượng: ");
                    int quantity = Integer.parseInt(inputs.nextLine());

                    System.out.println("Ghi chú:");
                    String description = inputs.nextLine();

                    System.out.println("Giá:");
                    double price = Double.parseDouble(inputs.nextLine());

                    MenuCustomer.PRODUCTS1.get(i).setName(name);
                    MenuCustomer.PRODUCTS1.get(i).setQuantity(quantity);
                    MenuCustomer.PRODUCTS1.get(i).setDescription(description);
                    MenuCustomer.PRODUCTS1.get(i).setPrice(price);
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Bạn đã nhập sai giá trị, xin vui lòng nhập lại!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Product getById(int id) {
        Product product = new Product();

        for (Product p : MenuCustomer.PRODUCTS1) {
            if (p.getId() == id) {
                product = p;
                break;
            }
        }
        return product;
    }
}
