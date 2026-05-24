package qlttnn.dao;

import qlttnn.model.Bill;
import qlttnn.model.RegisteredClass;
import qlttnn.model.Registering;

import java.sql.*;

public class RegisteringDAO extends DAO {

    public RegisteringDAO() {
        super();
    }

    public boolean addRegisteringAndBill(Registering registering, Bill bill) {

        String sql = "Insert into tblRegistering (registeringDate, saleOff, userId, studentId) values(?, ?, ?, ?)";

        try {
            con.setAutoCommit(false); // Bắt đầu transaction


            // 1. Insert Registering
            PreparedStatement pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstm.setDate(1, Date.valueOf(registering.getRegisteringDate()));
            pstm.setDouble(2, registering.getSaleOff());
            pstm.setInt(3, registering.getUser().getId());
            pstm.setInt(4, registering.getStudent().getId());
            pstm.executeUpdate();
            ResultSet rsRegistering = pstm.getGeneratedKeys();
            int registeringId = 0;
            if (rsRegistering.next()) {
                registeringId = rsRegistering.getInt(1);
                registering.setId(registeringId);
            }else {
                con.rollback();
                return false;
            }

            String sqlRC = "INSERT INTO tblRegisteredClass (tuition, registeringId, courseClassId) VALUES (?, ?, ?)";

            // 2. Insert tất cả RegisteredClass
            for (RegisteredClass rc : registering.getRegisteredClasses()) {
                PreparedStatement pstmRC = con.prepareStatement(sqlRC);
                pstmRC.setDouble(1, rc.getTuition());
                pstmRC.setInt(2, registeringId);
                pstmRC.setInt(3, rc.getCourseClass().getId());

                pstmRC.executeUpdate();
                pstmRC.close();
            }
            rsRegistering.close();
            pstm.close();
            BillDAO billDAO = new BillDAO(con);
            boolean billCreated = billDAO.createBill(bill);
            if (!billCreated) {
                con.rollback();
                return false;
            }
            con.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                con.setAutoCommit(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }



    public boolean addRegistering(Registering registering) {

        String sql = "Insert into tblRegistering (registeringDate, saleOff, userId, studentId) values(?, ?, ?, ?)";

        try {
            con.setAutoCommit(false); // Bắt đầu transaction


            // 1. Insert Registering
            PreparedStatement pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstm.setDate(1, Date.valueOf(registering.getRegisteringDate()));
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

            String sqlRC = "INSERT INTO tblRegisteredClass (tuition, registeringId, courseClassId) VALUES (?, ?, ?)";

            // 2. Insert tất cả RegisteredClass
            for (RegisteredClass rc : registering.getRegisteredClasses()) {
                PreparedStatement pstmRC = con.prepareStatement(sqlRC);
                pstmRC.setDouble(1, rc.getTuition());
                pstmRC.setInt(2, registeringId);
                pstmRC.setInt(3, rc.getCourseClass().getId());

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
                con.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                con.setAutoCommit(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }




}
