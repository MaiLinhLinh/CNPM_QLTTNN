/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package qlttnn;

import qlttnn.view.LoginFrm;



/**
 *
 * @author ASUS
 */
public class QLTTNN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Hiển thị giao diện đăng nhập
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e){


        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new LoginFrm().setVisible(true));
    }
    
}
