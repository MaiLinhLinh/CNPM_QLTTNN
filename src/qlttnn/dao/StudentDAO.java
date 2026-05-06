package qlttnn.dao;

import qlttnn.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO {
    private DBContext dbContext;

    public StudentDAO() {
        dbContext = new DBContext();
    }

    public ArrayList<Student> searchStudent(String keySearch) {
        ArrayList<Student> list = new ArrayList<>();
        String sql = "Select * from tblStudent where fullName like ? or idCard like ?";
        try (Connection connection = dbContext.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)
        ) {
            pstmt.setString(1, "%" + keySearch + "%");
            pstmt.setString(2, "%" + keySearch + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    java.sql.Date sqlDate = rs.getDate("dateOfBirth");
                    java.time.LocalDate localDate = (sqlDate != null) ? sqlDate.toLocalDate() : null;
                    Student s = new Student(
                            rs.getInt("id"),
                            rs.getString("fullName"),
                            rs.getString("idCard"),
                            rs.getString("phone"),
                            localDate,
                            rs.getString("email"),
                            rs.getString("address")
                    );
                    list.add(s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean addStudent(Student s) {
        String sql = "insert into tblStudent (fullName, idCard, phone, dateOfBirth, email, address) values (?, ?, ?, ?, ?, ?)";
        try (Connection conn = dbContext.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setString(1, s.getFullName());
            pstmt.setString(2, s.getIdCard());
            pstmt.setString(3, s.getPhone());

            // Chuyen doi localdate sang java.sql.date de luu vao database
            if (s.getDateOfBirth() != null) {
                pstmt.setDate(4, java.sql.Date.valueOf(s.getDateOfBirth()));
            } else {
                pstmt.setNull(4, java.sql.Types.DATE);
            }

            pstmt.setString(5, s.getEmail());
            pstmt.setString(6, s.getAddress());
            // executeUpdate trả về số hàng bị tác động (ở đây là 1 nếu thành công)
            int rowAffected = pstmt.executeUpdate();
            return rowAffected > 0;
        } catch (Exception e) {
            // In lỗi chi tiết (ví dụ: trùng idCard sẽ báo lỗi tại đây)
            System.err.println("Lỗi khi thêm sinh viên: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
