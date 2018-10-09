import dao.DepotRepository;
import dao.EmpruntRepository;
import dao.PersonneRepository;
import dao.RetraitRepository;
import entities.*;

import java.math.BigDecimal;
import java.util.Date;

public   class FunctionForTest
{
    public static Emprunt emprunter(Personne personne, BigDecimal amount, Devise devise, Date dateEmprunt, Date dateRemboursement , PersonneRepository personneRepository, EmpruntRepository empruntRepository) {
        Emprunt emprunt = new Emprunt(amount,devise,dateEmprunt,dateRemboursement);
        personne.emprunte(emprunt);
        personneRepository.save(personne);
        empruntRepository.save(emprunt);
        return emprunt;
    }

    public static Depot deposer(Personne personne, BigDecimal amount, Devise devise, Date dateDepot , PersonneRepository personneRepository, DepotRepository depotRepository) {
        Depot depot = new Depot(amount,devise,dateDepot);
        personne.depose(depot);
        personneRepository.save(personne);
        depotRepository.save(depot);
        return depot;
    }

    public static Retrait retirer(Personne personne, BigDecimal amount, Devise devise, Date dateRetrait , PersonneRepository personneRepository, RetraitRepository retraitRepository) {
        Retrait retrait = new Retrait(amount,devise,dateRetrait);
        personne.retire(retrait);
        personneRepository.save(personne);
        retraitRepository.save(retrait);
        return retrait;
    }
}
