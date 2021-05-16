package Service;

import Domain.Destinatie;
import Repository.DestinatieArray;

import java.io.IOException;
import java.util.ArrayList;

public class ServiceDestinatie {
    private DestinatieArray destinatieArray;

    public ServiceDestinatie(DestinatieArray destinatieArray) {
        this.destinatieArray = destinatieArray;
    }

    public void addDestinatie(int id, String nume, String mijlocTransport) throws IOException {
        Destinatie d = new Destinatie(id, nume, mijlocTransport);
        destinatieArray.addDestinatie(d);
    }

    public void updateDestinatie(int id, String nume, String mijlocTransport) throws IOException {
        Destinatie d = new Destinatie(id, nume, mijlocTransport);
        destinatieArray.updateDestinatie(id, d);
    }

    public void deleteDestinatie(int id) throws IOException {
        destinatieArray.deleteDestinatie(id);
    }

    public ArrayList<Destinatie> showDestinatie() {
        return destinatieArray.show();
    }
}
