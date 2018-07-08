package entities;

import java.util.Date;

public class Depot extends Operation {
    private Date dateDepot;
    public Depot(Personne personne, double amount, Devise devise, Date dateDepot) {
        super(personne, amount, devise, dateDepot);
        this.dateDepot = dateDepot;
    }

    @Override
    public String toString() {
        return "Depot{" +
                "personne=" + personne +
                ", amount=" + amount +
                ", devise=" + devise +
                ", dateOpe=" + dateOpe +
                '}';
    }
}
