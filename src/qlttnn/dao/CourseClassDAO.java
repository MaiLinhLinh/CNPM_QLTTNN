package qlttnn.dao;

import java.awt.image.ImageProducer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.sun.source.tree.TryTree;
import qlttnn.model.*;

public class CourseClassDAO extends DAO {


    public CourseClassDAO() {
        super();
    }

    public ArrayList<CourseClass> getCourseClassList(Level l) {
        ArrayList<CourseClass> list = new ArrayList<>();
        String sql = "SELECT cc.id AS ccId, cc.className, cc.maxStudents, cc.startDate, " +
                "b.id AS bId, b.branchName, b.address, " +
                "s.id AS sId, s.skill, s.date, " +
                "sh.id AS shId, sh.shiftName, sh.startTime, sh.endTime, " +
                "cr.id AS crId, cr.capacity, cr.roomName " +
                "FROM tblCourseClass cc " +
                "LEFT JOIN tblRegisteredClass rc on rc.courseClassId = cc.id "+
                "JOIN tblBranch b ON cc.branchId = b.id " +
                "JOIN tblSession s ON cc.id = s.courseClassId " +
                "JOIN tblShift sh ON s.shiftId = sh.id " +
                "JOIN tblClassRoom cr ON s.classRoomId = cr.id " +
                "WHERE cc.levelId = ? and cc.startDate >= CAST(GETDATE() AS date) " +
                "GROUP BY cc.id, cc.className, cc.maxStudents, cc.startDate, " +
                "b.id, b.branchName, b.address, " +
                "s.id, s.skill, s.date, " +
                "sh.id, sh.shiftName, sh.startTime, sh.endTime, " +
                "cr.id, cr.capacity, cr.roomName " +
                "HAVING COUNT(DISTINCT rc.id) < cc.maxStudents " +
                "ORDER BY cc.startDate DESC, s.date, sh.startTime";

        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, l.getId());
            ResultSet resultSet = pstm.executeQuery();

            CourseClass currentClass = null;

            while (resultSet.next()) {
                int classId = resultSet.getInt("ccId");

                // Tạo class mới nếu khác class trước
                if (currentClass == null || currentClass.getId() != classId) {
                    Branch branch = new Branch(
                            resultSet.getInt("bId"),
                            resultSet.getString("branchName"),
                            resultSet.getString("address")
                    );

                    currentClass = new CourseClass(
                            classId,
                            resultSet.getString("className"),
                            resultSet.getInt("maxStudents"),
                            resultSet.getDate("startDate").toLocalDate(),
                            l,
                            branch,
                            new ArrayList<>()
                    );
                    list.add(currentClass);
                }

                // Tạo session mới nếu có
                int sessionId = resultSet.getInt("sId");
                if (!resultSet.wasNull()) {
                    Branch branch = currentClass.getBranch();

                    ClassRoom classRoom = new ClassRoom(
                            resultSet.getInt("crId"),
                            resultSet.getInt("capacity"),
                            resultSet.getString("roomName"),
                            branch
                    );

                    Shift shift = new Shift(
                            resultSet.getInt("shId"),
                            resultSet.getString("shiftName"),
                            resultSet.getTime("startTime").toLocalTime(),
                            resultSet.getTime("endTime").toLocalTime()
                    );

                    Session currentSession = new Session(
                            sessionId,
                            resultSet.getString("skill"),
                            resultSet.getDate("date").toLocalDate(),
                            shift,
                            classRoom
                    );

                    currentClass.getSessions().add(currentSession);

                }
            }
            pstm.close();
            resultSet.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (CourseClass courseClass : list) {
            courseClass.updateScheduleInfo();
        }
        return list;
    }





    public String findConflictClass(CourseClass currentCourseClass, Student student) {
        String sql =
                "SELECT session1.conflictClassName " +
                        "FROM ( " +
                        "    SELECT " +
                        "        cc.id AS conflictClassId, " +
                        "        cc.className AS conflictClassName, " +
                        "        s.date AS sessionDate, " +
                        "        s.shiftId AS shiftId " +
                        "    FROM tblStudent st " +
                        "    JOIN tblRegistering r ON st.id = r.studentId " +
                        "    JOIN tblRegisteredClass rc ON rc.registeringId = r.id " +
                        "    JOIN tblCourseClass cc ON rc.courseClassId = cc.id " +
                        "    JOIN tblSession s ON s.courseClassId = cc.id " +
                        "    WHERE st.id = ? " +

                        ") AS session1 " +
                        "JOIN ( " +
                        "    SELECT " +
                        "        cc.id AS currentClassId, " +
                        "        s.date AS sessionDate, " +
                        "        s.shiftId AS shiftId " +
                        "    FROM tblCourseClass cc " +
                        "    JOIN tblSession s ON cc.id = s.courseClassId " +
                        "    WHERE cc.id = ? " +
                        ") AS session2 " +
                        "ON session1.sessionDate = session2.sessionDate " +
                        "AND session1.shiftId = session2.shiftId";

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, student.getId());
            pstmt.setInt(2, currentCourseClass.getId());

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getString("conflictClassName");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }





}
