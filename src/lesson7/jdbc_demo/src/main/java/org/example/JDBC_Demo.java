package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC_Demo {
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/";
    private static final String DB = "app_43";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "qwerty007";

    public static void LoadDriver() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Load driver error: " + DRIVER);
        }
    }

    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL + DB, USERNAME, PASSWORD);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Create connection fail!");
        }
    }

    public static List<User> getAllUsers() {
        String query = "SELECT * FROM t_user";
        try (Connection connection = getConnection()) {
            if (connection == null) {
                throw new SQLException("Connect fail");
            }
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            List<User> result = new ArrayList<User>();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                result.add(new User(id, name, email, password));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException("Get all users fail!");
        }

    }

    ;

    public static User create(User user) {
        String query = "INSERT INTO t_user (name, email, password) VALUES (?, ?, ?)";
        //? is f sting where jdbc put values
        try (Connection connection = getConnection()) {
            if (connection == null) {
                throw new SQLException("Connect fail");
            }
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            //Statement.RETURN_GENERATED_KEYS return generated value
            // prepared statement can be edit for our needs
            // exicute faster that statement, while we sent only data
            // will be adding data
            // sql injection in values instead of ?, will be sql query, and this query will be executed
            // prepared statement won't allow that to happen
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            int affectedRows = statement.executeUpdate();// when we update bd
            if (affectedRows == 0) {
                throw new SQLException("Create user fail!");
            }

            ResultSet result = statement.getGeneratedKeys();
            if (!result.next()) {
                throw new SQLException("Get new user id fail!");
            } else {
                Long id = result.getLong(1);
                user.setId(id);
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static User update(User user) throws SQLException {
        String query = "UPDATE t_user SET name = ?, email = ?, password = ? WHERE id = ?";

        try (Connection connection = getConnection()) {
            if (connection == null) {
                throw new RuntimeException("Connect fail");
            }
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setLong(4, user.getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("User with id " + user.getId() + " not exist!");
            }
            if (affectedRows > 1) {
                throw new SQLException("Error! Updated " + affectedRows + "users. Duplicate key in DB");
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException("Update user fail!");
        }
    }

    public static User findById(Long id) {
        String query = "SELECT * FROM t_user WHERE id = ?";

        try (Connection connection = getConnection()) {
            if (connection == null) {
                throw new SQLException("Connection fail");
            }
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                return new User(id, name, email, password);

            }else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public static User save(User user) throws SQLException {
        if (user.getId() == null) {
            return update(user);

        }else {
            return create(user);
        }
    }
}