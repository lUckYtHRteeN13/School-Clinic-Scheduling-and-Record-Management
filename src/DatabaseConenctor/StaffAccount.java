/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseConenctor;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author netha
 */
@Entity
@Table(name = "staff_account")
@NamedQueries({
    @NamedQuery(name = "StaffAccount.findAll", query = "SELECT s FROM StaffAccount s"),
    @NamedQuery(name = "StaffAccount.findByStaffID", query = "SELECT s FROM StaffAccount s WHERE s.staffID.staffID = :staffID"),
    @NamedQuery(name = "StaffAccount.findByAccountID", query = "SELECT s FROM StaffAccount s WHERE s.accountID = :accountID"),
    @NamedQuery(name = "StaffAccount.findByUsername", query = "SELECT s FROM StaffAccount s WHERE s.username = :username"),
    @NamedQuery(name = "StaffAccount.findByPassword", query = "SELECT s FROM StaffAccount s WHERE s.password = :password"),
    @NamedQuery(name = "StaffAccount.findByCreatedAt", query = "SELECT s FROM StaffAccount s WHERE s.createdAt = :createdAt"),
    @NamedQuery(name = "StaffAccount.findByLastLogIn", query = "SELECT s FROM StaffAccount s WHERE s.lastLogIn = :lastLogIn")})
public class StaffAccount implements Serializable {

    @JoinColumn(name = "staff_ID", referencedColumnName = "staff_ID")
    @ManyToOne(optional = false)
    private MedicalStaff staffID;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "accountID")
    private Collection<MedicalStaff> medicalStaffCollection;

    @Basic(optional = false)
    @Column(name = "isActive")
    private short isActive;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "accountID")
    private Integer accountID;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "createdAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "lastLogIn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogIn;

    public StaffAccount() {
    }

    public StaffAccount(Integer accountID) {
        this.accountID = accountID;
    }

    public StaffAccount(Integer accountID, Date createdAt) {
        this.accountID = accountID;
        this.createdAt = createdAt;
    }

    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
        this.accountID = accountID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastLogIn() {
        return lastLogIn;
    }

    public void setLastLogIn(Date lastLogIn) {
        this.lastLogIn = lastLogIn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountID != null ? accountID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StaffAccount)) {
            return false;
        }
        StaffAccount other = (StaffAccount) object;
        return !((this.accountID == null && other.accountID != null) || (this.accountID != null && !this.accountID.equals(other.accountID)));
    }

    @Override
    public String toString() {
        return "DatabaseConenctor.StaffAccount[ accountID=" + accountID + " ]";
    }

    public short getIsActive() {
        return isActive;
    }

    public void setIsActive(short isActive) {
        this.isActive = isActive;
    }

    public Collection<MedicalStaff> getMedicalStaffCollection() {
        return medicalStaffCollection;
    }

    public void setMedicalStaffCollection(Collection<MedicalStaff> medicalStaffCollection) {
        this.medicalStaffCollection = medicalStaffCollection;
    }

    public MedicalStaff getStaffID() {
        return staffID;
    }

    public void setStaffID(MedicalStaff staffID) {
        this.staffID = staffID;
    }
    
}
