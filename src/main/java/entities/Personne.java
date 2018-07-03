package entities;

import java.util.ArrayList;

public class Personne {
    private String firstName;
    private String lastName;
    private String adress;
    private City city;
    private String phoneNumber;
    private String portableNumber;
    private Collel collel;


    public Personne(String firstName, String lastName, String adress, City city, String phoneNumber, String portableNumber, Collel collel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.portableNumber = portableNumber;
        this.collel = collel;
    }

    public Personne() {
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPortableNumber() {
        return portableNumber;
    }

    public void setPortableNumber(String portableNumber) {
        this.portableNumber = portableNumber;
    }

    public Collel getCollel() {
        return collel;
    }

    public void setCollel(Collel collel) {
        this.collel = collel;
    }


}
