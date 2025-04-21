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
@Table(name = "student_account")
@NamedQueries({
    @NamedQuery(name = "StudentAccount.findAll", query = "SELECT s FROM StudentAccount s"),
    @NamedQuery(name = "StudentAccount.findByAccountID", query = "SELECT s FROM StudentAccount s WHERE s.accountID = :accountID"),
    @NamedQuery(name = "StudentAccount.findByUsername", query = "SELECT s FROM StudentAccount s WHERE s.username = :username"),
    @NamedQuery(name = "StudentAccount.findByPassword", query = "SELECT s FROM StudentAccount s WHERE s.password = :password"),
    @NamedQuery(name = "StudentAccount.findByCreatedAt", query = "SELECT s FROM StudentAccount s WHERE s.createdAt = :createdAt"),
    @NamedQuery(name = "StudentAccount.findByLastLogin", query = "SELECT s FROM StudentAccount s WHERE s.lastLogin = :lastLogin")})
public class StudentAccount implements Serializable {

    @JoinColumn(name = "student_ID", referencedColumnName = "student_ID")
    @ManyToOne(optional = false)
    private Student studentID;

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
    @Column(name = "createdAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "lastLogin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;

    public StudentAccount() {
    }

    public StudentAccount(Integer accountID) {
        this.accountID = accountID;
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

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
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
        if (!(object instanceof StudentAccount)) {
            return false;
        }
        StudentAccount other = (StudentAccount) object;
        if ((this.accountID == null && other.accountID != null) || (this.accountID != null && !this.accountID.equals(other.accountID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DatabaseConenctor.StudentAccount[ accountID=" + accountID + " ]";
    }

    public Student getStudentID() {
        return studentID;
    }

    public void setStudentID(Student studentID) {
        this.studentID = studentID;
    }
    
}
