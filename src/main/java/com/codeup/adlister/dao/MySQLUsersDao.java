package com.codeup.adlister.dao;
import com.codeup.adlister.Config;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection;

//    Constructor that establishes a connection to the MySQL database
    public MySQLUsersDao(Config config){
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error establishing connection: Users: ", e);
        }
    }

//    Allows finding one user by username
    @Override
    public User findByUsername(String username) {
//        Create a prepared statement that takes in a search query
        try {
            String sqlQuery = "SELECT * FROM users WHERE username = ?";
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            ps.setString(1, username);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            if (rs.next()){
                return buildUserFromQuery(rs);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Could not find by username exception: ", e);
        }
    }

//    long id, String username, String email, String password
    private User buildUserFromQuery(ResultSet rs) throws SQLException{
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password"));
    }

//    Allows creation of user and adding them to database
    @Override
    public Long insert(User user) {
        String sqlQuery = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sqlQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("User could not be added to database: ", e);
        }
    }
}
