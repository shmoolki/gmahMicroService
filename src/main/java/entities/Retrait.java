package entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class Retrait extends  Operation{
    private LocalDate datRetrait;
    public Retrait(BigDecimal amount, Devise devise, LocalDate dateRetrait) {
        super( amount, devise, dateRetrait);
        this.datRetrait = dateRetrait;
    }

    @Override
    public String toString() {
        return "Retrait{" +
                ", amount=" + amount +
                ", devise=" + devise +
                ", dateOpe=" + dateOpe +
                '}';
    }
}
