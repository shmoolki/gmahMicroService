package entities;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Depot extends Operation {
    private LocalDate dateDepot;
    public Depot(BigDecimal amount, Devise devise, LocalDate dateDepot) {
        super( amount, devise, dateDepot);
        this.dateDepot = dateDepot;
    }

    @Override
    public String toString() {
        return "Depot{" +
                ", amount=" + amount +
                ", devise=" + devise +
                ", dateOpe=" + dateOpe +
                '}';
    }
}
