package eb.egonb.oefeningintents;

import android.os.Parcelable;

import java.io.Serializable;

public class Gebruiker implements Serializable {

    private String naam;
    private String telefoonNr;
    private String website;
    private String adres;

    public Gebruiker(String naam, String telefoonNr, String website, String adres) {
        this.naam = naam;
        this.telefoonNr = telefoonNr;
        this.website = website;
        this.adres = adres;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getTelefoonNr() {
        return telefoonNr;
    }

    public void setTelefoonNr(String telefoonNr) {
        this.telefoonNr = telefoonNr;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}
