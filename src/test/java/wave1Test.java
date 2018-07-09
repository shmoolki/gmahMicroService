import dao.*;
import entities.*;
import exceptions.RemboursementImpossibleException;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class wave1Test {


    private City bneiBrakCity = new City("בני ברק", "ישראל");
    private Collel bismuthCollel = new Collel("זכרון אברהם יחזקאל", "רב ביסמוט",bneiBrakCity, "5445455");
    private Lovei shmuelMouyalPersonne = new Lovei(12L,"מויאל", "שמואל", "בירנבוים 4", bneiBrakCity, "036786812", "0548413578", bismuthCollel);
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private EmpruntRepository empruntRepository = new InMemoryEmpruntRepository();
    private Devise euroDevise = new Devise("EUR" , "Euro" , "€");
    private DepotRepository depotRepository = new InMemoryDepotRepository();
    private PersonneRepository personneRepository = new InMemoryPersonneRepository();


    @Test
    public void TakeaGmahTest() {
        shmuelMouyalPersonne.takeGmah(new Gmah("נויבריט", "רחוב ראב״ד", bneiBrakCity, "03333333"));
        assertEquals(shmuelMouyalPersonne.getGmahEnCours().size(), 1);
    }

    @Test
    public void listGmahTaken() throws ParseException {
        Emprunt emprunt = emprunter(shmuelMouyalPersonne, BigDecimal.valueOf(10000), euroDevise, dateFormat.parse("01/07/2018"), dateFormat.parse("01/10/2018"));
        assertThat(empruntRepository.all(), hasItem(emprunt));
        Emprunt emp2 = emprunter(shmuelMouyalPersonne, BigDecimal.valueOf(15000),euroDevise,dateFormat.parse("02/05/2017"), dateFormat.parse("02/08/2017") );
        assertThat(empruntRepository.all(), hasItem(emp2));
        assertEquals(2,empruntRepository.all().size());
        assertEquals(BigDecimal.valueOf(25000),shmuelMouyalPersonne.getAccount().getEmpruntAmount());
    }


    @Test
    public void garantHandle() throws ParseException {
        Arev garant = new Arev("Cohen","David","Birnbaum 4", bneiBrakCity,"343434","34343434",bismuthCollel);
        Emprunt emprunt = emprunter(shmuelMouyalPersonne, BigDecimal.valueOf(10000), euroDevise, dateFormat.parse("01/07/2018"), dateFormat.parse("01/10/2018"));
        emprunt.addArev(garant);
        assertEquals(1,emprunt.getListArevim().size());
        Arev garant2 = new Arev("Levy","David","Ok", bneiBrakCity,"1213213","45654567",bismuthCollel);
        emprunt.addArev(garant2);
        assertEquals(2,emprunt.getListArevim().size());
        emprunt.addArev(garant2);
        assertEquals(2,emprunt.getListArevim().size());

    }

    @Test
    public void RembourserUnEmprunt() throws ParseException, RemboursementImpossibleException {
        Arev garant = new Arev("Cohen","David","Birnbaum 4", bneiBrakCity,"343434","34343434",bismuthCollel);
        Emprunt emprunt = emprunter(shmuelMouyalPersonne, BigDecimal.valueOf(10000), euroDevise, dateFormat.parse("01/07/2018"), dateFormat.parse("01/10/2018"));
        emprunt.addArev(garant);

        emprunt.rembourse(BigDecimal.valueOf(5000) , euroDevise , dateFormat.parse("01/10/2018"), "Remboursement a temps");
        assertEquals(BigDecimal.valueOf(5000) ,emprunt.getResteAPayer());
        emprunt.rembourse(BigDecimal.valueOf(5000), euroDevise , dateFormat.parse("02/10/2018"), "Remboursement a temps");
        assertEquals(BigDecimal.ZERO,emprunt.getResteAPayer());

    }

    @Test(expected = RemboursementImpossibleException.class)
    public void testRemboursementImpossible() throws ParseException, RemboursementImpossibleException {
            Emprunt emprunt = emprunter(shmuelMouyalPersonne, BigDecimal.valueOf(10000), euroDevise, dateFormat.parse("01/07/2018"), dateFormat.parse("01/10/2018"));
            emprunt.rembourse(BigDecimal.valueOf(10001), euroDevise , dateFormat.parse("01/10/2018"), "Remboursement a temps");
    }

    @Test
    public void shouldHandleDepot() throws ParseException{
        deposer(shmuelMouyalPersonne, BigDecimal.valueOf(20000), euroDevise, dateFormat.parse("01/07/2018"));
        assertEquals(BigDecimal.valueOf(20000), shmuelMouyalPersonne.getAccount().getDepotAmount());
        deposer(shmuelMouyalPersonne, BigDecimal.valueOf(25000), euroDevise, dateFormat.parse("01/08/2018"));
        assertEquals(BigDecimal.valueOf(45000), shmuelMouyalPersonne.getAccount().getDepotAmount());

    }

    @Test
    public void shouldHandleRetrait() throws  ParseException{



    }

    @Test
    public void handlePersonneCreate(){
        Personne personne = new Personne("Cohen","David","Rue du test 26",bneiBrakCity,"039204","3238290334",null);
        personneRepository.save(personne);
        personneRepository.save(shmuelMouyalPersonne);
        assertThat(personneRepository.all(), hasItem(personne));
        assertThat(personneRepository.all(), hasItem(shmuelMouyalPersonne));

    }

    @Test
    public void handlePersonneUpdate(){
        Personne personne = new Personne( 1L,"Cohen","David","Rue du test 26",bneiBrakCity,"039204","3238290334",null);
        personneRepository.save(personne);
        Optional<Personne> personne1 = personneRepository.getById(1L);
        assertEquals(personne1.get(),personne);
        personne1.get().setFirstName("Kohen");
        personneRepository.save(personne1.get());
        assertEquals("Kohen",personneRepository.getById(1L).get().getFirstName() );
        assertEquals(1 , personneRepository.all().size());
    }

    private Emprunt emprunter(Personne personne, BigDecimal amount, Devise devise, Date dateEmprunt, Date dateRemboursement) {
        Emprunt emprunt = new Emprunt(amount,devise,dateEmprunt,dateRemboursement);
        personne.emprunte(emprunt);
        empruntRepository.save(emprunt);
        return emprunt;
    }

    private  void deposer(Personne personne,BigDecimal amount,Devise euroDevise, Date dateDepot) throws ParseException {
        Depot depot = new Depot( amount,euroDevise, dateDepot);
        shmuelMouyalPersonne.depose(depot);
        depotRepository.save(depot);
    }

}
