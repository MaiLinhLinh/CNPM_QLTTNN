package qlttnn.dao;


import qlttnn.model.Program;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProgramDAO extends DAO {

    public ProgramDAO() {
        super();
    }

    public ArrayList<Program> getProgramList() {
        ArrayList<Program> list = new ArrayList<>();
        String sql = "SELECT * FROM tblProgram";

        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Program program = new Program(
                        rs.getInt("id"),
                        rs.getString("programName"),
                        rs.getString("description")
                );
                list.add(program);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
