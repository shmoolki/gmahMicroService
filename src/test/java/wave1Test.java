import dao.EmpruntRepository;
import dao.InMemoryEmpruntRepository;
import entities.*;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class wave1Test {


    private City bneiBrakCity = new City("בני ברק", "ישראל");
    private Collel bismuthCollel = new Collel("זכרון אברהם יחזקאל", "רב ביסמוט",bneiBrakCity, "5445455");
    private Lovei shmuelMouyalPersonne = new Lovei("מויאל", "שמואל", "בירנבוים 4", bneiBrakCity, "036786812", "0548413578", bismuthCollel);
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private EmpruntRepository empruntRepository = new InMemoryEmpruntRepository();
    private Devise euroDevise = new Devise("EUR" , "Euro" , "€");

    @Test
    public void TakeaGmahTest() {
         shmuelMouyalPersonne.takeGmah(new Gmah("נויבריט", "רחוב ראב״ד", bneiBrakCity, "03333333"));
        assertEquals(shmuelMouyalPersonne.getGmahEnCours().size(), 1);
    }

    @Test
    public void listGmahTaken() throws ParseException {
        Emprunt emprunt = takeEmprunt(shmuelMouyalPersonne, 10000, euroDevise, dateFormat.parse("01/07/2018"), dateFormat.parse("01/10/2018"));
        assertThat(empruntRepository.all(), hasItem(emprunt));
        Emprunt emp2 = takeEmprunt(shmuelMouyalPersonne,15000,euroDevise,dateFormat.parse("02/05/2017"), dateFormat.parse("02/08/2017") );
        assertThat(empruntRepository.all(), hasItem(emp2));
        assertEquals(2,empruntRepository.all().size());
    }


    @Test
    public void garantHandle() throws ParseException {
        Arev garant = new Arev("Cohen","David","Birnbaum 4", bneiBrakCity,"343434","34343434",bismuthCollel);
        Emprunt emprunt = takeEmprunt(shmuelMouyalPersonne, 10000, euroDevise, dateFormat.parse("01/07/2018"), dateFormat.parse("01/10/2018"));
        emprunt.addArev(garant);
        assertEquals(1,emprunt.getListArevim().size());

    }




    private Emprunt takeEmprunt(Personne personne, double amount, Devise devise, Date DateEmprunt, Date DateRemboursement) {
        Emprunt emprunt = new Emprunt();
        empruntRepository.save(emprunt);
        return emprunt;
    }


}
