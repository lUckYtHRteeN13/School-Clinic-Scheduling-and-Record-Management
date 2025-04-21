/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frames.Staff;

import DatabaseConenctor.Appointment;
import DatabaseConenctor.MedicalStaff;
import DatabaseConenctor.StaffAccount;
import DatabaseConenctor.Student;
import Frames.AppointmentDialog;
import ProjectUtilities.DataPollerThread;
import ProjectUtilities.Utils;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.AbstractButton;
import javax.swing.AbstractCellEditor;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author netha
 */
public class MainPanel extends javax.swing.JPanel {

    @PersistenceContext
    private EntityManager entityManager;
    @PersistenceContext
    private EntityManagerFactory entityManagerFactory;
    
    private boolean isTFEmpty;
    private final StaffMainFrame parentFrame;
    
    private MedicalStaff staff;
    private final int PAGE_SIZE = 10;
    private int currentPatientPage = 0;
    private int currentAppointmentPage;
    private boolean isPatientSearchEmpty = true;
    
    private List<Student> students = new ArrayList<>();
    private Map<String, Student> studentsMap = new HashMap<>();
    private List<Student> filteredPatientsList = new ArrayList<>();
    private List<Student> filteredSummaryPatientsList = new ArrayList<>();
    private List<Appointment> appointmentsList;
    private Map<String, Appointment> appointmentMap = new HashMap<>();
    private List<Appointment> pendingAppointmentsList;
    private Appointment appointment;
    
    
    private DataPollerThread<Appointment> appointmentPoller;
    private DataPollerThread<Student> studentPoller;
    private DataPollerThread<StaffAccount> staffPoller;
    
    private DefaultTableModel doctorsTableModel;
    private DefaultTableModel patientsListTableModel;
    private DefaultTableModel pendingAppointmentTableModel;
    private DefaultTableModel appointmentTableModel;
    
    
    private final DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    
    private final DefaultTableCellRenderer indexRenderer = new DefaultTableCellRenderer() {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);
        label.setText("<html><div style='text-align:center;'>"
                + "<b>" + value.toString().split(",")[0] + "</b><br>"
                + value.toString().split(",")[1]
                + "</div></html>");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        return label;
        }
    };

    DefaultTableCellRenderer clickableRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);
                label.setText("<html><u>" + value + "</a></html>");
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setForeground(new Color(102, 102, 102));
                return label;
            }
        };


    


    /**
     * Creates new form Dashboard
     * @param parentFrame
     */
    public MainPanel(StaffMainFrame parentFrame) {
        this.parentFrame = parentFrame;
        
        this.entityManagerFactory = this.parentFrame.getEntityManagerFactory();
        this.entityManager = this.parentFrame.getEntityManager();
        this.staff = this.parentFrame.getMedicalStaff();
        
        this.centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        this.centerRenderer.setVerticalAlignment(SwingConstants.CENTER);
        
        this.startPolling();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panels = new javax.swing.ButtonGroup();
        sexButtonGroup = new javax.swing.ButtonGroup();
        statusButtonGroup = new javax.swing.ButtonGroup();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        dash = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        pendingAppointmentTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        allPatients = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        doctorsTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        allAppointment = new javax.swing.JLabel();
        patientSearchDash = new javax.swing.JTextField();
        setAppointmentBTN = new javax.swing.JButton();
        appointmentsPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        appointmentsTable = new javax.swing.JTable();
        patient = new javax.swing.JPanel();
        layeredPane2 = new javax.swing.JLayeredPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        patientsTable = new javax.swing.JTable();
        patientSearchPatient = new javax.swing.JTextField();
        prevBtn = new javax.swing.JButton();
        nextBtn = new javax.swing.JButton();
        pageNumbers = new javax.swing.JLabel();
        filterBTN = new javax.swing.JToggleButton();
        filterFrame = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        isCIT = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        isCEA = new javax.swing.JRadioButton();
        isCOE = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        isCAS = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        isMale = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        applyBTN = new javax.swing.JButton();
        clearBTN = new javax.swing.JLabel();
        allSexRadio = new javax.swing.JRadioButton();
        allStatusRadio = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        appointmentsBTN = new javax.swing.JToggleButton();
        dashBTN = new javax.swing.JToggleButton();
        patientsBTN = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JSeparator();
        logoutBTN = new javax.swing.JButton();
        FNameLabel = new javax.swing.JLabel();
        LNameLabel = new javax.swing.JLabel();

        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });
        setLayout(null);

        dash.setPreferredSize(new java.awt.Dimension(830, 606));
        dash.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DASHBOARD");
        dash.add(jLabel2);
        jLabel2.setBounds(0, 20, 830, 40);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient ID", "Name", "Course", "College", "Last Visited", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setRowHeight(35);
        jTable1.setRowSelectionAllowed(false);
        jTable1.setShowGrid(false);
        jTable1.setShowHorizontalLines(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        dash.add(jScrollPane1);
        jScrollPane1.setBounds(20, 410, 590, 180);

        pendingAppointmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient", "Colloge", "Request Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pendingAppointmentTable.setRowHeight(35);
        pendingAppointmentTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        pendingAppointmentTable.setShowGrid(false);
        pendingAppointmentTable.setShowHorizontalLines(true);
        pendingAppointmentTable.getTableHeader().setReorderingAllowed(false);
        pendingAppointmentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pendingAppointmentTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(pendingAppointmentTable);
        if (pendingAppointmentTable.getColumnModel().getColumnCount() > 0) {
            pendingAppointmentTable.getColumnModel().getColumn(0).setResizable(false);
            pendingAppointmentTable.getColumnModel().getColumn(1).setResizable(false);
            pendingAppointmentTable.getColumnModel().getColumn(2).setResizable(false);
            pendingAppointmentTable.getColumnModel().getColumn(3).setResizable(false);
        }
        this.pendingAppointmentTableModel = (DefaultTableModel) this.pendingAppointmentTable.getModel();

        this.pendingAppointmentTable.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.pendingAppointmentTable.getColumnModel().getColumn(3).setPreferredWidth(30);

        this.pendingAppointmentTable.getColumnModel().getColumn(0).setCellRenderer(indexRenderer);

        for (int i = 1; i < this.pendingAppointmentTable.getColumnCount() - 1; i++) {
            this.pendingAppointmentTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        dash.add(jScrollPane2);
        jScrollPane2.setBounds(20, 140, 590, 180);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Doctors");
        dash.add(jLabel4);
        jLabel4.setBounds(640, 110, 90, 30);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Patients");
        dash.add(jLabel5);
        jLabel5.setBounds(20, 380, 90, 20);

        allPatients.setForeground(new java.awt.Color(102, 102, 102));
        allPatients.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        allPatients.setText("<html><u>See All</></>");
        allPatients.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        allPatients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                allPatientsMouseClicked(evt);
            }
        });
        dash.add(allPatients);
        allPatients.setBounds(570, 380, 40, 30);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setToolTipText("");
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        this.doctorsTableModel = new DefaultTableModel(              new Object [][] {                },              new String [] {                  "Name", "Active"              }          );
        doctorsTable.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        doctorsTable.setModel(this.doctorsTableModel);
        doctorsTable.setAlignmentX(0.0F);
        doctorsTable.setAlignmentY(0.0F);
        doctorsTable.setRowHeight(50);
        this.doctorsTable.setColumnSelectionAllowed(true);
        this.doctorsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        this.doctorsTable.setFillsViewportHeight(true);
        this.doctorsTable.setGridColor(new java.awt.Color(204, 204, 204));
        this.doctorsTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        this.doctorsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        this.doctorsTable.setShowGrid(false);
        this.doctorsTable.setShowHorizontalLines(true);
        this.doctorsTable.getTableHeader().setResizingAllowed(false);
        this.doctorsTable.getTableHeader().setReorderingAllowed(false);
        this.doctorsTable.setEnabled(false);
        this.doctorsTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        jScrollPane3.setViewportView(doctorsTable);
        for (int i = 0; i < this.doctorsTable.getColumnCount(); i++) {
     this.doctorsTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
}

        dash.add(jScrollPane3);
        jScrollPane3.setBounds(640, 140, 170, 450);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Pending Appointments");
        dash.add(jLabel8);
        jLabel8.setBounds(20, 110, 150, 30);

        allAppointment.setForeground(new java.awt.Color(102, 102, 102));
        allAppointment.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        allAppointment.setText("<html><u>See All</></>");
        allAppointment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        allAppointment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                allAppointmentMouseClicked(evt);
            }
        });
        dash.add(allAppointment);
        allAppointment.setBounds(570, 110, 40, 30);

        patientSearchDash.setForeground(new java.awt.Color(51, 51, 51));
        patientSearchDash.setText("Search");
        patientSearchDash.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                patientSearchDashFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                patientSearchDashFocusLost(evt);
            }
        });
        patientSearchDash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientSearchDashActionPerformed(evt);
            }
        });
        dash.add(patientSearchDash);
        patientSearchDash.setBounds(150, 380, 240, 20);

        setAppointmentBTN.setText("Set Appointment");
        setAppointmentBTN.setEnabled(false);
        setAppointmentBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setAppointmentBTNActionPerformed(evt);
            }
        });
        dash.add(setAppointmentBTN);
        setAppointmentBTN.setBounds(475, 330, 130, 30);

        jLayeredPane1.add(dash);
        dash.setBounds(0, 0, 830, 610);

        appointmentsPanel.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("APPOINTMENTS");
        appointmentsPanel.add(jLabel10);
        jLabel10.setBounds(0, 20, 830, 40);

        jScrollPane6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane6.setToolTipText("");
        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane6.setViewportView(appointmentsTable);

        appointmentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient", "Course", "College", "Requested", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        appointmentsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        appointmentsTable.setFillsViewportHeight(true);
        appointmentsTable.setGridColor(new java.awt.Color(204, 204, 204));
        appointmentsTable.setRowHeight(39);
        appointmentsTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        appointmentsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        appointmentsTable.setShowGrid(false);
        appointmentsTable.setShowHorizontalLines(true);
        appointmentsTable.getTableHeader().setResizingAllowed(false);
        appointmentsTable.getTableHeader().setReorderingAllowed(false);
        appointmentsTable.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                appointmentsTableMouseMoved(evt);
            }
        });
        appointmentsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appointmentsTableMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(appointmentsTable);
        appointmentsTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (appointmentsTable.getColumnModel().getColumnCount() > 0) {
            appointmentsTable.getColumnModel().getColumn(0).setResizable(false);
            appointmentsTable.getColumnModel().getColumn(1).setResizable(false);
            appointmentsTable.getColumnModel().getColumn(2).setResizable(false);
            appointmentsTable.getColumnModel().getColumn(3).setResizable(false);
            appointmentsTable.getColumnModel().getColumn(4).setResizable(false);
        }
        this.appointmentTableModel = (DefaultTableModel) this.appointmentsTable.getModel();

        TableRowSorter<DefaultTableModel> appointmentSorter = new TableRowSorter<>(appointmentTableModel);
        this.appointmentsTable.setRowSorter(appointmentSorter);

        this.appointmentsTable.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.appointmentsTable.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.appointmentsTable.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.appointmentsTable.getColumnModel().getColumn(4).setPreferredWidth(30);

        //this.patientsTable.getColumnModel().getColumn(5).setCellRenderer(clickableRenderer);
        this.appointmentsTable.getColumnModel().getColumn(0).setCellRenderer(indexRenderer);

        for (int i = 1; i < this.appointmentsTable.getColumnCount() - 1; i++) {
            this.appointmentsTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        appointmentsPanel.add(jScrollPane6);
        jScrollPane6.setBounds(10, 130, 810, 413);

        jLayeredPane1.add(appointmentsPanel);
        appointmentsPanel.setBounds(0, 0, 830, 600);

        patient.setLayout(null);

        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PATIENTS");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(0, 20, 830, 40);

        jScrollPane4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setToolTipText("");
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane4.setWheelScrollingEnabled(false);

        patientsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient", "Course", "College", "Sex", "Last Visit", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        patientsTable.setColumnSelectionAllowed(true);
        patientsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        patientsTable.setFillsViewportHeight(true);
        patientsTable.setGridColor(new java.awt.Color(204, 204, 204));
        patientsTable.setRowHeight(39);
        patientsTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        patientsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        patientsTable.setShowGrid(false);
        patientsTable.setShowHorizontalLines(true);
        patientsTable.getTableHeader().setResizingAllowed(false);
        patientsTable.getTableHeader().setReorderingAllowed(false);
        patientsTable.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                patientsTableMouseMoved(evt);
            }
        });
        patientsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patientsTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(patientsTable);
        patientsTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (patientsTable.getColumnModel().getColumnCount() > 0) {
            patientsTable.getColumnModel().getColumn(0).setResizable(false);
            patientsTable.getColumnModel().getColumn(1).setResizable(false);
            patientsTable.getColumnModel().getColumn(2).setResizable(false);
            patientsTable.getColumnModel().getColumn(3).setResizable(false);
            patientsTable.getColumnModel().getColumn(4).setResizable(false);
            patientsTable.getColumnModel().getColumn(5).setResizable(false);
            patientsTable.getColumnModel().getColumn(5).setHeaderValue("");
        }
        this.patientsListTableModel = (DefaultTableModel) this.patientsTable.getModel();

        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(patientsListTableModel);
        this.patientsTable.setRowSorter(sorter);

        this.patientsTable.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.patientsTable.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.patientsTable.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.patientsTable.getColumnModel().getColumn(5).setPreferredWidth(30);

        this.patientsTable.getColumnModel().getColumn(5).setCellRenderer(clickableRenderer);
        this.patientsTable.getColumnModel().getColumn(0).setCellRenderer(indexRenderer);

        for (int i = 1; i < this.patientsTable.getColumnCount() - 1; i++) {
            this.patientsTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        jPanel2.add(jScrollPane4);
        jScrollPane4.setBounds(10, 130, 810, 413);

        patientSearchPatient.setForeground(new java.awt.Color(128, 128, 128));
        patientSearchPatient.setText("Search Name");
        patientSearchPatient.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        patientSearchPatient.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                patientSearchPatientFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                patientSearchPatientFocusLost(evt);
            }
        });
        patientSearchPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientSearchPatientActionPerformed(evt);
            }
        });
        patientSearchPatient.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                patientSearchPatientKeyReleased(evt);
            }
        });
        jPanel2.add(patientSearchPatient);
        patientSearchPatient.setBounds(10, 90, 240, 30);

        prevBtn.setText("<< Prev");
        prevBtn.setEnabled(false);
        prevBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevBtnActionPerformed(evt);
            }
        });
        jPanel2.add(prevBtn);
        prevBtn.setBounds(600, 550, 100, 23);

        nextBtn.setText("Next >>");
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });
        jPanel2.add(nextBtn);
        nextBtn.setBounds(710, 550, 110, 23);

        pageNumbers.setForeground(new java.awt.Color(153, 153, 153));
        pageNumbers.setText("Page 1 of 1");
        jPanel2.add(pageNumbers);
        pageNumbers.setBounds(10, 540, 80, 16);

        filterBTN.setText("Filter");
        filterBTN.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        filterBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterBTNActionPerformed(evt);
            }
        });
        jPanel2.add(filterBTN);
        filterBTN.setBounds(260, 90, 70, 30);

        layeredPane2.add(jPanel2);
        jPanel2.setBounds(0, 0, 830, 600);
        this.layeredPane2.setLayer(this.jPanel2, 0);

        filterFrame.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));
        filterFrame.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Civil Status");
        filterFrame.add(jLabel7);
        jLabel7.setBounds(30, 200, 90, 20);

        isCIT.setText("CIT");
        filterFrame.add(isCIT);
        isCIT.setBounds(240, 90, 60, 21);

        sexButtonGroup.add(jRadioButton2);
        jRadioButton2.setText("Female");
        filterFrame.add(jRadioButton2);
        jRadioButton2.setBounds(170, 160, 70, 21);

        isCEA.setText("CEA");
        filterFrame.add(isCEA);
        isCEA.setBounds(100, 90, 60, 21);

        isCOE.setText("COE");
        filterFrame.add(isCOE);
        isCOE.setBounds(170, 90, 60, 21);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("College");
        filterFrame.add(jLabel9);
        jLabel9.setBounds(30, 60, 60, 20);

        isCAS.setText("CAS");
        filterFrame.add(isCAS);
        isCAS.setBounds(30, 90, 60, 21);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Sex");
        filterFrame.add(jLabel11);
        jLabel11.setBounds(30, 130, 60, 20);

        sexButtonGroup.add(isMale);
        isMale.setText("Male");
        isMale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                isMaleMousePressed(evt);
            }
        });
        filterFrame.add(isMale);
        isMale.setBounds(100, 160, 60, 21);

        statusButtonGroup.add(jRadioButton6);
        jRadioButton6.setText("Widowed");
        filterFrame.add(jRadioButton6);
        jRadioButton6.setBounds(330, 230, 80, 21);

        statusButtonGroup.add(jRadioButton8);
        jRadioButton8.setText("Single");
        filterFrame.add(jRadioButton8);
        jRadioButton8.setBounds(100, 230, 60, 21);

        statusButtonGroup.add(jRadioButton9);
        jRadioButton9.setText("Married");
        filterFrame.add(jRadioButton9);
        jRadioButton9.setBounds(170, 230, 70, 21);

        statusButtonGroup.add(jRadioButton10);
        jRadioButton10.setText("Divorced");
        filterFrame.add(jRadioButton10);
        jRadioButton10.setBounds(250, 230, 70, 21);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel12.setText("FILTERS");
        filterFrame.add(jLabel12);
        jLabel12.setBounds(10, 10, 110, 28);

        applyBTN.setText("Apply");
        applyBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyBTNActionPerformed(evt);
            }
        });
        filterFrame.add(applyBTN);
        applyBTN.setBounds(180, 270, 75, 23);

        clearBTN.setForeground(new java.awt.Color(153, 153, 153));
        clearBTN.setText("<html><u>Reset</>");
        clearBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearBTNMouseClicked(evt);
            }
        });
        filterFrame.add(clearBTN);
        clearBTN.setBounds(390, 10, 30, 16);

        sexButtonGroup.add(allSexRadio);
        allSexRadio.setSelected(true);
        allSexRadio.setText("All");
        filterFrame.add(allSexRadio);
        allSexRadio.setBounds(30, 160, 37, 21);

        statusButtonGroup.add(allStatusRadio);
        allStatusRadio.setSelected(true);
        allStatusRadio.setText("All");
        filterFrame.add(allStatusRadio);
        allStatusRadio.setBounds(30, 230, 37, 21);

        layeredPane2.add(filterFrame);
        filterFrame.setBounds(210, 170, 430, 310);
        this.layeredPane2.setLayer(this.filterFrame, 1);
        this.filterFrame.setVisible(false);

        patient.add(layeredPane2);
        layeredPane2.setBounds(0, 0, 830, 600);

        jLayeredPane1.add(patient);
        patient.setBounds(0, 0, 830, 600);

        add(jLayeredPane1);
        jLayeredPane1.setBounds(180, 0, 830, 610);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ISAT U CLINIC");
        jLabel1.setIconTextGap(0);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(19, 23, 160, 40);

        panels.add(appointmentsBTN);
        appointmentsBTN.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        appointmentsBTN.setText("Appointments");
        appointmentsBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appointmentsBTNActionPerformed(evt);
            }
        });
        appointmentsBTN.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                appointmentsBTNPropertyChange(evt);
            }
        });
        jPanel1.add(appointmentsBTN);
        appointmentsBTN.setBounds(30, 260, 140, 30);

        panels.add(dashBTN);
        dashBTN.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        dashBTN.setSelected(true);
        dashBTN.setText("Dashboard");
        dashBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashBTNActionPerformed(evt);
            }
        });
        jPanel1.add(dashBTN);
        dashBTN.setBounds(30, 160, 140, 30);

        panels.add(patientsBTN);
        patientsBTN.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        patientsBTN.setText("Patients");
        patientsBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientsBTNActionPerformed(evt);
            }
        });
        patientsBTN.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                patientsBTNPropertyChange(evt);
            }
        });
        jPanel1.add(patientsBTN);
        patientsBTN.setBounds(30, 210, 140, 30);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(10, 550, 180, 20);

        logoutBTN.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        logoutBTN.setText("Logout");
        logoutBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBTNActionPerformed(evt);
            }
        });
        jPanel1.add(logoutBTN);
        logoutBTN.setBounds(30, 570, 140, 30);

        FNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(FNameLabel);
        FNameLabel.setBounds(20, 100, 160, 20);

        LNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(LNameLabel);
        LNameLabel.setBounds(20, 80, 160, 30);

        add(jPanel1);
        jPanel1.setBounds(-10, -10, 190, 650);
    }// </editor-fold>//GEN-END:initComponents

    private void dashBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashBTNActionPerformed
        // TODO add your handling code here:
        this.showPanel(this.dash);
    }//GEN-LAST:event_dashBTNActionPerformed

    private void appointmentsBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appointmentsBTNActionPerformed
        // TODO add your handling code here:
        this.appointmentsBTN.firePropertyChange("selected", false, true);
        this.updateAppointmentsTable();
    }//GEN-LAST:event_appointmentsBTNActionPerformed

    private void logoutBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBTNActionPerformed
        // TODO add your handling code here:
        this.entityManager.getTransaction().begin();
        TypedQuery<StaffAccount> query = this.entityManager.createNamedQuery("StaffAccount.findByStaffID", StaffAccount.class);
        query.setParameter("staffID", staff.getStaffID());
        StaffAccount staff = query.getSingleResult();
        staff.setIsActive((short) 0);
        staff.setLastLogIn(new java.util.Date());
        this.entityManager.getTransaction().commit();      
        
        this.studentPoller.stopPolling();
        this.staffPoller.stopPolling();
        this.appointmentPoller.stopPolling();
        this.parentFrame.switchPanel(this, new LogInPanel(this.parentFrame));
    }//GEN-LAST:event_logoutBTNActionPerformed

    private void patientSearchDashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientSearchDashActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientSearchDashActionPerformed

    private void allAppointmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allAppointmentMouseClicked
        this.appointmentsBTN.firePropertyChange("selected", false, true);
        this.appointmentsBTN.setSelected(true);
    }//GEN-LAST:event_allAppointmentMouseClicked

    private void allPatientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allPatientsMouseClicked
        // TODO add your handling code here:
        this.patientsBTN.firePropertyChange("selected", false, true);
        this.patientsBTN.setSelected(true);
    }//GEN-LAST:event_allPatientsMouseClicked

    private void patientSearchDashFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_patientSearchDashFocusGained
        // TODO add your handling code here:
        if (this.isTFEmpty) {
            this.patientSearchDash.setText("");
            this.patientSearchDash.setForeground(Color.BLACK);
            this.isTFEmpty = false;
        }
    }//GEN-LAST:event_patientSearchDashFocusGained

    private void patientSearchDashFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_patientSearchDashFocusLost
        // TODO add your handling code here:
        if (this.patientSearchDash.getText().isEmpty()) {
            this.patientSearchDash.setText("Search Name");
            this.patientSearchDash.setForeground(Color.GRAY);
            this.isTFEmpty = true;
        }
    }//GEN-LAST:event_patientSearchDashFocusLost

    private void patientSearchPatientFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_patientSearchPatientFocusGained
        // TODO add your handling code here:
        if (this.isPatientSearchEmpty) {
            this.isPatientSearchEmpty = false;
            this.patientSearchPatient.setText("");
            this.patientSearchPatient.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_patientSearchPatientFocusGained

    private void patientSearchPatientFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_patientSearchPatientFocusLost
        // TODO add your handling code here:
        if (this.patientSearchPatient.getText().isEmpty()) {
            this.isPatientSearchEmpty = true;
            this.patientSearchPatient.setText("Search");
            this.patientSearchPatient.setForeground(Color.GRAY);
             this.updateStudentsTable();
        }
    }//GEN-LAST:event_patientSearchPatientFocusLost

    private void patientSearchPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientSearchPatientActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_patientSearchPatientActionPerformed

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        // TODO add your handling code here:
        int totalPages = (int) Math.ceil((double) filteredPatientsList.size() / PAGE_SIZE);
        if (currentPatientPage < totalPages - 1) {
            currentPatientPage++;
            this.updateStudentsTable();
        }
    }//GEN-LAST:event_nextBtnActionPerformed

    private void patientsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientsTableMouseClicked
        // TODO add your handling code here:
        int row = this.patientsTable.rowAtPoint(evt.getPoint());
        int col = this.patientsTable.columnAtPoint(evt.getPoint());

        if (col == 5) {
            String studentID = this.patientsTable.getValueAt(row, 0).toString().split(",")[1].strip();
            Student student = this.studentsMap.get(studentID);
            
            new Thread(() -> {
                StudentRecord sr = new StudentRecord(this.parentFrame, student);
                sr.setVisible(true);
            }).start();
            
        }
    }//GEN-LAST:event_patientsTableMouseClicked

    private void patientsTableMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientsTableMouseMoved
        // TODO add your handling code here:
        int col = this.patientsTable.columnAtPoint(evt.getPoint());

        if (col == 5) {
            this.patientsTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        } else {
            this.patientsTable.setCursor(Cursor.getDefaultCursor());
        }
    }//GEN-LAST:event_patientsTableMouseMoved

    private void patientSearchPatientKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_patientSearchPatientKeyReleased
        // TODO add your handling code here:
        this.updateStudentsTable();
    }//GEN-LAST:event_patientSearchPatientKeyReleased

    private void prevBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevBtnActionPerformed
        // TODO add your handling code here:
        if (currentPatientPage > 0) {
            currentPatientPage--;
            this.updateStudentsTable();
        }
    }//GEN-LAST:event_prevBtnActionPerformed

    private void patientsBTNPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_patientsBTNPropertyChange
        // TODO add your handling code here:
        if ("selected".equals(evt.getPropertyName())) {
            this.showPanel(this.patient);
        }
    }//GEN-LAST:event_patientsBTNPropertyChange

    private void patientsBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientsBTNActionPerformed
        // TODO add your handling code here:
        this.patientsBTN.firePropertyChange("selected", false, true);
    }//GEN-LAST:event_patientsBTNActionPerformed

    private void appointmentsBTNPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_appointmentsBTNPropertyChange
        // TODO add your handling code here:
        if ("selected".equals(evt.getPropertyName())) {
            this.showPanel(this.appointmentsPanel);
        }
    }//GEN-LAST:event_appointmentsBTNPropertyChange

    private void applyBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyBTNActionPerformed
        // TODO add your handling code here:
        this.updateStudentsTable();
        this.filterFrame.setVisible(!this.filterFrame.isVisible());
    }//GEN-LAST:event_applyBTNActionPerformed

    private void filterBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterBTNActionPerformed
        // TODO add your handling code here:
        this.filterFrame.setVisible(!this.filterFrame.isVisible());
    }//GEN-LAST:event_filterBTNActionPerformed

    private void clearBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearBTNMouseClicked
        // TODO add your handling code here:
        this.isCAS.setSelected(false);
        this.isCEA.setSelected(false);
        this.isCOE.setSelected(false);
        this.isCIT.setSelected(false);
        this.sexButtonGroup.setSelected(this.allSexRadio.getModel(), true);
        this.statusButtonGroup.setSelected(this.allStatusRadio.getModel(), true);
    }//GEN-LAST:event_clearBTNMouseClicked

    private void isMaleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_isMaleMousePressed
        // TODO add your handling code here:
        if (this.isMale.isSelected()) {
            SwingUtilities.invokeLater(sexButtonGroup::clearSelection);
        }
    }//GEN-LAST:event_isMaleMousePressed

    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded
        // TODO add your handling code here:
        this.updateStudentsTable();
        this.FNameLabel.setText("%s %s.".formatted(this.staff.getStaffFName(), this.staff.getStaffMName().charAt(0)));
        this.LNameLabel.setText(this.staff.getStaffLName());
    }//GEN-LAST:event_formComponentAdded

    private void pendingAppointmentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pendingAppointmentTableMouseClicked
        // TODO add your handling code here:
        int row = this.pendingAppointmentTable.rowAtPoint(evt.getPoint());
        String studentID = this.pendingAppointmentTableModel.getValueAt(row, 0).toString().split(",")[1].strip();
        this.appointment = this.pendingAppointmentsList.stream()
                .filter(a -> a.getStudentID().getStudentID().equals(studentID))
                .findFirst()
                .orElse(null);
        if (row != -1) {
            this.setAppointmentBTN.setEnabled(true);
            
        }
    }//GEN-LAST:event_pendingAppointmentTableMouseClicked

    private void setAppointmentBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setAppointmentBTNActionPerformed
        // TODO add your handling code here:
        int row = this.pendingAppointmentTable.getSelectedRow();
        String studentID = this.pendingAppointmentTableModel.getValueAt(row, 0).toString().split(",")[1].strip();
        Appointment appointment = this.pendingAppointmentsList.stream()
                .filter(a -> a.getStudentID().getStudentID().equals(studentID))
                .findFirst()
                .orElse(null);
        AppointmentDialog dialog = new AppointmentDialog(this.parentFrame, appointment);
        dialog.setVisible(true);
    }//GEN-LAST:event_setAppointmentBTNActionPerformed

    private void appointmentsTableMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointmentsTableMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_appointmentsTableMouseMoved

    private void appointmentsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointmentsTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_appointmentsTableMouseClicked
    
    private void startPolling() {
        this.studentPoller = new DataPollerThread<>(
                this.parentFrame::fetchStudents,
                this::updateStudentMap,
                10
        );
        studentPoller.start();

        this.staffPoller = new DataPollerThread<>(
                this.parentFrame::fetchStaffAccounts,
                this::updateDoctorsList,
                3
        );
        staffPoller.start();

        this.appointmentPoller = new DataPollerThread<>(
                this.parentFrame::fetchAppointments,
                this::updateSummaryAppointments,
                5
        );
        appointmentPoller.start();

       
    }
    
    private void updateStudentMap(List<Student> students) {
        for(Student student : students) {
            this.studentsMap.put(student.getStudentID(), student);
        }
    }
    
    private void updateDoctorsList(List<StaffAccount> staffs) {
        this.doctorsTableModel.setRowCount(0);
        staffs.sort(Comparator.comparing(StaffAccount::getIsActive).reversed().thenComparing(StaffAccount::getLastLogIn, Comparator.nullsLast(Comparator.reverseOrder())));
        for(StaffAccount staff : staffs) {
            if (!staff.getStaffID().equals(this.staff)) {
                String info = "<html><div style='text-align:center;'><b>%s %s. %s</div></>".formatted(
                    staff.getStaffID().getStaffFName(),
                    staff.getStaffID().getStaffMName().charAt(0),
                    staff.getStaffID().getStaffLName());
                String active = "<html><div style='text-align:center; color:green'>&#9679;</div>Online</html>";
                String status = Utils.getTimeAgo(staff.getLastLogIn());
                String offline = "<html><div style='text-align:center; color:" + 
                        (!status.equalsIgnoreCase("no activity") ? "red" : "gray") + ";'>%s</div></>".formatted(status);
                this.doctorsTableModel.addRow(new Object[]{
                    info,
                    staff.getIsActive() == 1 ?  active : offline
                    });
            }
        }
    }
    
    private void updateAppointmentsTable() {
        this.appointmentTableModel.setRowCount(0);
        List<Appointment> appointments = this.appointmentsList;
        appointments.sort(Comparator.comparing(Appointment::getCreateDate).reversed().thenComparing(Appointment::getStatus, Comparator.nullsLast(Comparator.reverseOrder())));
        for(Appointment appointment : appointments) {
            Student student = this.studentsMap.get(appointment.getStudentID().getStudentID());
            if (!staff.getStaffID().equals(this.staff)) {
                String info = "%s %s. %s, %s".formatted(
                    student.getStudentFName(),
                    student.getStudentMName().charAt(0),
                    student.getStudentLName(),
                    student.getStudentID());
                
                LocalDate createdDate = appointment.getCreateDate()
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
                
                String status = appointment.getStatus();
                
                switch (status) {
                    case "pending":
                        status = "<html><div style='text-align:center; color:blue;'>%s</div></>".formatted(status);
                        break;
                    case "accepted":
                        status = "<html><div style='text-align:center; color:green;'>%s</div></>".formatted(status);
                        break;
                    case "rescheduled":
                        status = "<html><div style='text-align:center; color:yellow;'>%s</div></>".formatted(status);
                        break;
                    case "declined":
                        status = "<html><div style='text-align:center; color:red;'>%s</div></>".formatted(status);
                        break;
                }
                this.appointmentTableModel.addRow(new Object[]{
                    info,
                    student.getStudentCourse(),
                    student.getStudentCollege(),
                    createdDate,
                    status
                    });
            }
        }
    }
    
    private void updateSummaryAppointments(List<Appointment> appointments) {
        this.appointmentsList = appointments;
        
        this.pendingAppointmentTableModel.setRowCount(0);
        List<Appointment> pendingAppointments = this.appointmentsList.stream()
            .filter(s -> s.getStatus().equalsIgnoreCase("pending"))
            .collect(Collectors.toList());

        this.pendingAppointmentsList = pendingAppointments;
        pendingAppointments.sort(Comparator.comparing(Appointment::getCreateDate, Comparator.nullsLast(Comparator.reverseOrder())));
        for (Appointment pendingAppointment : pendingAppointments) {
            
            Student student = this.studentsMap.get(pendingAppointment.getStudentID().getStudentID());
            String info = "%s %s. %s, %s".formatted(
                    student.getStudentFName(),
                    student.getStudentMName().charAt(0),
                    student.getStudentLName(),
                    student.getStudentID());
            
            LocalDate createdDate = pendingAppointment.getCreateDate()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();            
            
            this.pendingAppointmentTableModel.addRow(new Object[] {
                info,
                student.getStudentCollege(),
                createdDate.format(Utils.secondDefaultDateFormat),
                "<html><div style='text-align:center;color:blue'>" + pendingAppointment.getStatus().replaceFirst("p", "P") + "</div></html>",
                "Set Appointment"
        });
        }
    }
    
    private void updateStudentsTable() {
        this.students = new ArrayList<>(this.studentsMap.values());
        this.applyFilter();
        patientsListTableModel.setNumRows(0);
        int dataSize = filteredPatientsList.size();
        int start = currentPatientPage * PAGE_SIZE;
        int end = Math.min(start + PAGE_SIZE, dataSize);
        for (int i = start; i < end; i++) {
            Student student = filteredPatientsList.get(i);
            
            String info = "%s %s. %s, %s".formatted(
                    student.getStudentFName(),
                    student.getStudentMName().charAt(0),
                    student.getStudentLName(),
                    student.getStudentID());
            
            patientsListTableModel.addRow(new Object[]{
                info, 
                student.getStudentCourse(),
                student.getStudentCollege(),
                student.getStudentSex().toUpperCase(),
                "",
                "See Record"}
                );
        }
        int pages = (filteredPatientsList.size() / PAGE_SIZE) + 1;
        String indication = "Page %d of %d".formatted(this.currentPatientPage + 1, pages);
        

        pageNumbers.setText(indication);
        prevBtn.setEnabled(currentPatientPage > 0);
        nextBtn.setEnabled((currentPatientPage + 1) * PAGE_SIZE < filteredPatientsList.size());
    }
    
    private void applyFilter() {
        String keyword = this.patientSearchPatient.getText().trim().toLowerCase();
        String selectedSex = getSelectedButtonText(this.sexButtonGroup);
        String selectedStatus = getSelectedButtonText(this.statusButtonGroup);
        Set<String> selectedColleges = getSelectedColleges();
        boolean filterCollege = !selectedColleges.isEmpty();
        
        filteredPatientsList = students.stream()
            .filter(s -> {
                boolean matchSex = selectedSex.equalsIgnoreCase("All") ||
                                   s.getStudentSex().equalsIgnoreCase(selectedSex);

                boolean matchStatus = selectedStatus.equalsIgnoreCase("All") ||
                                      s.getStudentcivilStatus().equalsIgnoreCase(selectedStatus.substring(0, 1));

                boolean matchCollege = !filterCollege || selectedColleges.contains(s.getStudentCollege());

                if (!isPatientSearchEmpty) {
                    String fullName = String.format("%s %s. %s",
                            s.getStudentFName(),
                            s.getStudentMName().charAt(0),
                            s.getStudentLName()).toLowerCase();
                    String studentID = s.getStudentID().toLowerCase();

                    String keywordLower = keyword.toLowerCase();
                    boolean matchKeyword = fullName.contains(keywordLower) || studentID.contains(keywordLower);

                    return matchSex && matchStatus && matchCollege && matchKeyword;
                }

                return matchSex && matchStatus && matchCollege;
            })
            .collect(Collectors.toList());
        
    }
    
    
    
    private void showPanel(JPanel panelToShow) {
        this.jLayeredPane1.moveToFront(panelToShow);

        this.dash.setVisible(panelToShow == dash);
        this.patient.setVisible(panelToShow == patient);
        this.appointmentsPanel.setVisible(panelToShow == appointmentsPanel);
        this.updateStudentsTable();
    }
    
    private String getSelectedButtonText(ButtonGroup group) {
        return Collections.list(group.getElements())
            .stream()
            .filter(AbstractButton::isSelected)
            .map(AbstractButton::getText)
            .findFirst()
            .orElse("All");
    }
    
    private Set<String> getSelectedColleges() {
        Set<String> selected = new HashSet<>();
        if (this.isCAS.isSelected()) selected.add("CAS");
        if (this.isCEA.isSelected()) selected.add("CEA");
        if (this.isCOE.isSelected()) selected.add("COE");
        if (this.isCIT.isSelected()) selected.add("CIT");
        return selected;
    }

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FNameLabel;
    private javax.swing.JLabel LNameLabel;
    private javax.swing.JLabel allAppointment;
    private javax.swing.JLabel allPatients;
    private javax.swing.JRadioButton allSexRadio;
    private javax.swing.JRadioButton allStatusRadio;
    private javax.swing.JButton applyBTN;
    private javax.swing.JToggleButton appointmentsBTN;
    private javax.swing.JPanel appointmentsPanel;
    private javax.swing.JTable appointmentsTable;
    private javax.swing.JLabel clearBTN;
    private javax.swing.JPanel dash;
    private javax.swing.JToggleButton dashBTN;
    private javax.swing.JTable doctorsTable;
    private javax.swing.JToggleButton filterBTN;
    private javax.swing.JPanel filterFrame;
    private javax.swing.JRadioButton isCAS;
    private javax.swing.JRadioButton isCEA;
    private javax.swing.JRadioButton isCIT;
    private javax.swing.JRadioButton isCOE;
    private javax.swing.JRadioButton isMale;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLayeredPane layeredPane2;
    private javax.swing.JButton logoutBTN;
    private javax.swing.JButton nextBtn;
    private javax.swing.JLabel pageNumbers;
    private javax.swing.ButtonGroup panels;
    private javax.swing.JPanel patient;
    private javax.swing.JTextField patientSearchDash;
    private javax.swing.JTextField patientSearchPatient;
    private javax.swing.JToggleButton patientsBTN;
    private javax.swing.JTable patientsTable;
    private javax.swing.JTable pendingAppointmentTable;
    private javax.swing.JButton prevBtn;
    private javax.swing.JButton setAppointmentBTN;
    private javax.swing.ButtonGroup sexButtonGroup;
    private javax.swing.ButtonGroup statusButtonGroup;
    // End of variables declaration//GEN-END:variables
}

