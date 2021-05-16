package Domain;

public class Destinatie {
    private int id;
    private String nume;
    private String mijlocTransport;

    public Destinatie() {
        this.id = 0;
        this.nume = "";
        this.mijlocTransport = "";
    }

    public Destinatie(int id, String nume, String mijlocTransport) {
        this.id = id;
        this.nume = nume;
        this.mijlocTransport = mijlocTransport;
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return this.nume;
    }

    public String getMijlocTransport() {
        return this.mijlocTransport;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setMijlocTransport(String mijlocTransport) {
        this.mijlocTransport = mijlocTransport;
    }

    public String toString() {
        return id + ", " + nume + ", " + mijlocTransport;
    }
}