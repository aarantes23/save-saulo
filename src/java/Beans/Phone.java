/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Beans;

/**
 *
 * @author Arthur
 */
public class Phone {
    
    private int id;
    private int id_Contact;
    private String phone;
    private String phone_type;
    //private boolean main;

    public Phone() {
    }

    public Phone(int id, int id_Contact, String phone, String phone_type) {
        this.id = id;
        this.id_Contact = id_Contact;
        this.phone = phone;
        this.phone_type = phone_type;
        //this.main = main;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_Contact() {
        return id_Contact;
    }

    public void setId_Contact(int id_Contact) {
        this.id_Contact = id_Contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone_type() {
        return phone_type;
    }

    public void setPhone_type(String phone_type) {
        this.phone_type = phone_type;
    }
/*
    public boolean getMain() {
        return main;
    }

    public void setMain(boolean main) {
        this.main = main;
    }
  */         
}
