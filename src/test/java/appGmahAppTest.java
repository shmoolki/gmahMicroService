

import dao.*;
import entities.*;
import exceptions.RemboursementImpossibleException;
import exceptions.WrongCurrencyException;
import org.junit.Test;
import services.EmpruntService;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static junit.framework.TestCase.assertEquals;


public class appGmahAppTest {

    private City bneiBrakCity = new City("בני ברק", "ישראל");
    private Collel bismuthCollel = new Collel("זכרון אברהם יחזקאל", "רב ביסמוט",bneiBrakCity, "5445455");
    private Lovei shmuelPersonne = new Lovei(12L,"מויאל", "שמואל", "בירנבוים 4", bneiBrakCity, "036786812", "0548413578", bismuthCollel);
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private EmpruntRepository empruntRepository = new InMemoryEmpruntRepository();
    private Devise shekelDevise = new Devise("ILS" , "Shekel" , "₪");
    private PersonneRepository personneRepository = new InMemoryPersonneRepository();
    private EmpruntService empruntService = new EmpruntService(empruntRepository);


    @Test
    public void shouldReturnZeroEmpruntWhenZeroEmprunt() throws ParseException {
        assertEquals(empruntRepository.all().size(),0);
    }

    @Test
    public void shouldReturnOneEmpruntWhenOneEmprunt() throws ParseException {
        Emprunt emprunt = FunctionForTest.emprunter(shmuelPersonne, BigDecimal.valueOf(10000), shekelDevise, dateFormat.parse("01/07/2018"), dateFormat.parse("01/10/2018"),personneRepository, empruntRepository);
        assertEquals(empruntRepository.all().size(),1);

    }

    @Test
    public void shouldReturnTwoEmpruntWhenTwoEmprunt() throws ParseException {
        Emprunt emprunt = FunctionForTest.emprunter(shmuelPersonne, BigDecimal.valueOf(10000), shekelDevise, dateFormat.parse("01/07/2018"), dateFormat.parse("01/10/2018"),personneRepository, empruntRepository);
        Emprunt emp2 = FunctionForTest.emprunter(shmuelPersonne, BigDecimal.valueOf(20000), shekelDevise, dateFormat.parse("05/07/2018"), dateFormat.parse("05/10/2018"),personneRepository, empruntRepository);
        assertEquals(empruntRepository.all().size(),2);
    }

    @Test
    public void shouldReturnZeroEmpruntWhenTwoEmpruntButZeroInProgress() throws ParseException {
        Emprunt emprunt = FunctionForTest.emprunter(shmuelPersonne, BigDecimal.valueOf(10000), shekelDevise, dateFormat.parse("01/07/2018"), dateFormat.parse("31/07/2018"),personneRepository, empruntRepository);
        Emprunt emp2 = FunctionForTest.emprunter(shmuelPersonne, BigDecimal.valueOf(20000), shekelDevise, dateFormat.parse("05/07/2017"), dateFormat.parse("05/10/2017"),personneRepository, empruntRepository);
        assertEquals(empruntService.getInProgress().size(),0);
    }
    @Test
    public void shouldReturnOneEmpruntWhenTwoEmpruntButOneInProgress() throws ParseException {
        Emprunt emprunt = FunctionForTest.emprunter(shmuelPersonne, BigDecimal.valueOf(10000), shekelDevise, dateFormat.parse("01/07/2018"), dateFormat.parse("01/10/2018"),personneRepository, empruntRepository);
        Emprunt emp2 = FunctionForTest.emprunter(shmuelPersonne, BigDecimal.valueOf(20000), shekelDevise, dateFormat.parse("05/07/2017"), dateFormat.parse("05/10/2017"),personneRepository, empruntRepository);
        assertEquals(empruntService.getInProgress().size(),1);
    }

    @Test
    public void shouldReturnTwoEmpruntWhenTwoEmpruntInProgress() throws ParseException {
        Emprunt emprunt = FunctionForTest.emprunter(shmuelPersonne, BigDecimal.valueOf(10000), shekelDevise, dateFormat.parse("01/07/2018"), dateFormat.parse("01/10/2018"),personneRepository, empruntRepository);
        Emprunt emp2 = FunctionForTest.emprunter(shmuelPersonne, BigDecimal.valueOf(20000), shekelDevise, dateFormat.parse("05/07/2017"), dateFormat.parse("05/10/2018"),personneRepository, empruntRepository);
        assertEquals(empruntService.getInProgress().size(),2);
    }

    @Test
    public void shouldReturnTwoEmpruntInProgressWhenBeginToday() throws ParseException {
        Emprunt emprunt = FunctionForTest.emprunter(shmuelPersonne, BigDecimal.valueOf(10000), shekelDevise, new Date(), dateFormat.parse("01/10/2018"),personneRepository, empruntRepository);
        Emprunt emp2 = FunctionForTest.emprunter(shmuelPersonne, BigDecimal.valueOf(20000), shekelDevise, new Date(), dateFormat.parse("05/10/2018"),personneRepository, empruntRepository);
        assertEquals(empruntService.getInProgress().size(),2);
    }

    @Test
    public void shouldReturnFalseWhenDateInProgressButUntillPayed() throws ParseException, RemboursementImpossibleException, WrongCurrencyException {
        Emprunt emprunt = FunctionForTest.emprunter(shmuelPersonne, BigDecimal.valueOf(10000), shekelDevise, new Date(), dateFormat.parse("01/10/2018"),personneRepository, empruntRepository);
        Emprunt emp2 = FunctionForTest.emprunter(shmuelPersonne, BigDecimal.valueOf(20000), shekelDevise, new Date(), dateFormat.parse("05/10/2018"),personneRepository, empruntRepository);
        emprunt.rembourse(BigDecimal.valueOf(10000), shekelDevise , dateFormat.parse("01/10/2018"), "Remboursement a temps");
        assertEquals(emprunt.isInProgress(),false);
    }








}


