package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }
    public void createUsersTable() {
        String sql =
                "CREATE TABLE IF NOT EXISTS  uzerTable(" +
                        "id SERIAL PRIMARY KEY NOT NULL," +
                        "last_name VARCHAR(50) NOT NULL," +
                        "name VARCHAR(50), " +
                        "age INTEGER )";
        try (Connection conn = Util.connection();
             Statement statement = conn.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("таблица тузулду");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void dropUsersTable() {
        String sql = "DROP TABLE  uzerTable";
        try (Connection connect = Util.connection();
             Statement statement = connect.createStatement()) {
            System.out.println("Tablise ydalenie jasaldy");
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "Insert into uzerTable(name,last_name,age) values(?,?,?)";
        try (
                Connection connection = Util.connection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setInt(3, age);
            statement.executeUpdate();
            System.out.println("Successfully added " + name);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void removeUserById(long id) {
        String sql = "DELETE FROM uzerTable WHERE id =?";
        try (Connection connec = Util.connection();
             PreparedStatement statement = connec.prepareStatement(sql)) {
            statement.setLong(1, (long) id);
            System.out.println("id menen oshutyy tuura" + id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM  uzerTable";
        try (Connection connect = Util.connection();
             Statement statement = connect.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getString("name"),
                        resultSet.getString("last_name"),
                        resultSet.getByte("age")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    public void cleanUsersTable() {
        String sql = "TRUNCATE  uzerTable";
        try (Connection connect = Util.connection();
             Statement statement = connect.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("tazalany boldy");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
