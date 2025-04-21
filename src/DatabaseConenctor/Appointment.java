/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseConenctor;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author netha
 */
@Entity
@Table(name = "appointment")
@NamedQueries({
    @NamedQuery(name = "Appointment.findAll", query = "SELECT a FROM Appointment a"),
    @NamedQuery(name = "Appointment.findByAppointmnetID", query = "SELECT a FROM Appointment a WHERE a.appointmnetID = :appointmnetID"),
    @NamedQuery(name = "Appointment.findByCreateDate", query = "SELECT a FROM Appointment a WHERE a.createDate = :createDate"),
    @NamedQuery(name = "Appointment.findByConfirmDate", query = "SELECT a FROM Appointment a WHERE a.confirmDate = :confirmDate"),
    @NamedQuery(name = "Appointment.findByRescheduleDate", query = "SELECT a FROM Appointment a WHERE a.rescheduleDate = :rescheduleDate"),
    @NamedQuery(name = "Appointment.findByStatus", query = "SELECT a FROM Appointment a WHERE a.status = :status"),
    @NamedQuery(name = "Appointment.findByNotified", query = "SELECT a FROM Appointment a WHERE a.notified = :notified")})
public class Appointment implements Serializable {

    @Column(name = "confirm_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date confirmDate;
    @Column(name = "reschedule_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rescheduleDate;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "appointmnet_ID")
    private Integer appointmnetID;
    @Basic(optional = false)
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @Column(name = "notified")
    private short notified;
    @JoinColumn(name = "student_ID", referencedColumnName = "student_ID")
    @ManyToOne(optional = false)
    private Student studentID;

    public Appointment() {
    }

    public Appointment(Integer appointmnetID) {
        this.appointmnetID = appointmnetID;
    }

    public Appointment(Integer appointmnetID, Date createDate, Date rescheduleDate, String status, short notified) {
        this.appointmnetID = appointmnetID;
        this.createDate = createDate;
        this.rescheduleDate = rescheduleDate;
        this.status = status;
        this.notified = notified;
    }

    public Integer getAppointmnetID() {
        return appointmnetID;
    }

    public void setAppointmnetID(Integer appointmnetID) {
        this.appointmnetID = appointmnetID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public short getNotified() {
        return notified;
    }

    public void setNotified(short notified) {
        this.notified = notified;
    }

    public Student getStudentID() {
        return studentID;
    }

    public void setStudentID(Student studentID) {
        this.studentID = studentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appointmnetID != null ? appointmnetID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appointment)) {
            return false;
        }
        Appointment other = (Appointment) object;
        if ((this.appointmnetID == null && other.appointmnetID != null) || (this.appointmnetID != null && !this.appointmnetID.equals(other.appointmnetID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DatabaseConenctor.Appointment[ appointmnetID=" + appointmnetID + " ]";
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }

    public Date getRescheduleDate() {
        return rescheduleDate;
    }

    public void setRescheduleDate(Date rescheduleDate) {
        this.rescheduleDate = rescheduleDate;
    }
    
}
