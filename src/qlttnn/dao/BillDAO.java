package qlttnn.dao;

import qlttnn.model.Bill;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
public class BillDAO extends DAO{

    public BillDAO() {
        super();
    }

    public boolean createBill(Bill b) {
        String sql = "INSERT INTO tblBill (createdAt, payedAmount, paymentType, registeringId) VALUES (?, ?, ?, ?)";
        try{
             PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setTimestamp(1, Timestamp.valueOf(b.getCreatedAt()));
            pstmt.setDouble(2, b.getPayedAmount());
            pstmt.setString(3, b.getPaymentType());
            pstmt.setInt(4, b.getRegistering().getId());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
