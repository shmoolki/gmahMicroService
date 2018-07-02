import entities.City;
import entities.Collel;
import entities.Gmah;
import entities.Personne;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class wave1Test {

    @Test
    public void TakeaGmahTest() {
        Personne personne = new Personne("מויאל", "שמואל", "בירנבוים 4", new City("בני ברק", "ישראל"), "036786812", "0548413578", new Collel("זכרון אברהם יחזקאל", "רב ביסמוט", new City("בני ברק", "ישראל"), "5445455"));
        personne.takeGmah(new Gmah("נויבריט", "רחוב ראב״ד", new City("בני ברק", "ישראל"), "03333333"));
        assertEquals(personne.getGmahEnCours().size(), 1);
    }


}
