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
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author netha
 */
@Entity
@Table(name = "student")
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByStudentID", query = "SELECT s FROM Student s WHERE s.studentID = :studentID"),
    @NamedQuery(name = "Student.findByStudentLName", query = "SELECT s FROM Student s WHERE s.studentLName = :studentLName"),
    @NamedQuery(name = "Student.findByStudentMName", query = "SELECT s FROM Student s WHERE s.studentMName = :studentMName"),
    @NamedQuery(name = "Student.findByStudentFName", query = "SELECT s FROM Student s WHERE s.studentFName = :studentFName"),
    @NamedQuery(name = "Student.findByStudentBrithdate", query = "SELECT s FROM Student s WHERE s.studentBrithdate = :studentBrithdate"),
    @NamedQuery(name = "Student.findByStudentCourse", query = "SELECT s FROM Student s WHERE s.studentCourse = :studentCourse"),
    @NamedQuery(name = "Student.findByStudentCollege", query = "SELECT s FROM Student s WHERE s.studentCollege = :studentCollege"),
    @NamedQuery(name = "Student.findByStudentSex", query = "SELECT s FROM Student s WHERE s.studentSex = :studentSex"),
    @NamedQuery(name = "Student.findByStudentcivilStatus", query = "SELECT s FROM Student s WHERE s.studentcivilStatus = :studentcivilStatus")})
public class Student implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentID")
    private Collection<Appointment> appointmentCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentID")
    private Collection<StudentAccount> studentAccountCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "student_ID")
    private String studentID;
    @Basic(optional = false)
    @Column(name = "student_LName")
    private String studentLName;
    @Basic(optional = false)
    @Column(name = "student_MName")
    private String studentMName;
    @Basic(optional = false)
    @Column(name = "student_FName")
    private String studentFName;
    @Basic(optional = false)
    @Lob
    @Column(name = "student_email")
    private String studentEmail;
    @Basic(optional = false)
    @Lob
    @Column(name = "student_phone")
    private String studentPhone;
    @Basic(optional = false)
    @Column(name = "student_brithdate")
    @Temporal(TemporalType.DATE)
    private Date studentBrithdate;
    @Basic(optional = false)
    @Column(name = "student_course")
    private String studentCourse;
    @Basic(optional = false)
    @Column(name = "student_college")
    private String studentCollege;
    @Basic(optional = false)
    @Lob
    @Column(name = "student_address")
    private String studentAddress;
    @Basic(optional = false)
    @Lob
    @Column(name = "student_contactPerson")
    private String studentcontactPerson;
    @Basic(optional = false)
    @Column(name = "student_sex")
    private String studentSex;
    @Basic(optional = false)
    @Column(name = "student_civilStatus")
    private String studentcivilStatus;
    @Basic(optional = false)
    @Lob
    @Column(name = "student_religion")
    private String studentReligion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentID")
    private Collection<Diagnosis> diagnosisCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentID")
    private Collection<MedicalHistory> medicalHistoryCollection;

    public Student() {
    }

    public Student(String studentID) {
        this.studentID = studentID;
    }

    public Student(String studentID, String studentLName, String studentMName, String studentFName, String studentEmail, String studentPhone, Date studentBrithdate, String studentCourse, String studentCollege, String studentAddress, String studentcontactPerson, String studentSex, String studentcivilStatus, String studentReligion) {
        this.studentID = studentID;
        this.studentLName = studentLName;
        this.studentMName = studentMName;
        this.studentFName = studentFName;
        this.studentEmail = studentEmail;
        this.studentPhone = studentPhone;
        this.studentBrithdate = studentBrithdate;
        this.studentCourse = studentCourse;
        this.studentCollege = studentCollege;
        this.studentAddress = studentAddress;
        this.studentcontactPerson = studentcontactPerson;
        this.studentSex = studentSex;
        this.studentcivilStatus = studentcivilStatus;
        this.studentReligion = studentReligion;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentLName() {
        return studentLName;
    }

    public void setStudentLName(String studentLName) {
        this.studentLName = studentLName;
    }

    public String getStudentMName() {
        return studentMName;
    }

    public void setStudentMName(String studentMName) {
        this.studentMName = studentMName;
    }

    public String getStudentFName() {
        return studentFName;
    }

    public void setStudentFName(String studentFName) {
        this.studentFName = studentFName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public Date getStudentBrithdate() {
        return studentBrithdate;
    }

    public void setStudentBrithdate(Date studentBrithdate) {
        this.studentBrithdate = studentBrithdate;
    }

    public String getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(String studentCourse) {
        this.studentCourse = studentCourse;
    }

    public String getStudentCollege() {
        return studentCollege;
    }

    public void setStudentCollege(String studentCollege) {
        this.studentCollege = studentCollege;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentcontactPerson() {
        return studentcontactPerson;
    }

    public void setStudentcontactPerson(String studentcontactPerson) {
        this.studentcontactPerson = studentcontactPerson;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public String getStudentcivilStatus() {
        return studentcivilStatus;
    }

    public void setStudentcivilStatus(String studentcivilStatus) {
        this.studentcivilStatus = studentcivilStatus;
    }

    public String getStudentReligion() {
        return studentReligion;
    }

    public void setStudentReligion(String studentReligion) {
        this.studentReligion = studentReligion;
    }

    public Collection<Diagnosis> getDiagnosisCollection() {
        return diagnosisCollection;
    }

    public void setDiagnosisCollection(Collection<Diagnosis> diagnosisCollection) {
        this.diagnosisCollection = diagnosisCollection;
    }

    public Collection<MedicalHistory> getMedicalHistoryCollection() {
        return medicalHistoryCollection;
    }

    public void setMedicalHistoryCollection(Collection<MedicalHistory> medicalHistoryCollection) {
        this.medicalHistoryCollection = medicalHistoryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentID != null ? studentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.studentID == null && other.studentID != null) || (this.studentID != null && !this.studentID.equals(other.studentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DatabaseConenctor.Student[ studentID=" + studentID + " ]";
    }

    public Collection<StudentAccount> getStudentAccountCollection() {
        return studentAccountCollection;
    }

    public void setStudentAccountCollection(Collection<StudentAccount> studentAccountCollection) {
        this.studentAccountCollection = studentAccountCollection;
    }

    public Collection<Appointment> getAppointmentCollection() {
        return appointmentCollection;
    }

    public void setAppointmentCollection(Collection<Appointment> appointmentCollection) {
        this.appointmentCollection = appointmentCollection;
    }
    
}
