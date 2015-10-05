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
public class Contact {
    
    private int id;
    private String name;
    private String birth_date;
    private String address_street;
    private String address_num;
    private String address_comp;
    private String address_neighborhood;
    private int id_City;
    private String cep;
    private String email;

    public Contact() {
    }
    
    public Contact(int id, String name, String birth_date, String address_street, String address_num, String address_comp, String address_neighborhood, int id_City, String cep, String email) {
        this.id = id;
        this.name = name;
        this.birth_date = birth_date;
        this.address_street = address_street;
        this.address_num = address_num;
        this.address_comp = address_comp;
        this.address_neighborhood = address_neighborhood;
        this.id_City = id_City;
        this.cep = cep;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getAddress_street() {
        return address_street;
    }

    public void setAddress_street(String address_street) {
        this.address_street = address_street;
    }

    public String getAddress_num() {
        return address_num;
    }

    public void setAddress_num(String address_num) {
        this.address_num = address_num;
    }

    public String getAddress_comp() {
        return address_comp;
    }

    public void setAddress_comp(String address_comp) {
        this.address_comp = address_comp;
    }

    public String getAddress_neighborhood() {
        return address_neighborhood;
    }

    public void setAddress_neighborhood(String address_neighborhood) {
        this.address_neighborhood = address_neighborhood;
    }

    public int getId_City() {
        return id_City;
    }

    public void setId_City(int id_City) {
        this.id_City = id_City;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
              
}
