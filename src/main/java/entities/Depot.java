package entities;

import java.math.BigDecimal;
import java.util.Date;

public class Depot extends Operation {
    private Date dateDepot;
    public Depot(BigDecimal amount, Devise devise, Date dateDepot) {
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
