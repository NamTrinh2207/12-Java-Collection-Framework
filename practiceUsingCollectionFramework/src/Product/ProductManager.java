package Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class ProductManager {
    private final ArrayList<Product> products;

    public ProductManager() {
        this.products = new ArrayList<>();
    }

    public ProductManager(ArrayList<Product> products) {
        this.products = products;
    }

    // thêm sp
    public void add(Product product) {
        this.products.add(product);
    }

    // hiển thị
    public void display() {
        for (Product o : products) {
            System.out.println(o);
        }
    }

    //xóa theo id
    public void delProduct(String id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    //Sửa SP theo id
    public void SetById(String id, Product product) {
        Product product1;
        for (Product p : products) {
            if (p.getId().equals(id)) {
                product1 = p;
                product1.setId(product.getId());
                product1.setName(product.getName());
                product1.setPrice(product.getPrice());
                break;
            } else {
                System.out.println("Vui lòng nhâp lại!!!");
            }
        }
    }

    //tìm kiếm theo tên
    public void searchByName(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                System.out.println(product);
            }
        }
    }

    //sắp xếp tăng dần
    public void sortAscendingByPrice() {
        this.products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() > o2.getPrice()) {
                    return 1;
                } else if (o1.getPrice() < o2.getPrice()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductManager that = (ProductManager) o;
        return Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products);
    }

}
