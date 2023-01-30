package run;

import Product.Product;
import Product.ProductManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ProductManager product = new ProductManager();
        int luaChon;
        do {
            System.out.println("MENU-------------------------------");
            System.out.println(
                            "1.Thêm sản phẩm\n" +
                            "2.Sửa thông tin sản phẩm theo id\n" +
                            "3.Xoá sản phẩm theo id\n" +
                            "4.Hiển thị danh sách sản phẩm\n" +
                            "5.Tìm kiếm sản phẩm theo tên\n" +
                            "6.Sắp xếp sản phẩm theo giá\n" +
                            "0. Thoát"
            );
            System.out.print("Vui lòng chọn : ");
            luaChon = input.nextInt();
            input.nextLine();
            switch (luaChon) {
                case 1 -> {
                    System.out.print("Nhập id: ");
                    String id = input.nextLine();
                    System.out.print("Nhập tên SP: ");
                    String name = input.nextLine();
                    System.out.print("Nhập giá SP: ");
                    int price = input.nextInt();
                    product.add(new Product(id, name, price));
                }
                case 2 -> {
                    System.out.print("Nhập id sp muốn sửa: ");
                    String checkId = input.nextLine();
                    System.out.print("Nhập id mới: ");
                    String newId = input.nextLine();
                    System.out.print("Nhập tên mới: ");
                    String newName = input.nextLine();
                    System.out.print("Nhập giá mới: ");
                    int newPrice = input.nextInt();
                    product.SetById(checkId, new Product(newId, newName, newPrice));
                }
                case 3 -> {
                    System.out.print("Nhập vào id SP muốn xóa: ");
                    String delById = input.nextLine();
                    product.delProduct(delById);
                }
                case 4 -> product.display();
                case 5 -> {
                    System.out.print("Nhập tên SP muốn tìm: ");
                    String searchByName = input.nextLine();
                    product.searchByName(searchByName);
                }
                case 6 -> {
                    product.sortAscendingByPrice();
                    product.display();
                }
            }
        } while (luaChon != 0);
    }
}
