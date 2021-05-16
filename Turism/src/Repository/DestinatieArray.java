package Repository;

import Domain.Destinatie;

import java.io.*;
import java.util.ArrayList;

public class DestinatieArray {
    private ArrayList<Destinatie> destinatieArrayList = new ArrayList<>();
    private String fileName;

    public DestinatieArray(String fileName) {
        this.fileName = fileName;
        readFromFile();
    }

    public void readFromFile() {
        try {
            BufferedReader fileIn = new BufferedReader(new FileReader(this.fileName));
            String s;
            while ((s = fileIn.readLine()) != null) {
                String[] parts = s.split(", ");
                int id = Integer.parseInt(parts[0]);
                String nume = parts[1];
                String mijlocTransport = parts[2];
                Destinatie d = new Destinatie(id, nume, mijlocTransport);
                this.destinatieArrayList.add(d);
            }
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeOnFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileName));
        for (int i = 0; i < this.destinatieArrayList.size(); i++) {
            String line = destinatieArrayList.get(i).getId() + ", " + destinatieArrayList.get(i).getNume() + ", " + destinatieArrayList.get(i).getMijlocTransport();
            line += "\n";
            writer.write(line);
        }
        writer.close();
    }

    public void addDestinatie(Destinatie d) throws IOException {
        this.destinatieArrayList.add(d);
        writeOnFile();
    }

    public void updateDestinatie (int id, Destinatie newD) throws IOException {
        for (Destinatie d : destinatieArrayList) {
            if(d.getId() == id) {
                d.setNume(newD.getNume());
                d.setMijlocTransport(newD.getMijlocTransport());
            }
        }
        writeOnFile();
    }

    public void deleteDestinatie (int id) throws IOException {
        for (int i = 0; i < destinatieArrayList.size(); i++) {
            if (destinatieArrayList.get(i).getId() == id)
                this.destinatieArrayList.remove(destinatieArrayList.get(i));
        }
        writeOnFile();
    }

    public ArrayList<Destinatie> show() {
        return  this.destinatieArrayList;
    }
}
