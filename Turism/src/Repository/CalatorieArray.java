package Repository;

import Domain.Calatorie;
import Domain.Destinatie;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class CalatorieArray<fileName> {
    private ArrayList<Calatorie> calatorieArrayList = new ArrayList<>();
    private String fileName;

    public CalatorieArray(String fileName) {
        this.fileName = fileName;
        readFromFile();
    }

    public void readFromFile() {
        try{
            BufferedReader fileIn = new BufferedReader(new FileReader(this.fileName));
            String s;
            while((s = fileIn.readLine()) != null) {
                String[] parts = s.split(", ");
                int id = Integer.parseInt(parts[0]);
                String dataP = parts[1];
                String orasS = parts[2];
                String dataS = parts[3];
                int nrP = Integer.parseInt(parts[4]);
                String[] partsCalatorie = parts[5].split(", ");
                ArrayList<String> pasageri = new ArrayList<>();
                Collections.addAll(pasageri, partsCalatorie);
                float pret = Float.parseFloat(parts[6]);
                int idD = Integer.parseInt(parts[7]);
                String nume = parts[8];
                String mijlocT = parts[9];
                Destinatie destinatie = new Destinatie(idD, nume, mijlocT);
                Calatorie c = new Calatorie(id, dataP, orasS, dataS, nrP, pasageri, pret, destinatie);
                this.calatorieArrayList.add(c);
            }
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeOnFile() throws IOException {
        BufferedWriter writer = new BufferedWriter((new FileWriter(this.fileName)));
        for (Calatorie calatorie : this.calatorieArrayList) {
            String line = calatorie.getId() + ", " + calatorie.getDataPlecare() + ", " + calatorie.getOrasPlecare()
                    + ", " + calatorie.getDataSosire() + ", " + String.valueOf(calatorie.getNrPasageri());
            String listCal = "";
            for (int j = 0; j < calatorie.getPasageri().size(); j++) {
                if (j == calatorie.getPasageri().size() - 1)
                    listCal += String.valueOf(calatorie.getPasageri().get(j));
                else
                    listCal += String.valueOf(calatorie.getPasageri().get(j)) + ";";
            }
            line += ", " + listCal + ", ";
            line += String.valueOf(calatorie.getPret()) + ", ";
            line += calatorie.getDestinatie();
            line += "\n";
            writer.write(line);
        }
        writer.close();
    }

    public void addCalatorie(Calatorie c) throws IOException {
        this.calatorieArrayList.add(c);
        writeOnFile();
    }

    public void updateCalatorie(int id, Calatorie c) throws IOException {
        for (Calatorie calatorie : calatorieArrayList) {
            if (calatorie.getId() == id) {
                calatorie.setDataPlecare(c.getDataPlecare());
                calatorie.setOrasPlecare(c.getOrasPlecare());
                calatorie.setDataSosire(c.getDataPlecare());
                calatorie.setNrPasageri(c.getNrPasageri());
                calatorie.setPasageri(c.getPasageri());
                calatorie.setPret(c.getPret());
                calatorie.setDestinatie(c.getDestinatie());
            }
        }
        writeOnFile();
    }

    public void deleteCalatorie(int id) throws IOException {
        for (int i = 0; i < calatorieArrayList.size(); i++) {
            if (calatorieArrayList.get(i).getId() == id)
                this.calatorieArrayList.remove(calatorieArrayList.get(i));
        }
        writeOnFile();
    }

    public ArrayList<Calatorie> show() {
        return  this.calatorieArrayList;
    }
}
