package UI;

import Domain.Calatorie;
import Domain.Destinatie;
import Service.ServiceCalatorie;
import Service.ServiceDestinatie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UI {
    private final ServiceCalatorie serviceCalatorie;
    private final ServiceDestinatie serviceDestinatie;

    public UI(ServiceCalatorie serviceCalatorie, ServiceDestinatie serviceDestinatie) {
    this.serviceCalatorie = serviceCalatorie;
    this.serviceDestinatie = serviceDestinatie;
    }

    private void addCalatorie() throws IOException {
        Scanner scn = new Scanner(System.in);
        System.out.println("Adaugati calatoria dupa modelul:id, dataPlecare, orasPlecare, dataSosire, nrPasageri, pasageri(;), pret, destinatie");
        String line = scn.nextLine();
        String[] parts = line.split(", ");

        int id = Integer.parseInt(parts[0]);
        String dP = parts[1];
        String oP = parts[2];
        String dS = parts[3];
        int nrP = Integer.parseInt(parts[4]);
        String[] partsP = parts[5].split(";");
        ArrayList<String> p = new ArrayList<>();
        Collections.addAll(p, partsP);
        float pret = Float.parseFloat(parts[6]);
        int idD = Integer.parseInt(parts[7]);
        String dest = parts[8];
        String mT = parts[9];
        Destinatie destinatie = new Destinatie(1, dest, mT);
        serviceCalatorie.addCalatorie(id, dP, oP, dS, nrP, p, pret, destinatie);
    }

    private void updateCalatorie() {
        try {
            Scanner scn = new Scanner(System.in);
            System.out.println("Actualizati calatoria dupa modelul: dataPlecare, orasPlecare, dataSosire, nrPasageri, pasageri(;), destinatie");
            String line = scn.nextLine();
            String[] parts = line.split(", ");

            int id = Integer.parseInt(parts[0]);
            String dP = parts[1];
            String oP = parts[2];
            String dS = parts[3];
            int nrP = Integer.parseInt(parts[4]);
            String[] partsP = parts[5].split(";");
            ArrayList<String> p = new ArrayList<String>();
            for (String partsPa : partsP) {
                String pasager = new String("");
                p.add(pasager);
            }
            float pret = Float.parseFloat(parts[6]);
            String dest = parts[7];
            String mT = parts[8];
            Destinatie destinatie = new Destinatie(1, dest, mT);
            serviceCalatorie.updateCalatorie(id, dP, oP, dS, nrP, p, pret, destinatie);
        } catch (IOException e) {
            e.printStackTrace();
            updateCalatorie();
        }
    }

    private void deleteCalatorie() {
        try {
            System.out.println("Ce calatorie doriti sa stergeti? ");
            Scanner s = new Scanner(System.in);
            int id = s.nextInt();
            serviceCalatorie.deleteCalatorie(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            deleteCalatorie();
        }
    }

    private void showCalatorie() {
        headCalatorie();
        ArrayList<Calatorie> calatorieArrayList = new ArrayList<Calatorie>(serviceCalatorie.showCalatorie());
        for (Calatorie calatorie : calatorieArrayList) {
            int pret = (int)calatorie.getPret();
            System.out.format("|%4d| %-17s| %-17s| %-17s| %13d| %-50s| %13d| %-40s|\n", calatorie.getId(), calatorie.getDataPlecare(),
                    calatorie.getOrasPlecare(), calatorie.getDataSosire(), calatorie.getNrPasageri(), calatorie.getPasageri(), pret, calatorie.getDestinatie());
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    private void addDestinatie() {
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Adaugati destinatia dupa modelul: id, nume destinatie, mijloc de transport");
            String line = s.nextLine();
            String[] parts = line.split(", ");

            int id = Integer.parseInt(parts[0]);
            String nume = parts[1];
            String mijlocT = parts[2];

            serviceDestinatie.addDestinatie(id, nume, mijlocT);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            addDestinatie();
        }
    }

    private void updateDestinatie() {
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Actualizati destinatia dupa modelul: id, nume destinatie, mijloc de transport");
            String line = s.nextLine();
            String[] parts = line.split(", ");

            int id = Integer.parseInt(parts[0]);
            String nume = parts[1];
            String mT = parts[2];

            serviceDestinatie.updateDestinatie(id, nume, mT);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            updateDestinatie();
        }
    }

    private void deleteDestinatie() {
        try {
            System.out.println("Dati ID-ul destinatiei pe care vreti sa o stergeti: ");
            Scanner scanner = new Scanner(System.in);
            int id = scanner.nextInt();

            serviceDestinatie.deleteDestinatie(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            deleteDestinatie();
        }
    }

    private void showDestinatie() {
        headDestinatie();
        ArrayList<Destinatie> destinatieList = new ArrayList<Destinatie>(serviceDestinatie.showDestinatie());
        for (Destinatie destinatie : destinatieList) {
            System.out.format("|%4d| %-20s| %-20s|\n", destinatie.getId(), destinatie.getNume(), destinatie.getMijlocTransport());
        }
        System.out.println("--------------------------------------------------");
    }

    private static void headCalatorie() {
        String linii = "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
        System.out.println(linii);
        String x = "|   ID|Data Plecarii    |Orasul plecarii   |Data sosirii      |   Nr pasageri|Lista pasagerilor                \t\t\t\t\t|\t\t   Pret|Destinatie     \t\t\t\t\t|\n";
        System.out.println(x);
        System.out.println(linii);
    }

    private static void headDestinatie() {
        String linii = "--------------------------------------------------";
        System.out.println(linii);
        String x = "|   ID|Nume destinatie     |Mijloc de transport  |\n";
        System.out.println(x);
        System.out.println(linii);
    }

    private static void menu() {
        System.out.println("1. Add Destinatie");
        System.out.println("2. Add Calatorie");
        System.out.println("3. Update Destinatie");
        System.out.println("4. Update Calatorie");
        System.out.println("5. Delete Destinatie");
        System.out.println("6. Delete Calatorie");
        System.out.println("7. Show Destinatii");
        System.out.println("8. Show Calatorii");
        System.out.println("0. Exit");
    }

    public void run() throws Exception {
        menu();
        System.out.println("Alegeti optiunea: ");
        Scanner s = new Scanner(System.in);
        int op = s.nextInt();
        while (op != 0) {
            switch (op) {
                case 1:
                    addDestinatie();
                    break;
                case 2:
                    addCalatorie();
                    break;
                case 3:
                    updateDestinatie();
                    break;
                case 4:
                    updateCalatorie();
                    break;
                case 5:
                    deleteDestinatie();
                    break;
                case 6:
                    deleteCalatorie();
                    break;
                case 7:
                    showDestinatie();
                    break;
                case 8:
                    showCalatorie();
                    break;
                default:
                    System.out.println("Optiune invalida");
            }
            menu();
            op = s.nextInt();
        }
    }

}


