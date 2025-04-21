/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import DatabaseConenctor.Appointment;
import DatabaseConenctor.MedicalHistory;
import DatabaseConenctor.MedicalStaff;
import DatabaseConenctor.StaffAccount;
import DatabaseConenctor.Student;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.swing.JPanel;

/**
 *
 * @author netha
 */
public class MainFrame extends javax.swing.JFrame {

    private Map<String, Student> students = new HashMap<>();

    public Map<String, Student> getStudents() {
        
        return students;
    }
    
    /**
     * @return the entityManager
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * @return the entityManagerFactory
     */
    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
    
    @PersistenceContext
    private EntityManager entityManager;
    @PersistenceContext
    private EntityManagerFactory entityManagerFactory;
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("School_ClinicPU");
        this.entityManager = this.entityManagerFactory.createEntityManager();
        
        Thread thread = new Thread(() -> {
            fetchStudents(); // calling the method inside the thread
        });
        thread.start();
        
        initComponents();
    }
    
    public List<Student> fetchStudents() {
        List<Student> list = new ArrayList<>();
        TypedQuery<Student> query = this.entityManager.createNamedQuery("Student.findAll", Student.class);
        
        for (Student student : query.getResultList()) {
            this.entityManager.refresh(student);
            list.add(student);
        }
        
        return list;
    }
    
    public List<MedicalStaff> fetchStaffs() {
        List<MedicalStaff> list = new ArrayList<>();
        TypedQuery<MedicalStaff> query = this.entityManager.createNamedQuery("MedicalStaff.findAll", MedicalStaff.class);
        
        for (MedicalStaff staff : query.getResultList()) {
            this.entityManager.refresh(staff);
            list.add(staff);
        }
        
        return list;
    }
    
    public List<StaffAccount> fetchStaffAccounts() {
        List<StaffAccount> list = new ArrayList<>();
        
        TypedQuery<StaffAccount> query = this.entityManager.createNamedQuery("StaffAccount.findAll", StaffAccount.class);
        for (StaffAccount staff : query.getResultList()) {
            this.entityManager.refresh(staff);
            list.add(staff);
        }
        
        return list;
    }
    
    public MedicalHistory fetchMedicalHistory(String studentID) {
        try {        
            TypedQuery<MedicalHistory> query = this.entityManager.createQuery(
                "SELECT h FROM MedicalHistory h " +
                "WHERE h.studentID.studentID = :studentID",
                MedicalHistory.class
            );

            query.setParameter("studentID", studentID);
            return query.getSingleResult();
        } catch (Exception e) {
            return new MedicalHistory();
        }
    }
    
    public List<Appointment> fetchAppointments() {
        List<Appointment> list = Collections.synchronizedList(new ArrayList<>());
        String[] statuses = {"pending", "accepted", "rescheduled", "declined"};
        List<Thread> threads = new ArrayList<>();

        for (String status : statuses) {
            Thread t = new Thread(() -> {
                TypedQuery<Appointment> query = this.entityManager.createNamedQuery("Appointment.findByStatus", Appointment.class);
                query.setParameter("status", status);
                for (Appointment appointment : query.getResultList()) {
//                    this.entityManager.refresh(appointment);
                    list.add(appointment);
                }
            });
            threads.add(t);
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        
        return list;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        setSize(new java.awt.Dimension(1024, 640));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void showPanel(JPanel panelToShow) {
        for (Component panel : this.getContentPane().getComponents()) {

            if (panel instanceof JPanel) {
                if (panel == panelToShow) {
                    panel.setVisible(true);
                } else {
                    this.remove(panel);
                }
            }
            
            this.revalidate();
            this.repaint();
        }   
    }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
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
                new MainFrame().fetchMedicalHistory("2022-3985-A");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
