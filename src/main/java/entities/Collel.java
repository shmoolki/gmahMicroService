package entities;

public class Collel {
    private String name;
    private String nameRoshCollel;
    private City city;
    private String phoneNumber;

    public Collel() {
    }

    public Collel(String name, String nameRoshCollel, City city, String phoneNumber) {

        this.name = name;
        this.nameRoshCollel = nameRoshCollel;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getNameRoshCollel() {
        return nameRoshCollel;
    }

    public void setNameRoshCollel(String nameRoshCollel) {
        this.nameRoshCollel = nameRoshCollel;
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
}
