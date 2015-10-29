/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package controler;

import dao.CommitmentDao;
import dao.ContactDao;
import model.Commitment;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Contact;

/**
 *
 * @author Arthur
 */
@ManagedBean(name = "controlerCommitmentMB")
@SessionScoped
public class ControlerCommitment implements Serializable {
    
    private List<Commitment> list;
    private Commitment commitment;
    private Boolean status; // If Status = true then the city is new, else the user is editing
    private int i;
    private final CommitmentDao commitmentDao;
    private int id_Contact;
    private Contact contact;
    private Boolean commitmentStatus;

    /**
     * Creates a new instance of ControlerCity
     */
    public ControlerCommitment() {
        status = true;
        commitmentDao = new CommitmentDao();
        list = new ArrayList();
        list = commitmentDao.list();
        i = 0;
    }
    
    public String newCommitment() {
        commitment = new Commitment();
        status = true;
        return "insertCommitment";
    }
    
    public String remove(Commitment commitment) {
        if (commitmentDao.delete(commitment)) {
            list = commitmentDao.list();
            util.UtilMensagens.success("Sucess");
            return "viewCommitment?faces-redirect=true";
        } else {
            util.UtilMensagens.erro("Erro");
            return null;
        }
    }
    
    private void defineContact() {
        ContactDao contactDao = new ContactDao();
        contact = contactDao.search(id_Contact);
        commitment.setContactid(contact);
        if (commitmentStatus == true) {
            commitment.setStatus("Yes");
        } else {
            commitment.setStatus("No");
        }
    }
    
    public String insert() {
        defineContact();
        if (commitmentDao.insert(commitment)) {
            list = commitmentDao.list();
            util.UtilMensagens.success("Sucess");
            return "viewCommitment";
        } else {
            util.UtilMensagens.erro("Erro");
            return null;
        }
    }
    
    public String change(Commitment commitment) {
        this.commitment = commitment;
        commitment.setDateStart(null);
        commitment.setDateEnd(null);
        commitment.setHourStart(null);
        commitment.setHourEnd(null);        
        status = false;
        return "insertCommitment";
    }
    
    public String makeChange() {
        defineContact();
        if (commitmentDao.change(commitment)) {
            list = commitmentDao.list();
            util.UtilMensagens.success("Sucess");
            return "viewCommitment";
        } else {
            util.UtilMensagens.erro("Erro");
            return null;
        }
    }
    
    public List<Commitment> getList() {
        return list;
    }
    
    public void setList(List<Commitment> list) {
        this.list = list;
    }
    
    public Commitment getCommitment() {
        return commitment;
    }
    
    public void setCommitment(Commitment commitment) {
        this.commitment = commitment;
    }
    
    public Boolean getStatus() {
        return status;
    }
    
    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    public int getI() {
        return i;
    }
    
    public void setI(int i) {
        this.i = i;
    }
    
    public int getId_Contact() {
        return id_Contact;
    }
    
    public void setId_Contact(int id_Contact) {
        this.id_Contact = id_Contact;
    }
    
    public Contact getContact() {
        return contact;
    }
    
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Boolean getCommitmentStatus() {
        return commitmentStatus;
    }

    public void setCommitmentStatus(Boolean commitmentStatus) {
        this.commitmentStatus = commitmentStatus;
    }
    
}
