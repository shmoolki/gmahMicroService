package entities;

import exceptions.RemboursementImpossibleException;

import java.util.ArrayList;
import java.util.Date;

public class Emprunt  extends  Operation{
    private Date dateEmprunt;
    private Date dateRemboursement;
    private double resteAPayer;
    private ArrayList<Arev> listArevim = new ArrayList<Arev>();

    public Emprunt(Personne personne, double amount, Devise devise, Date dateEmprunt, Date dateRemboursement) {
        super(personne,amount,devise,dateEmprunt);
        this.dateEmprunt = dateEmprunt;
        this.dateRemboursement = dateRemboursement;
        this.resteAPayer = amount;


    }


    public Emprunt() {
        super();
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

//    @Override
//    public String toString() {
//        return "Emprunt{" +
//                "personne=" + personne +
//                ", amount=" + amount +
//                ", devise=" + devise +
//                ", dateEmprunt=" + dateEmprunt +
//                ", dateRemboursement=" + dateRemboursement +
//                ", resteAPayer=" + resteAPayer +
//                ", listArevim=" + listArevim +
//                '}';
//    }


    @Override
    public String toString() {
        return "Emprunt{" +
                "dateEmprunt=" + dateEmprunt +
                ", dateRemboursement=" + dateRemboursement +
                ", resteAPayer=" + resteAPayer +
                ", listArevim=" + listArevim +
                ", personne=" + personne +
                ", amount=" + amount +
                ", devise=" + devise +
                ", dateOpe=" + dateOpe +
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

    public void rembourse(double amountRembourser, Devise devise, Date dateRemboursement, String comment) throws RemboursementImpossibleException {
        if(this.resteAPayer - amountRembourser < 0){
            throw new RemboursementImpossibleException();
        }
        this.resteAPayer-= amountRembourser;
    }
}
