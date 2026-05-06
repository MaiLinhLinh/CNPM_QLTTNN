package qlttnn.dao;

import qlttnn.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    private DBContext dbContext;

    public UserDAO() {
        dbContext = new DBContext();
    }

    public boolean checkLogin(User u) {
        String sql = "SELECT * FROM tblUser WHERE username = ? AND password = ?";
        try (Connection conn = dbContext.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, u.getUsername());
            pstmt.setString(2, u.getPassword());

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    u.setFullName(rs.getString("fullName"));
                    u.setDateOfBirth(rs.getDate("dateOfBirth"));
                    u.setAddress(rs.getString("address"));
                    u.setRole(rs.getString("role"));
                    u.setPhone(rs.getString("phone"));
                    return true;
                }
            }
        } catch (Exception e) {
            System.err.println("Error during login check: " + e.getMessage());
        }
        return false;
    }
}
