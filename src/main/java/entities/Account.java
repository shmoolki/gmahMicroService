package entities;

import java.math.BigDecimal;

public class Account {
    private BigDecimal depotAmount;
    private BigDecimal empruntAmount;

    public Account() {
        this.depotAmount = BigDecimal.ZERO;
        this.empruntAmount = BigDecimal.ZERO;
    }

    public BigDecimal getDepotAmount() {
        return depotAmount;
    }

    public void setDepotAmount(BigDecimal depotAmount) {
        this.depotAmount = depotAmount;
    }

    public BigDecimal getEmpruntAmount() {
        return empruntAmount;
    }

    public void setEmpruntAmount(BigDecimal empruntAmount) {
        this.empruntAmount = empruntAmount;
    }

    public void addDepot(Depot depot) {
        this.depotAmount =this.depotAmount.add(depot.amount);
    }

    public void addEmprunt(Emprunt emprunt) {
        this.empruntAmount = this.empruntAmount.add(emprunt.amount);
    }

    public void addRetrait(Retrait retrait) {
        this.depotAmount = this.depotAmount.subtract(retrait.amount);
    }
}
