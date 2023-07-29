package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.AccountApi;
import config.db;

public class AccountApiDAO {

    // Thêm một bản ghi mới vào bảng account_api
    public boolean addAccountApi(AccountApi accountApi) throws ClassNotFoundException {
        String sql = "INSERT INTO account_api (id_company, account, password, switchboard, domain, status, created_at, updated_at) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = db.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, accountApi.getCompanyId());
            statement.setString(2, accountApi.getAccount());
            statement.setString(3, accountApi.getPassword());
            statement.setString(4, accountApi.getSwitchboard());
            statement.setString(5, accountApi.getDomain());
            statement.setInt(6, accountApi.getStatus());
            statement.setTimestamp(7, accountApi.getCreatedAt());
            statement.setTimestamp(8, accountApi.getUpdatedAt());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Lấy danh sách tất cả các bản ghi trong bảng account_api
    public List<AccountApi> getAllAccountApis() throws ClassNotFoundException {
        List<AccountApi> accountApis = new ArrayList<>();
        String sql = "SELECT * FROM account_api";

        try (Connection connection = db.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                AccountApi accountApi = new AccountApi();
                accountApi.setId(resultSet.getInt("id"));
                accountApi.setCompanyId(resultSet.getInt("id_company"));
                accountApi.setAccount(resultSet.getString("account"));
                accountApi.setPassword(resultSet.getString("password"));
                accountApi.setSwitchboard(resultSet.getString("switchboard"));
                accountApi.setDomain(resultSet.getString("domain"));
                accountApi.setStatus(resultSet.getInt("status"));
                accountApi.setCreatedAt(resultSet.getTimestamp("created_at"));
                accountApi.setUpdatedAt(resultSet.getTimestamp("updated_at"));
                accountApis.add(accountApi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accountApis;
    }

    // Cập nhật thông tin một bản ghi trong bảng account_api
    public boolean updateAccountApi(AccountApi accountApi) {
        String sql = "UPDATE account_api SET id_company=?, account=?, password=?, switchboard=?, domain=?, status=?, updated_at=? "
                + "WHERE id=?";

        try (Connection connection = db.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, accountApi.getCompanyId());
            statement.setString(2, accountApi.getAccount());
            statement.setString(3, accountApi.getPassword());
            statement.setString(4, accountApi.getSwitchboard());
            statement.setString(5, accountApi.getDomain());
            statement.setInt(6, accountApi.getStatus());
            statement.setTimestamp(7, accountApi.getUpdatedAt());
            statement.setInt(8, accountApi.getId());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xóa một bản ghi trong bảng account_api dựa vào ID
    public boolean deleteAccountApi(int id) {
        String sql = "DELETE FROM account_api WHERE id=?";

        try (Connection connection = db.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
