package entities;

import java.util.ArrayList;

public class Personne {
    protected String firstName;
    protected String lastName;
    protected String adress;
    protected City city;
    protected String phoneNumber;
    protected String portableNumber;
    protected Collel collel;
    protected Account account;
    protected Long id;


    public Personne(String firstName, String lastName, String adress, City city, String phoneNumber, String portableNumber, Collel collel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.portableNumber = portableNumber;
        this.collel = collel;
        this.account = new Account();

    }

    public Personne() {
    }

    public Personne(Long id, String firstName, String lastName, String adress, City city, String phoneNumber, String portableNumber, Collel collel) {
        this.id  = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.portableNumber = portableNumber;
        this.collel = collel;
        this.account = new Account();

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


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void depose(Depot depot) {
        this.account.addDepot(depot);
    }

    public void emprunte(Emprunt emprunt){
        this.account.addEmprunt(emprunt);
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", adress='" + adress + '\'' +
                ", city=" + city +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", portableNumber='" + portableNumber + '\'' +
                ", collel=" + collel +
                ", account=" + account +
                ", id=" + id +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void retire(Retrait retrait) {
        this.account.addRetrait(retrait);
    }
}
