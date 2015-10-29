/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package model;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Arthur Arantes Faria <arthurarantes23@hotmail.com>
 */
@Entity
@Table(name = "phone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Phone.findAll", query = "SELECT p FROM Phone p"),
    @NamedQuery(name = "Phone.findById", query = "SELECT p FROM Phone p WHERE p.id = :id"),
    @NamedQuery(name = "Phone.findByPhone", query = "SELECT p FROM Phone p WHERE p.phone = :phone"),
    @NamedQuery(name = "Phone.findByPhoneType", query = "SELECT p FROM Phone p WHERE p.phoneType = :phoneType"),
    @NamedQuery(name = "Phone.findByMain", query = "SELECT p FROM Phone p WHERE p.main = :main"),
    @NamedQuery(name = "Phone.findByContactidCity", query = "SELECT p FROM Phone p WHERE p.contactidCity = :contactidCity")})
public class Phone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "phone_type")
    private String phoneType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "main")
    private String main;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Contact_id_City")
    private int contactidCity;
    @JoinColumn(name = "Contact_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Contact contactid;

    public Phone() {
    }

    public Phone(Integer id) {
        this.id = id;
    }

    public Phone(Integer id, String phone, String phoneType, String main, int contactidCity) {
        this.id = id;
        this.phone = phone;
        this.phoneType = phoneType;
        this.main = main;
        this.contactidCity = contactidCity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
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
        if (!(object instanceof Phone)) {
            return false;
        }
        Phone other = (Phone) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Phone[ id=" + id + " ]";
    }
    
}
