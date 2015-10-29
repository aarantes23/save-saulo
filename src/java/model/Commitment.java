/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package model;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Arthur Arantes Faria <arthurarantes23@hotmail.com>
 */
@Entity
@Table(name = "commitment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commitment.findAll", query = "SELECT c FROM Commitment c"),
    @NamedQuery(name = "Commitment.findById", query = "SELECT c FROM Commitment c WHERE c.id = :id"),
    @NamedQuery(name = "Commitment.findByDateStart", query = "SELECT c FROM Commitment c WHERE c.dateStart = :dateStart"),
    @NamedQuery(name = "Commitment.findByHourStart", query = "SELECT c FROM Commitment c WHERE c.hourStart = :hourStart"),
    @NamedQuery(name = "Commitment.findByDateEnd", query = "SELECT c FROM Commitment c WHERE c.dateEnd = :dateEnd"),
    @NamedQuery(name = "Commitment.findByHourEnd", query = "SELECT c FROM Commitment c WHERE c.hourEnd = :hourEnd"),
    @NamedQuery(name = "Commitment.findByDescription", query = "SELECT c FROM Commitment c WHERE c.description = :description"),
    @NamedQuery(name = "Commitment.findByObservation", query = "SELECT c FROM Commitment c WHERE c.observation = :observation"),
    @NamedQuery(name = "Commitment.findByStatus", query = "SELECT c FROM Commitment c WHERE c.status = :status"),
    @NamedQuery(name = "Commitment.findByContactidCity", query = "SELECT c FROM Commitment c WHERE c.contactidCity = :contactidCity")})
public class Commitment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_start")
    @Temporal(TemporalType.DATE)
    private Date dateStart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hour_start")
    @Temporal(TemporalType.DATE)
    private Date hourStart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_end")
    @Temporal(TemporalType.DATE)
    private Date dateEnd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hour_end")
    @Temporal(TemporalType.DATE)
    private Date hourEnd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "observation")
    private String observation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Contact_id_City")
    private int contactidCity;
    @JoinColumn(name = "Contact_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Contact contactid;

    public Commitment() {
    }

    public Commitment(Integer id) {
        this.id = id;
    }

    public Commitment(Integer id, Date dateStart, Date hourStart, Date dateEnd, Date hourEnd, String description, String observation, String status, int contactidCity) {
        this.id = id;
        this.dateStart = dateStart;
        this.hourStart = hourStart;
        this.dateEnd = dateEnd;
        this.hourEnd = hourEnd;
        this.description = description;
        this.observation = observation;
        this.status = status;
        this.contactidCity = contactidCity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getHourStart() {
        return hourStart;
    }

    public void setHourStart(Date hourStart) {
        this.hourStart = hourStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Date getHourEnd() {
        return hourEnd;
    }

    public void setHourEnd(Date hourEnd) {
        this.hourEnd = hourEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getContactidCity() {
        return contactidCity;
    }

    public void setContactidCity(int contactidCity) {
        this.contactidCity = contactidCity;
    }

    public Contact getContactid() {
        return contactid;
    }

    public void setContactid(Contact contactid) {
        this.contactid = contactid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commitment)) {
            return false;
        }
        Commitment other = (Commitment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Commitment[ id=" + id + " ]";
    }
    
}
