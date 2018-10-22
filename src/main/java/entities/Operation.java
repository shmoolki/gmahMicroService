package entities;

import exceptions.RemboursementImpossibleException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Operation {
    protected BigDecimal amount;
    protected Devise devise;
    protected LocalDate dateOpe;

    public Operation( BigDecimal amount, Devise devise, LocalDate dateOpe) {

        this.amount = amount;
        this.devise = devise;
        this.dateOpe = dateOpe;

    }

    public Operation() {
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Devise getDevise() {
        return devise;
    }

    public void setDevise(Devise devise) {
        this.devise = devise;
    }

    public LocalDate getDateOpe() {
        return dateOpe;
    }

    public void setDateOpe(LocalDate dateOpe) {
        this.dateOpe = dateOpe;
    }

    @Override
    public String toString() {
        return "Operation{" +
                ", amount=" + amount +
                ", devise=" + devise +
                ", dateOpe=" + dateOpe +
                '}';
    }
}
