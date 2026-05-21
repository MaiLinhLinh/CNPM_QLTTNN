package qlttnn.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
    protected static Connection con;

   public DAO(){
       if (con == null){
           String url = "jdbc:sqlserver://localhost:1433;databaseName=QLTTNN;encrypt=true;trustServerCertificate=true;";
           String dbClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
           try{
               Class.forName(dbClass);
               con = DriverManager.getConnection(url, "sa", "123");
               System.out.println("Kết nối database thành công!");
           }catch(Exception e){
               System.out.println("Kết nối database thất bại!");
               e.printStackTrace();
           }
       }
   }
   public static void main(String[] args){
       new DAO();
   }

}
