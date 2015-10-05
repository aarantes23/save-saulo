/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Beans;

import java.util.Date;

/**
 *
 * @author Arthur
 */
public class Commitment {
    
    private int id;
    private Date date_start;
    private String hour_start;
    private Date date_end;
    private String hour_end;
    private String description;
    private String observation;
    private String id_Contact;
    private Boolean status;

    public Commitment() {
    }

    public Commitment(int id, Date date_start, String hour_start, Date date_end, String hour_end, String description, String observation, String id_Contact, Boolean status) {
        this.id = id;
        this.date_start = date_start;
        this.hour_start = hour_start;
        this.date_end = date_end;
        this.hour_end = hour_end;
        this.description = description;
        this.observation = observation;
        this.id_Contact = id_Contact;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_start() {
        return date_start;
    }

    public void setDate_start(Date date_start) {
        this.date_start = date_start;
    }

    public String getHour_start() {
        return hour_start;
    }

    public void setHour_start(String hour_start) {
        this.hour_start = hour_start;
    }

    public Date getDate_end() {
        return date_end;
    }

    public void setDate_end(Date date_end) {
        this.date_end = date_end;
    }

    public String getHour_end() {
        return hour_end;
    }

    public void setHour_end(String hour_end) {
        this.hour_end = hour_end;
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

    public String getId_Contact() {
        return id_Contact;
    }

    public void setId_Contact(String id_Contact) {
        this.id_Contact = id_Contact;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
}
