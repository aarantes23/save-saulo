/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package controler;

import Beans.City;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Arthur
 */
@ManagedBean(name = "controlerCityMB")
@SessionScoped
public class ControlerCity implements Serializable {

    private List<City> list;
    private City city;
    private Boolean status; // If Status = true then the city is new, else the user is editing
    private int i;

    /**
     * Creates a new instance of ControlerCity
     */
    public ControlerCity() {
        i = 0;
        list = new ArrayList();
        status = true;
    }

    public String remove(City city) {
        list.remove(city);
        return "viewCity?faces-redirect=true";
    }

    public String newCity() {
        city = new City();
        status = true;
        return "insertCity";
    }

    public String insert() {
        city.setId(i++);
        list.add(city);
        return "viewCity";
    }

    public String change(City city) {
        this.city = city;
        status = false;
        return "insertCity";
    }

    public String makeChange() {
        if (list.contains(this)) {
            list.add(city.getId(), city);
        }
        return "viewCity";
    }

    public List<City> getList() {
        return list;
    }

    public void setList(List<City> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
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
        
}
