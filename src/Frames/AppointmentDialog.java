/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frames;

import DatabaseConenctor.Appointment;
import javax.swing.JDialog;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

/**
 *
 * @author netha
 */
public class AppointmentDialog extends JDialog {

    private final JDateChooser dateChooser;
    private final JButton confirmButton;
    private Appointment appointmnent;
    private final JButton declineButton;

    public AppointmentDialog(MainFrame parent, Appointment appointment) {
        super(parent, "Set Appointment", true);
        this.appointmnent = appointment;
        setLayout(new GridBagLayout());
        setSize(350, 200);
        setLocationRelativeTo(parent);


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Date chooser
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Date:"), gbc);

        gbc.gridx = 1;
        dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("dd/MM/yyyy");
        dateChooser.setDate(new Date());
        add(dateChooser, gbc);

        // Confirm button
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2;
        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(e -> {
            Date selectedDate = dateChooser.getDate();
            if (selectedDate != null) {
                parent.getEntityManager().getTransaction().begin();
                System.out.println("Selected date: " + appointment);
                // You can combine date + time here and persist to DB
                this.appointmnent.setConfirmDate(selectedDate);
                this.appointmnent.setStatus("accepted");
                this.appointmnent.setNotified((short) 0);
                parent.getEntityManager().getTransaction().commit();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Please select a valid date.");
            }
        });
        add(confirmButton, gbc);
        
        // Confirm button
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        declineButton = new JButton("Decline");
        declineButton.addActionListener(e -> {
            // You can combine date + time here and persist to DB
            parent.getEntityManager().getTransaction().begin();
            this.appointmnent.setStatus("declined");
            this.appointmnent.setNotified((short) 0);
            parent.getEntityManager().getTransaction().commit();
            dispose();

        });
        add(declineButton, gbc);

    }
}
