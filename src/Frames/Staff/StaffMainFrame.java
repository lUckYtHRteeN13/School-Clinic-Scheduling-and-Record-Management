/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Frames.Staff;

import DatabaseConenctor.MedicalStaff;
import DatabaseConenctor.StaffAccount;
import Frames.MainFrame;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.swing.JPanel;

/**
 *
 * @author netha
 */
public class StaffMainFrame extends MainFrame{

    /**
     * @return the staffAcc
     */
    public MedicalStaff getMedicalStaff() {
        return staffAcc;
    }

    /**
     * @param staffAcc the staffAcc to set
     */
    public void setMedicalStaff(MedicalStaff staffAcc) {
        this.staffAcc = staffAcc;
    }
    
    private MedicalStaff staffAcc;
    public LogInPanel logIn;
    
    public StaffMainFrame() {
        this.logIn = new LogInPanel(this);
        this.staffAcc = null;
        this.initComponents();
    }
    
    private void initComponents() {
        this.add(logIn);
        logIn.setBounds(0, 0, this.getWidth(), this.getHeight());
    }
    
    public void switchPanel(JPanel from, JPanel to) {
        this.remove(from);
        
        this.add(to);
        to.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.revalidate();
        this.repaint();
        to.setVisible(true);
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                System.out.println(info.getName());
            }
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows Classic".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                new StaffMainFrame().setVisible(true);
            }
        });
    }    
}
