package entities;

public class Gmah {
    public City city;
    public String phoneNumber;
    private String name;
    private String adress;

    public Gmah() {
    }

    public Gmah(String name, String adress, City city, String phoneNumber) {

        this.name = name;
        this.adress = adress;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Gmah{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", city=" + city +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
