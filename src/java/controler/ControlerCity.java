/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package controler;

import dao.CityDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.City;

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
    private final CityDao cityDao;

    /**
     * Creates a new instance of ControlerCity
     */
    public ControlerCity() {
        status = true;
        cityDao = new CityDao();
        list = new ArrayList();
        list = cityDao.list();
        i = cityDao.list().size() + 1;
    }

    public String newCity() {
        city = new City();
        i = cityDao.list().size() + 1;
        status = true;
        return "insertCity";
    }

    public String remove(City city) {
        if (cityDao.delete(city)) {
            list = cityDao.list();
            util.UtilMensagens.success("Success");
            return "viewCity?faces-redirect=true";
        } else {
            util.UtilMensagens.erro("Erro");
            return null;
        }
    }

    public String insert() {
        if (cityDao.insert(city)) {
            list = cityDao.list();
            util.UtilMensagens.success("Success");
            return "viewCity";
        } else {
            util.UtilMensagens.erro("Erro");
            return null;
        }
    }

    public String change(City city) {
        this.city = city;
        status = false;
        return "insertCity";
    }

    public String makeChange() {
        if (cityDao.change(city)) {
            list = cityDao.list();
            util.UtilMensagens.success("Success");
            return "viewCity";
        } else {
            util.UtilMensagens.erro("Erro");
            return null;
        }
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
