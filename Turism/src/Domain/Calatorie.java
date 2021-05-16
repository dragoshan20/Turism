package Domain;

import java.util.ArrayList;

public class Calatorie {
    private int id;
    private String dataPlecare;
    private String orasPlecare;
    private String dataSosire;
    private int nrPasageri;
    private ArrayList<String> pasageri;
    private float pret;
    private Destinatie destinatie;

    public Calatorie() {
        this.id = 0;
        this.dataPlecare = "";
        this.orasPlecare = "";
        this.dataSosire = "";
        this.nrPasageri = 0;
        this.pasageri = new ArrayList<String>();
        this.pret = 0;
        this.destinatie = new Destinatie();
    }

    public Calatorie(int id, String dataPlecare, String orasPlecare, String dataSosire, int nrPasageri, ArrayList<String> pasageri, float pret, Destinatie destinatie) {
        this.id = id;
        this.dataPlecare = dataPlecare;
        this.orasPlecare = orasPlecare;
        this.dataSosire = dataSosire;
        this.nrPasageri = nrPasageri;
        this.pasageri = pasageri;
        this.pret = pret;
        this.destinatie = destinatie;
    }

    public int getId() {
        return id;
    }

    public String getDataPlecare() {
        return this.dataPlecare;
    }

    public String getOrasPlecare() {
        return this.orasPlecare;
    }

    public String getDataSosire() {
        return this.dataSosire;
    }

    public int getNrPasageri() {
        return this.nrPasageri;
    }

    public ArrayList<String> getPasageri() {
        return this.pasageri;
    }

    public float getPret() {
        return this.pret;
    }

    public Destinatie getDestinatie() {
        return this.destinatie;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDataPlecare(String dataPlecare) {
        this.dataPlecare = dataPlecare;
    }

    public void setOrasPlecare(String orasPlecare) {
        this.orasPlecare = orasPlecare;
    }

    public void setDataSosire(String dataSosire) {
        this.dataSosire = dataSosire;
    }

    public void setNrPasageri(int nrPasageri) {
        this.nrPasageri = nrPasageri;
    }

    public void setPasageri(ArrayList<String> pasageri) {
        this.pasageri = pasageri;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public void setDestinatie(Destinatie destinatie) {
        this.destinatie = destinatie;
    }

    public String toString() {
        return id + ", " + dataPlecare + ", " + orasPlecare + ", " + dataSosire + ", " + nrPasageri + ", " + pasageri + ", " + pret + ", " + destinatie;
    }
}
