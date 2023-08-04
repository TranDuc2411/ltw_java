/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbhandle;

import config.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;

/**
 *
 * @author pc
 */
public class ProductDao {

    // Thêm một bản ghi mới vào bảng product
    public boolean addProduct(Product product) throws ClassNotFoundException {
        String sql = "INSERT INTO product (name, price, description, quantity, categoryId) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = db.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, product.getName());
            statement.setInt(2, product.getPrice());
            statement.setString(3, product.getDescription());
            statement.setInt(4, product.getQuantity());
            statement.setInt(5, product.getCategoryId());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Lấy danh sách tất cả các bản ghi trong bảng product
    public List<Product> getAllProduct() throws ClassNotFoundException {
        List<Product> listProduct = new ArrayList<>();
        String sql = "SELECT * FROM product";

        try (Connection connection = db.getConnection(); PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getInt("price"));
                product.setAvatar(resultSet.getString("avatar"));
                product.setDescription(resultSet.getString("description"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setCategoryId(resultSet.getInt("categoryId"));

                listProduct.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listProduct;
    }

    public Product getProductById(int id) throws ClassNotFoundException {
        Product product = null;
        String sql = "SELECT * FROM product WHERE id = ?";

        try (Connection connection = db.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    product = new Product();  // Khởi tạo đối tượng Product

                    product.setId(resultSet.getInt("id"));
                    product.setName(resultSet.getString("name"));
                    product.setPrice(resultSet.getInt("price"));
                    product.setAvatar(resultSet.getString("avatar"));
                    product.setDescription(resultSet.getString("description"));
                    product.setQuantity(resultSet.getInt("quantity"));
                    product.setCategoryId(resultSet.getInt("categoryId"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    // Cập nhật thông tin một bản ghi trong bảng product
    public boolean updateProduct(Product product) throws ClassNotFoundException {
        String sql = "UPDATE product SET categoryId=?, name=?, price=?, description=?, quantity=? "
                + "WHERE id=?";

        try (Connection connection = db.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, product.getCategoryId());
            statement.setString(2, product.getName());
            statement.setInt(3, product.getPrice());
            statement.setString(4, product.getDescription());
            statement.setInt(5, product.getQuantity());
            statement.setInt(6, product.getId());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xóa một bản ghi trong bảng product dựa vào ID
    public boolean deleteProduct(int id) throws ClassNotFoundException {
        String sql = "DELETE FROM product WHERE id=?";

        try (Connection connection = db.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Tìm kiếm nhiều product dựa vào tên sản phẩm
    public List<Product> findProductByName(String tenSanPham) throws ClassNotFoundException {
        Product product = null;
        String sql = "SELECT * FROM product WHERE name LIKE ? ";

        List<Product> listProduct = new ArrayList<>();
        try (Connection connection = db.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            tenSanPham = '%' + tenSanPham + "%";
            statement.setString(1, tenSanPham);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setCategoryId(resultSet.getInt("categoryId"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getInt("price"));
                product.setDescription(resultSet.getString("description"));
                product.setQuantity(resultSet.getInt("quantity"));
                listProduct.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listProduct;
    }
}
