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
@Table(name = "medical_history")
@NamedQueries({
    @NamedQuery(name = "MedicalHistory.findAll", query = "SELECT m FROM MedicalHistory m"),
    @NamedQuery(name = "MedicalHistory.findByHistoryID", query = "SELECT m FROM MedicalHistory m WHERE m.historyID = :historyID"),
    @NamedQuery(name = "MedicalHistory.findByDateTaken", query = "SELECT m FROM MedicalHistory m WHERE m.dateTaken = :dateTaken"),
    @NamedQuery(name = "MedicalHistory.findByHasAsthma", query = "SELECT m FROM MedicalHistory m WHERE m.hasAsthma = :hasAsthma"),
    @NamedQuery(name = "MedicalHistory.findByHasEpilepsy", query = "SELECT m FROM MedicalHistory m WHERE m.hasEpilepsy = :hasEpilepsy"),
    @NamedQuery(name = "MedicalHistory.findByHasHermia", query = "SELECT m FROM MedicalHistory m WHERE m.hasHermia = :hasHermia"),
    @NamedQuery(name = "MedicalHistory.findByHasheartDisease", query = "SELECT m FROM MedicalHistory m WHERE m.hasheartDisease = :hasheartDisease"),
    @NamedQuery(name = "MedicalHistory.findByHasAlergies", query = "SELECT m FROM MedicalHistory m WHERE m.allergies = :allergies"),
    @NamedQuery(name = "MedicalHistory.findByLmp", query = "SELECT m FROM MedicalHistory m WHERE m.lmp = :lmp")})
public class MedicalHistory implements Serializable {

    @Column(name = "has_asthma")
    private Boolean hasAsthma;
    @Column(name = "has_epilepsy")
    private Boolean hasEpilepsy;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "history_ID")
    private Integer historyID;
    @Basic(optional = false)
    @Column(name = "date_taken")
    @Temporal(TemporalType.DATE)
    private Date dateTaken;
    @Column(name = "has_hermia")
    private Boolean hasHermia;
    @Column(name = "has_heartDisease")
    private Boolean hasheartDisease;
    @Lob
    @Column(name = "allergies")
    private String allergies;
    @Lob
    @Column(name = "medications")
    private String medications;
    @Lob
    @Column(name = "surgery")
    private String surgery;
    @Column(name = "LMP")
    @Temporal(TemporalType.DATE)
    private Date lmp;
    @JoinColumn(name = "student_ID", referencedColumnName = "student_ID")
    @ManyToOne(optional = false)
    private Student studentID;

    public MedicalHistory() {
    }

    public MedicalHistory(Integer historyID) {
        this.historyID = historyID;
    }

    public MedicalHistory(Integer historyID, Date dateTaken) {
        this.historyID = historyID;
        this.dateTaken = dateTaken;
    }

    public Integer getHistoryID() {
        return historyID;
    }

    public void setHistoryID(Integer historyID) {
        this.historyID = historyID;
    }

    public Date getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(Date dateTaken) {
        this.dateTaken = dateTaken;
    }

    public boolean getHasAsthma() {
        return hasAsthma;
    }

    public void setHasAsthma(Boolean hasAsthma) {
        this.hasAsthma = hasAsthma;
    }

    public boolean getHasEpilepsy() {
        return hasEpilepsy;
    }

    public void setHasEpilepsy(Boolean hasEpilepsy) {
        this.hasEpilepsy = hasEpilepsy;
    }

    public Boolean getHasHermia() {
        return hasHermia;
    }

    public void setHasHermia(Boolean hasHermia) {
        this.hasHermia = hasHermia;
    }

    public Boolean getHasheartDisease() {
        return hasheartDisease;
    }

    public void setHasheartDisease(Boolean hasheartDisease) {
        this.hasheartDisease = hasheartDisease;
    }

    public String getMedications() {
        return medications;
    }

    public void setMedications(String medications) {
        this.medications = medications;
    }

    public String getSurgery() {
        return surgery;
    }

    public void setSurgery(String surgery) {
        this.surgery = surgery;
    }

    public Date getLmp() {
        return lmp;
    }

    public void setLmp(Date lmp) {
        this.lmp = lmp;
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
        hash += (historyID != null ? historyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicalHistory)) {
            return false;
        }
        MedicalHistory other = (MedicalHistory) object;
        if ((this.historyID == null && other.historyID != null) || (this.historyID != null && !this.historyID.equals(other.historyID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DatabaseConenctor.MedicalHistory[ historyID=" + historyID + " ]";
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }
    
}
