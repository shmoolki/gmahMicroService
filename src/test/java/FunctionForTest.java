import dao.EmpruntRepository;
import dao.PersonneRepository;
import entities.Devise;
import entities.Emprunt;
import entities.Personne;

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
}
