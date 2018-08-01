package entities;

import exceptions.RemboursementImpossibleException;
import exceptions.WrongCurrencyException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class Emprunt  extends  Operation{
    private Date dateEmprunt;
    private Date dateRemboursement;
    private BigDecimal resteAPayer;
    private ArrayList<Arev> listArevim = new ArrayList<Arev>();

    public Emprunt( BigDecimal amount, Devise devise, Date dateEmprunt, Date dateRemboursement) {
        super(amount,devise,dateEmprunt);
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

    @Override
    public String toString() {
        return "Emprunt{" +
                "dateEmprunt=" + dateEmprunt +
                ", dateRemboursement=" + dateRemboursement +
                ", resteAPayer=" + resteAPayer +
                ", listArevim=" + listArevim +
                ", amount=" + amount +
                ", devise=" + devise +
                ", dateOpe=" + dateOpe +
                '}';
    }

    public BigDecimal getResteAPayer() {
        return resteAPayer;
    }

    public void setResteAPayer(BigDecimal resteAPayer) {
        this.resteAPayer = resteAPayer;
    }

    public ArrayList<Arev> getListArevim() {
        return listArevim;
    }

    public void setListArevim(ArrayList<Arev> listArevim) {
        this.listArevim = listArevim;
    }

    public void rembourse(BigDecimal amountRembourser, Devise devise, Date dateRemboursement, String comment) throws RemboursementImpossibleException, WrongCurrencyException {
        if(!devise.equals(this.devise)){
            throw new WrongCurrencyException();
        }
        if(this.resteAPayer.subtract( amountRembourser).compareTo(BigDecimal.ZERO) < 0){
            throw new RemboursementImpossibleException();
        }
        this.resteAPayer = this.resteAPayer.subtract(amountRembourser);
    }

    public boolean isInProgress() {
        return ( this.resteAPayer.compareTo(BigDecimal.ZERO) > 0);
    }
}
