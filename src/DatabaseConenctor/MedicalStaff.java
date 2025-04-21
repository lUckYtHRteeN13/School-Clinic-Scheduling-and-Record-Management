/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseConenctor;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author netha
 */
@Entity
@Table(name = "medical_staff")
@NamedQueries({
    @NamedQuery(name = "MedicalStaff.findAll", query = "SELECT m FROM MedicalStaff m"),
    @NamedQuery(name = "MedicalStaff.findByStaffID", query = "SELECT m FROM MedicalStaff m WHERE m.staffID = :staffID"),
    @NamedQuery(name = "MedicalStaff.findByStaffLName", query = "SELECT m FROM MedicalStaff m WHERE m.staffLName = :staffLName"),
    @NamedQuery(name = "MedicalStaff.findByStaffMName", query = "SELECT m FROM MedicalStaff m WHERE m.staffMName = :staffMName"),
    @NamedQuery(name = "MedicalStaff.findByStaffFName", query = "SELECT m FROM MedicalStaff m WHERE m.staffFName = :staffFName"),
    @NamedQuery(name = "MedicalStaff.findByStaffEmail", query = "SELECT m FROM MedicalStaff m WHERE m.staffEmail = :staffEmail"),
    @NamedQuery(name = "MedicalStaff.findByStaffPhone", query = "SELECT m FROM MedicalStaff m WHERE m.staffPhone = :staffPhone")})
public class MedicalStaff implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "staffID")
    private Collection<StaffAccount> staffAccountCollection;
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "staff_ID")
    private String staffID;
    @Basic(optional = false)
    @Column(name = "staff_LName")
    private String staffLName;
    @Basic(optional = false)
    @Column(name = "staff_MName")
    private String staffMName;
    @Basic(optional = false)
    @Column(name = "staff_FName")
    private String staffFName;
    @Basic(optional = false)
    @Column(name = "staff_email")
    private String staffEmail;
    @Basic(optional = false)
    @Column(name = "staff_phone")
    private String staffPhone;
    @Basic(optional = false)
    @Lob
    @Column(name = "role")
    private String role;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "staffID")
    private Collection<Diagnosis> diagnosisCollection;

    public MedicalStaff() {
    }

    public MedicalStaff(String staffID) {
        this.staffID = staffID;
    }

    public MedicalStaff(String staffID, String staffLName, String staffMName, String staffFName, String staffEmail, String staffPhone, String role) {
        this.staffID = staffID;
        this.staffLName = staffLName;
        this.staffMName = staffMName;
        this.staffFName = staffFName;
        this.staffEmail = staffEmail;
        this.staffPhone = staffPhone;
        this.role = role;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getStaffLName() {
        return staffLName;
    }

    public void setStaffLName(String staffLName) {
        this.staffLName = staffLName;
    }

    public String getStaffMName() {
        return staffMName;
    }

    public void setStaffMName(String staffMName) {
        this.staffMName = staffMName;
    }

    public String getStaffFName() {
        return staffFName;
    }

    public void setStaffFName(String staffFName) {
        this.staffFName = staffFName;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Collection<Diagnosis> getDiagnosisCollection() {
        return diagnosisCollection;
    }

    public void setDiagnosisCollection(Collection<Diagnosis> diagnosisCollection) {
        this.diagnosisCollection = diagnosisCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staffID != null ? staffID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicalStaff)) {
            return false;
        }
        MedicalStaff other = (MedicalStaff) object;
        return !((this.staffID == null && other.staffID != null) || (this.staffID != null && !this.staffID.equals(other.staffID)));
    }

    @Override
    public String toString() {
        return "DatabaseConenctor.MedicalStaff[ staffID=" + staffID + " ]";
    }

    public Collection<StaffAccount> getStaffAccountCollection() {
        return staffAccountCollection;
    }

    public void setStaffAccountCollection(Collection<StaffAccount> staffAccountCollection) {
        this.staffAccountCollection = staffAccountCollection;
    }
    
}
