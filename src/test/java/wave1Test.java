import dao.EmpruntRepository;
import entities.*;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class wave1Test {

    private City bneiBrakCity = new City("בני ברק", "ישראל");
    private Personne shmuelMouyalPersonne = new Personne("מויאל", "שמואל", "בירנבוים 4", bneiBrakCity, "036786812", "0548413578", new Collel("זכרון אברהם יחזקאל", "רב ביסמוט",bneiBrakCity, "5445455"));
    private EmpruntRepository empruntRepository;

    @Test
    public void TakeaGmahTest() {
         shmuelMouyalPersonne.takeGmah(new Gmah("נויבריט", "רחוב ראב״ד", bneiBrakCity, "03333333"));
        assertEquals(shmuelMouyalPersonne.getGmahEnCours().size(), 1);
    }

    @Test
    public void listGmahTaken() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Emprunt emprunt = new Emprunt(shmuelMouyalPersonne, 10000, new Devise("EUR" , "Euro" , "€"), dateFormat.parse("01/07/2018"), dateFormat.parse("01/10/2018"));
        empruntRepository.save(emprunt);
        assertThat(empruntRepository.all(), hasItem(emprunt));
    }


}
