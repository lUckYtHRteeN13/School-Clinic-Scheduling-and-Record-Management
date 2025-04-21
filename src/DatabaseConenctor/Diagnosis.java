/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseConenctor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "diagnosis")
@NamedQueries({
    @NamedQuery(name = "Diagnosis.findAll", query = "SELECT d FROM Diagnosis d"),
    @NamedQuery(name = "Diagnosis.findByRecordID", query = "SELECT d FROM Diagnosis d WHERE d.recordID = :recordID"),
    @NamedQuery(name = "Diagnosis.findByDiagnosisDate", query = "SELECT d FROM Diagnosis d WHERE d.diagnosisDate = :diagnosisDate"),
    @NamedQuery(name = "Diagnosis.findByPatientheightCm", query = "SELECT d FROM Diagnosis d WHERE d.patientheightCm = :patientheightCm"),
    @NamedQuery(name = "Diagnosis.findByPatientweightKg", query = "SELECT d FROM Diagnosis d WHERE d.patientweightKg = :patientweightKg"),
    @NamedQuery(name = "Diagnosis.findByPatientBMI", query = "SELECT d FROM Diagnosis d WHERE d.patientBMI = :patientBMI"),
    @NamedQuery(name = "Diagnosis.findByPatientBP", query = "SELECT d FROM Diagnosis d WHERE d.patientBP = :patientBP"),
    @NamedQuery(name = "Diagnosis.findByPatientPR", query = "SELECT d FROM Diagnosis d WHERE d.patientPR = :patientPR"),
    @NamedQuery(name = "Diagnosis.findByPatientTemparature", query = "SELECT d FROM Diagnosis d WHERE d.patientTemparature = :patientTemparature")})
public class Diagnosis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "record_ID")
    private Integer recordID;
    @Basic(optional = false)
    @Column(name = "diagnosis_date")
    @Temporal(TemporalType.DATE)
    private Date diagnosisDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "patient_heightCm")
    private BigDecimal patientheightCm;
    @Basic(optional = false)
    @Column(name = "patient_weightKg")
    private BigDecimal patientweightKg;
    @Basic(optional = false)
    @Column(name = "patient_BMI")
    private BigDecimal patientBMI;
    @Basic(optional = false)
    @Column(name = "patient_BP")
    private String patientBP;
    @Basic(optional = false)
    @Column(name = "patient_PR")
    private short patientPR;
    @Basic(optional = false)
    @Column(name = "patient_temparature")
    private BigDecimal patientTemparature;
    @Basic(optional = false)
    @Lob
    @Column(name = "patient_HEENT")
    private String patientHEENT;
    @Basic(optional = false)
    @Lob
    @Column(name = "patient_heart")
    private String patientHeart;
    @Basic(optional = false)
    @Lob
    @Column(name = "patient_abdomen")
    private String patientAbdomen;
    @Basic(optional = false)
    @Lob
    @Column(name = "patient_extremities")
    private String patientExtremities;
    @Basic(optional = false)
    @Lob
    @Column(name = "other")
    private String other;
    @Basic(optional = false)
    @Lob
    @Column(name = "remarks")
    private String remarks;
    @Basic(optional = false)
    @Lob
    @Column(name = "recommendation")
    private String recommendation;
    @JoinColumn(name = "student_ID", referencedColumnName = "student_ID")
    @ManyToOne(optional = false)
    private Student studentID;
    @JoinColumn(name = "staff_ID", referencedColumnName = "staff_ID")
    @ManyToOne(optional = false)
    private MedicalStaff staffID;

    public Diagnosis() {
    }

    public Diagnosis(Integer recordID) {
        this.recordID = recordID;
    }

    public Diagnosis(Integer recordID, Date diagnosisDate, BigDecimal patientheightCm, BigDecimal patientweightKg, BigDecimal patientBMI, String patientBP, short patientPR, BigDecimal patientTemparature, String patientHEENT, String patientHeart, String patientAbdomen, String patientExtremities, String other, String remarks, String recommendation) {
        this.recordID = recordID;
        this.diagnosisDate = diagnosisDate;
        this.patientheightCm = patientheightCm;
        this.patientweightKg = patientweightKg;
        this.patientBMI = patientBMI;
        this.patientBP = patientBP;
        this.patientPR = patientPR;
        this.patientTemparature = patientTemparature;
        this.patientHEENT = patientHEENT;
        this.patientHeart = patientHeart;
        this.patientAbdomen = patientAbdomen;
        this.patientExtremities = patientExtremities;
        this.other = other;
        this.remarks = remarks;
        this.recommendation = recommendation;
    }

    public Integer getRecordID() {
        return recordID;
    }

    public void setRecordID(Integer recordID) {
        this.recordID = recordID;
    }

    public Date getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(Date diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public BigDecimal getPatientheightCm() {
        return patientheightCm;
    }

    public void setPatientheightCm(BigDecimal patientheightCm) {
        this.patientheightCm = patientheightCm;
    }

    public BigDecimal getPatientweightKg() {
        return patientweightKg;
    }

    public void setPatientweightKg(BigDecimal patientweightKg) {
        this.patientweightKg = patientweightKg;
    }

    public BigDecimal getPatientBMI() {
        return patientBMI;
    }

    public void setPatientBMI(BigDecimal patientBMI) {
        this.patientBMI = patientBMI;
    }

    public String getPatientBP() {
        return patientBP;
    }

    public void setPatientBP(String patientBP) {
        this.patientBP = patientBP;
    }

    public short getPatientPR() {
        return patientPR;
    }

    public void setPatientPR(short patientPR) {
        this.patientPR = patientPR;
    }

    public BigDecimal getPatientTemparature() {
        return patientTemparature;
    }

    public void setPatientTemparature(BigDecimal patientTemparature) {
        this.patientTemparature = patientTemparature;
    }

    public String getPatientHEENT() {
        return patientHEENT;
    }

    public void setPatientHEENT(String patientHEENT) {
        this.patientHEENT = patientHEENT;
    }

    public String getPatientHeart() {
        return patientHeart;
    }

    public void setPatientHeart(String patientHeart) {
        this.patientHeart = patientHeart;
    }

    public String getPatientAbdomen() {
        return patientAbdomen;
    }

    public void setPatientAbdomen(String patientAbdomen) {
        this.patientAbdomen = patientAbdomen;
    }

    public String getPatientExtremities() {
        return patientExtremities;
    }

    public void setPatientExtremities(String patientExtremities) {
        this.patientExtremities = patientExtremities;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public Student getStudentID() {
        return studentID;
    }

    public void setStudentID(Student studentID) {
        this.studentID = studentID;
    }

    public MedicalStaff getStaffID() {
        return staffID;
    }

    public void setStaffID(MedicalStaff staffID) {
        this.staffID = staffID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recordID != null ? recordID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diagnosis)) {
            return false;
        }
        Diagnosis other = (Diagnosis) object;
        if ((this.recordID == null && other.recordID != null) || (this.recordID != null && !this.recordID.equals(other.recordID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DatabaseConenctor.Diagnosis[ recordID=" + recordID + " ]";
    }
    
}
