import dao.InMemoryPersonneRepository;
import dao.PersonneRepository;
import entities.City;
import entities.Collel;
import entities.Lovei;
import entities.Personne;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class HelloWorld {
    private City bneiBrakCity = new City("בני ברק", "ישראל");
    private Collel bismuthCollel = new Collel("זכרון אברהם יחזקאל", "רב ביסמוט",bneiBrakCity, "5445455");
    private Lovei shmuelPersonne = new Lovei(12L,"מויאל", "שמואל", "בירנבוים 4", bneiBrakCity, "036786812", "0548413578", bismuthCollel);

    private PersonneRepository personneRepository = new InMemoryPersonneRepository();
    @RequestMapping("/")
    String home() {
        saveOnePersonne();
        return personneRepository.all().toString();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HelloWorld.class, args);
    }

    public void saveOnePersonne(){
         personneRepository.save(shmuelPersonne);
    }

}