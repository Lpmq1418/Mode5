package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class List {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        java.util.List<Product> products = new ArrayList<>();
        products.add(new Product(0, "Iphone 11", "Iphone", 11.0, ECategory.PHONE, 1));
        products.add(new Product(1, "Laptop", "Laptop dell", 12.0, ECategory.LAPTOP, 2));
        products.add(new Product(2, "Iphone 12", "Iphone 12", 4.0, ECategory.PHONE, 3));
        products.add(new Product(3, "Laptop Gamming", "Gamming", 13.0, ECategory.LAPTOP, 4));
        products.add(new Product(4, "Laptop accer", "accer", 3.0, ECategory.LAPTOP, 1));

        int choose;
        Product product = new Product();


        do {
            System.out.println("--- CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM ---");
            System.out.println("Chọn chức năng theo số (để tiếp tục)");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Tìm sản phẩm có giá đắt nhất");
            System.out.println("7. Đọc từ file");
            System.out.println("8. Ghi vào file");
            System.out.println("9. Thoát chương trình");
            System.out.println("\uF0E8 Chọn chức năng: ");

            choose = scanner.nextInt();

            if (choose != 9) {
                if (choose == 1) {
                    if (products.size() < 1) {
                        System.out.println("Không có sản phẩm nào");
                    }
                    System.out.println("danh sách các sản phẩm: ");
                    for (Product item : products) {
                        System.out.println(item);
                    }
                } else if (choose == 2) {
                    System.out.println("Mời bạn nhập id sản phẩm: ");
                    Long id = scanner.nextLong();
                    if (id instanceof Long) {
                        product.setId(id);
                        System.out.println("Bạn đã nhập đúng id");
                    }
                    System.out.println("Mời bạn nhập tên sản phẩm: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    product.setName(name);
                    System.out.println("Mời bạn nhập mô tả sản phẩm: ");
                    String description = scanner.nextLine();
                    product.setDescription(description);
                    System.out.println("Mời bạn nhập giá sản phẩm: ");
                    Double price = scanner.nextDouble();
                    product.setPrice(price);
                    System.out.println("Mời bạn chọn danh mục sản phẩm (1: điện thoại; 2: máy tính): ");
                    int idCategory = scanner.nextInt();
                    if (idCategory == 1) {
                        product.setCategory(ECategory.PHONE);
                    } else if (idCategory == 2) {
                        product.setCategory(ECategory.LAPTOP);
                    }
                    System.out.println("Mời bạn nhập số lượng sản phẩm: ");
                    Integer quantity = scanner.nextInt();
                    product.setQuantity(quantity);
                    products.add(product);
                    System.out.println(product);
                } else if (choose == 3) {
                    System.out.println("Mời bạn nhập mã sản phẩm cần sửa: ");
                    Long Idsearch = scanner.nextLong();
                    do {
                        for (Product item : products) {
                            if (item.getId() == Idsearch) {
                                System.out.println("Mời bạn nhập mã sản phẩm: ");
                                Long id = scanner.nextLong();
                                if (id instanceof Long) {
                                    product.setId(id);
                                    System.out.println("Bạn đã nhập đúng id");
                                }
                                System.out.println("Mời bạn nhập tên sản phẩm: ");
                                scanner.nextLine();
                                String name = scanner.nextLine();
                                item.setName(name);
                                System.out.println("Mời bạn nhập mô tả sản phẩm: ");
                                String description = scanner.nextLine();
                                item.setDescription(description);
                                System.out.println("Mời bạn nhập giá sản phẩm: ");
                                Double price = scanner.nextDouble();
                                item.setPrice(price);
                                System.out.println("Mời bạn chọn danh mục sản phẩm (1: điện thoại; 2: máy tính): ");
                                int idCategory = scanner.nextInt();
                                if (idCategory == 1) {
                                    item.setCategory(ECategory.PHONE);
                                } else if (idCategory == 2) {
                                    item.setCategory(ECategory.LAPTOP);
                                }
                                System.out.println("Mời bạn nhập số lượng sản phẩm: ");
                                Integer quantity = scanner.nextInt();
                                item.setQuantity(quantity);
                                for (Product items : products) {
                                    System.out.println(items);
                                }

                                return;
                            } else {
                                System.out.println("Không tìm được sản phẩm với mã sản phẩm trên");
                                System.out.println("Mời bạn nhập lại mã sản phẩm");
                                Idsearch = scanner.nextLong();
                            }
                        }

                    } while (Idsearch instanceof Long);



                } else if (choose == 6) {
                    java.util.List<Product> ProductsMax = new ArrayList<>(products);
                    if (ProductsMax.size() > 0) {
                        ProductsMax.sort(Comparator.comparing(Product::getPrice));
                        System.out.println("Sản phẩm có giá đắt nhất: ");
                        System.out.println(ProductsMax.get(ProductsMax.size() - 1));
                    }
                }
            }

        } while (choose > 0 && choose < 9);
        System.out.println("bạn đã thoát");
    }
}
