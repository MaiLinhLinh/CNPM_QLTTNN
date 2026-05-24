package qlttnn.dao;

import qlttnn.model.Student;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAO extends DAO {

    public StudentDAO() {
        super();
    }

    public ArrayList<Student> searchStudent(String keySearch) {
        ArrayList<Student> list = new ArrayList<>();
        String sql = "Select * from tblStudent where fullName like ? or idCard like ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, "%" + keySearch + "%");
            pstmt.setString(2, "%" + keySearch + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                java.sql.Date sqlDate = rs.getDate("dateOfBirth");
                java.time.LocalDate localDate = sqlDate.toLocalDate();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public boolean addStudent(Student s) {
        String sql = "insert into tblStudent (fullName, idCard, phone, dateOfBirth, email, address) values (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, s.getFullName());
            pstmt.setString(2, s.getIdCard());
            pstmt.setString(3, s.getPhone());
            pstmt.setDate(4, java.sql.Date.valueOf(s.getDateOfBirth()));
            pstmt.setString(5, s.getEmail());
            pstmt.setString(6, s.getAddress());


            int rowAffected = pstmt.executeUpdate();
            return rowAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // ham kiem tra cccd cua student da ton tai chua khi them student moi
    public boolean isIdCardExisted(String idCard){
        String sql = "select * from tblStudent where idCard = ?";
        try{
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, idCard);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }


}







