package qlttnn.dao;

import qlttnn.model.Level;
import qlttnn.model.Program;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LevelDAO extends DAO {

    public LevelDAO() {
        super();
    }

    public ArrayList<Level> getLevelList(Program p) {
        ArrayList<Level> list = new ArrayList<>();
        String sql = "SELECT * from tblLevel where programId = ?";

        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, p.getId());
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                Level level = new Level(
                        resultSet.getInt("id"),
                        resultSet.getString("levelName"),
                        resultSet.getDouble("entryLevel"),
                        resultSet.getDouble("targetLevel"),
                        resultSet.getDouble("payRate"),
                        resultSet.getInt("totalSessions"),
                        resultSet.getDouble("tuition"),
                        p
                );
                list.add(level);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
