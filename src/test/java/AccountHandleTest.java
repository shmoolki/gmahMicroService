import dao.EmpruntRepository;
import dao.InMemoryEmpruntRepository;
import dao.InMemoryPersonneRepository;
import dao.PersonneRepository;
import entities.*;
import org.junit.Test;
import services.EmpruntService;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static junit.framework.TestCase.assertEquals;

public class AccountHandleTest
{
    private City bneiBrakCity = new City("בני ברק", "ישראל");
    private Collel bismuthCollel = new Collel("זכרון אברהם יחזקאל", "רב ביסמוט",bneiBrakCity, "5445455");
    private Lovei shmuelPersonne = new Lovei(12L,"מויאל", "שמואל", "בירנבוים 4", bneiBrakCity, "036786812", "0548413578", bismuthCollel);
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private EmpruntRepository empruntRepository = new InMemoryEmpruntRepository();
    private Devise shekelDevise = new Devise("ILS" , "Shekel" , "₪");
    private PersonneRepository personneRepository = new InMemoryPersonneRepository();
    private EmpruntService empruntService = new EmpruntService(empruntRepository);

    @Test
    public void shouldReturnZeroEmpruntDepotWhenZeroEmpruntDepot() throws ParseException {
        assertEquals(BigDecimal.ZERO,shmuelPersonne.getAccount().getEmpruntAmount());
        assertEquals(BigDecimal.ZERO,shmuelPersonne.getAccount().getDepotAmount());
    }

    @Test
    public void shouldReturn1000Emprunt0DepotWhen1000Emprunt0Depot() throws ParseException {
        Emprunt emprunt = FunctionForTest.emprunter(shmuelPersonne, BigDecimal.valueOf(1000), shekelDevise, dateFormat.parse("01/07/2018"), dateFormat.parse("01/10/2018"),personneRepository, empruntRepository);
        assertEquals(BigDecimal.valueOf(1000),shmuelPersonne.getAccount().getEmpruntAmount());
        assertEquals(BigDecimal.ZERO,shmuelPersonne.getAccount().getDepotAmount());
    }

}
