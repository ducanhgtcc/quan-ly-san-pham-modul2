package supermarket.manager;

import supermarket.menu.MenuAdmin;
import supermarket.menu.MenuCustomer;
import supermarket.model.Order;
import supermarket.model.OrderDetail;
import supermarket.model.Product;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ManagerOrder1 {
    public void order() {
        Scanner inputs = new Scanner(System.in);
        System.out.println("-------------------Mua sản phẩm:----------------");

        try {
            System.out.println("Mã đặt hàng: ");
            int id = Integer.parseInt(inputs.nextLine());

            System.out.println("Nhập tên khách hàng: ");
            String customerName = inputs.nextLine();

            System.out.println("Nhập số điện thoại: ");
            String phone = inputs.nextLine();

            System.out.println("Nhập số email: ");
            String email = inputs.nextLine();

            Order order = new Order(id, customerName, phone, email);

            int productId = -1;

            while (true) {
                inputs = new Scanner(System.in);

                System.out.println("Nhập mã sản phẩm: ");
                productId = Integer.parseInt(inputs.nextLine());

                if (productId == -1) {
                    break;
                }

                System.out.println("Nhập số lượng: ");
                int quantity = Integer.parseInt(inputs.nextLine());

                Product product = null;

                for (Product p : MenuCustomer.PRODUCTS1) {
                    if (p.getId() == productId) {
                        product = p;
                        break;
                    }
                }
                if (product == null) {
                    System.out.println("Mã sản phẩm không tồn tại!");
                }

                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setId(1);
                orderDetail.setOrderId(order.getId());
                orderDetail.setPrice(product.getPrice());
                orderDetail.setProductId(productId);
                orderDetail.setQuantity(quantity);

                order.getOrderDetails().add(orderDetail);
            }
            MenuCustomer.ORDERS1.add(order);
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("Bạn đã nhập sai giá trị, xin vui lòng nhập lại!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void show() {
        System.out.println("Danh sách đặt hàng: ");
        String header = String.format("%5s%15s%30s%30s", "Mã", "Tên khách hành", "Số điện thoại", "Email");
        System.out.println(header);
        ManagerProduct1 managerProduct1 = new ManagerProduct1();

        for (Order order : MenuCustomer.ORDERS1) {
            String str = String.format("%5d%15s%30d%30s", order.getId(), order.getCustomerName(), order.getPhone(),
                    order.getEmail());
            System.out.println(str);

            String orderDetailHeader = String.format("%30s%10s%30s%30s", "STT", "Tên sản phẩm", "Giá", "Số lượng");
            System.out.println(orderDetailHeader);

            int i = 1;
            for (OrderDetail orderDetail : order.getOrderDetails()) {
                Product p = managerProduct1.getById(orderDetail.getProductId());

                String orderDetailRow = String.format("%30s%10s%30s%30s", i, p.getName(), orderDetail.getPrice(),
                        orderDetail.getQuantity());
                System.out.println(orderDetailRow);
                i++;
            }
        }
    }
}
