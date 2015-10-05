/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package controler;

import javax.faces.application.FacesMessage;
import java.io.Serializable;
import java.util.Locale;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Arthur
 */
@ManagedBean(name = "controlerLocaleMB")
@ApplicationScoped
public class ControlerLocale implements Serializable {

    private Locale currentLocale;

    public ControlerLocale() {
    }

    public void englishLocale() {
        currentLocale = Locale.US;
        FacesContext.getCurrentInstance().getViewRoot().setLocale(currentLocale);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Language successfully changed!"));
    }

    public void portugueseLocale() {
        currentLocale = new Locale("pt", "BR");
        FacesContext.getCurrentInstance().getViewRoot().setLocale(currentLocale);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Idioma alterado com sucesso!"));
    }

    public Locale getCurrentLocale() {
        return currentLocale;
    }

    public void setCurrentLocale(Locale currentLocale) {
        this.currentLocale = currentLocale;
    }
}
