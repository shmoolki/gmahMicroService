package entities;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Date;

public class Emprunt {
    private Personne personne;
    private double amount;
    private Devise devise;
    private Date dateEmprunt;
    private Date dateRemboursement;
    private double resteAPayer;
    private ArrayList<Arev> listArevim = new ArrayList<Arev>();

    public Emprunt(Personne personne, double amount, Devise devise, Date dateEmprunt, Date dateRemboursement) {
        this.personne = personne;
        this.amount = amount;
        this.devise = devise;
        this.dateEmprunt = dateEmprunt;
        this.dateRemboursement = dateRemboursement;
        this.resteAPayer = amount;


    }

    public Emprunt() {
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

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public Date getDateRemboursement() {
        return dateRemboursement;
    }

    public void setDateRemboursement(Date dateRemboursement) {
        this.dateRemboursement = dateRemboursement;
    }

    public void addArev(Arev garant) {
        if(!this.listArevim.contains(garant))
            this.listArevim.add(garant);
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "personne=" + personne +
                ", amount=" + amount +
                ", devise=" + devise +
                ", dateEmprunt=" + dateEmprunt +
                ", dateRemboursement=" + dateRemboursement +
                ", resteAPayer=" + resteAPayer +
                ", listArevim=" + listArevim +
                '}';
    }

    public double getResteAPayer() {
        return resteAPayer;
    }

    public void setResteAPayer(double resteAPayer) {
        this.resteAPayer = resteAPayer;
    }

    public ArrayList<Arev> getListArevim() {
        return listArevim;
    }

    public void setListArevim(ArrayList<Arev> listArevim) {
        this.listArevim = listArevim;
    }

    public void rembourse(double amountRembourser, Devise devise, Date dateRemboursement, String comment) {
        this.resteAPayer-= amountRembourser;
    }
}
