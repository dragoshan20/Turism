package Service;

import Domain.Destinatie;
import Domain.Calatorie;
import Repository.CalatorieArray;

import  java.io.IOException;
import java.util.ArrayList;

public class ServiceCalatorie {
    private CalatorieArray calatorieArray;

    public ServiceCalatorie(CalatorieArray calatorieArray) {
        this.calatorieArray = calatorieArray;
    }

    public void addCalatorie (int id, String dataPlecare, String orasPlecare, String dataSosire,
                              int nrPasageri, ArrayList<String> pasageri, float pret, Destinatie destinatie) throws IOException {
        Calatorie c = new Calatorie(id, dataPlecare, orasPlecare, dataSosire, nrPasageri, pasageri, pret, destinatie);
        calatorieArray.addCalatorie(c);
    }

    public void updateCalatorie (int id, String dataPlecare, String orasPlecare, String dataSosire,
                                 int nrPasageri, ArrayList<String> pasageri, float pret, Destinatie destinatie) throws IOException {
        Calatorie c = new Calatorie(id, dataPlecare, orasPlecare, dataSosire, nrPasageri, pasageri, pret, destinatie);
        calatorieArray.updateCalatorie(id, c);
    }

    public void deleteCalatorie (int id) throws IOException {
        calatorieArray.deleteCalatorie(id);
    }

    public ArrayList<Calatorie> showCalatorie() {
        return calatorieArray.show();
    }
}
