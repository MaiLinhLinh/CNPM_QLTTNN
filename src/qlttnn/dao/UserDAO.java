package qlttnn.dao;

import qlttnn.model.CourseClass;
import qlttnn.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class UserDAO extends DAO {


    public UserDAO() {
        super();
    }

    public boolean checkLogin(User u) {
        String sql = "SELECT * FROM tblUser WHERE username = ? AND password = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, u.getUsername());
            pstmt.setString(2, u.getPassword());

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setFullName(rs.getString("fullName"));
                u.setDateOfBirth(rs.getDate("dateOfBirth"));
                u.setAddress(rs.getString("address"));
                u.setRole(rs.getString("role"));
                u.setPhone(rs.getString("phone"));
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public Map<Integer, User> getTeacherForSessions(CourseClass courseClass) {
        Map<Integer, User> teacherMap = new HashMap<>();

        if (courseClass == null || courseClass.getSessions() == null || courseClass.getSessions().isEmpty()) {
            return teacherMap;
        }

        String sql = "SELECT s.id AS sessionId, " +
                "u.id, u.fullName " +
                "FROM tblSession s " +
                "JOIN tblRegisteredSession rs ON s.id = rs.sessionId " +
                "JOIN tblAssignedSession a ON rs.id = a.registeredSessionId " +
                "JOIN tblTeachingRegistration tr ON rs.teachingRegistrationId = tr.id " +
                "JOIN tblUser u ON tr.userId = u.id " +
                "WHERE s.courseClassId = ? " +
                "ORDER BY s.date";

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, courseClass.getId());

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User teacher = new User();
                teacher.setId(rs.getInt("id"));
                teacher.setFullName(rs.getString("fullName"));

                int sessionId = rs.getInt("sessionId");
                teacherMap.put(sessionId, teacher);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return teacherMap;
    }






}
