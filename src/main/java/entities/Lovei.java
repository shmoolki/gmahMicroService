package entities;

import java.util.ArrayList;

public class Lovei extends Personne {

    private ArrayList<Gmah> gmahEnCours = new ArrayList<Gmah>();

    public Lovei(String firstName, String lastName, String adress, City city, String phoneNumber, String portableNumber, Collel collel) {
        super(firstName, lastName, adress, city, phoneNumber, portableNumber, collel);
    }

    public Lovei() {
    }
    public void takeGmah(Gmah gmah) {
        this.gmahEnCours.add(gmah);
    }

    public ArrayList<Gmah> gmahEnCours() {
        return gmahEnCours;
    }

    public ArrayList<Gmah> getGmahEnCours() {
        return gmahEnCours;
    }

    public void setGmahEnCours(ArrayList<Gmah> gmahEnCours) {
        this.gmahEnCours = gmahEnCours;
    }
}
