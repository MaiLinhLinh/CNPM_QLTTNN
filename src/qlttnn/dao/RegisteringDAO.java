package qlttnn.dao;

import qlttnn.model.RegisteredClass;
import qlttnn.model.Registering;

import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RegisteringDAO extends DAO {

    public RegisteringDAO() {
        super();
    }

    public boolean addRegistering(Registering registering) {

        String sql = "Insert into tblRegistering (registeringDate, saleOff, userId, studentId) values(?, ?, ?, ?)";

        try {
            con.setAutoCommit(false); // Bắt đầu transaction


            // 1. Insert Registering
            PreparedStatement pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstm.setTimestamp(1, Timestamp.valueOf(registering.getRegisteringDate()));
            pstm.setDouble(2, registering.getSaleOff());
            pstm.setInt(3, registering.getUser().getId());
            pstm.setInt(4, registering.getStudent().getId());
            pstm.executeUpdate();
            ResultSet rsRegistering = pstm.getGeneratedKeys();
            int registeringId = 0;
            if (rsRegistering.next()) {
                registeringId = rsRegistering.getInt(1);
                registering.setId(registeringId);
            }

            String sqlRC = "INSERT INTO tblRegisteredClass (tuition, saleOff, registeringId, courseClassId) VALUES (?, ?, ?, ?)";

            // 2. Insert tất cả RegisteredClass
            for (RegisteredClass rc : registering.getRegisteredClasses()) {
                PreparedStatement pstmRC = con.prepareStatement(sqlRC);
                pstmRC.setDouble(1, rc.getTuition());
                pstmRC.setDouble(2, rc.getSaleOff());
                pstmRC.setInt(3, registeringId);
                pstmRC.setInt(4, rc.getCourseClass().getId());

                pstmRC.executeUpdate();
                pstmRC.close();
            }
            rsRegistering.close();
            pstm.close();
            con.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            try {
                con.rollback(); // Rollback nếu có lỗi
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                con.setAutoCommit(true); // Reset auto-commit
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
