package entities;

import exceptions.RemboursementImpossibleException;

import java.util.ArrayList;
import java.util.Date;

public class Operation {
    protected Personne personne;
    protected double amount;
    protected Devise devise;
    protected Date dateOpe;

    public Operation(Personne personne, double amount, Devise devise, Date dateOpe) {
        this.personne = personne;
        this.amount = amount;
        this.devise = devise;
        this.dateOpe = dateOpe;

    }

    public Operation() {
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Devise getDevise() {
        return devise;
    }

    public void setDevise(Devise devise) {
        this.devise = devise;
    }

    public Date getDateOpe() {
        return dateOpe;
    }

    public void setDateOpe(Date dateOpe) {
        this.dateOpe = dateOpe;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "personne=" + personne +
                ", amount=" + amount +
                ", devise=" + devise +
                ", dateOpe=" + dateOpe +
                '}';
    }
}
