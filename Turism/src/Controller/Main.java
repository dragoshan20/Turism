package Controller;

import Repository.CalatorieArray;
import Repository.DestinatieArray;
import Service.ServiceCalatorie;
import Service.ServiceDestinatie;
import UI.UI;

public class Main {
    public static void main(String[] args) throws Exception {
        String fileNameDestinatie = "C:\\Users\\anama\\Desktop\\MAP\\Turism\\src\\destinatie.txt";
        String fileNameCalatorie = "C:\\Users\\anama\\Desktop\\MAP\\Turism\\src\\calatorie.txt";

        DestinatieArray destinatieArray = new DestinatieArray(fileNameDestinatie);
        CalatorieArray calatorieArray = new CalatorieArray(fileNameCalatorie);

        ServiceDestinatie serviceDestinatie = new ServiceDestinatie(destinatieArray);
        ServiceCalatorie serviceCalatorie = new ServiceCalatorie(calatorieArray);

        UI ui = new UI(serviceCalatorie, serviceDestinatie);
        ui.run();
    }
}
