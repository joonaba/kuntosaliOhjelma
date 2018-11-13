package palvelinohjelmointi.kuntosaliOhjlema;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import palvelinohjelmointi.kuntosaliOhjlema.domain.UserRepository;
import palvelinohjelmointi.kuntosaliOhjlema.domain.User;
import palvelinohjelmointi.kuntosaliOhjlema.domain.Treeni;
import palvelinohjelmointi.kuntosaliOhjlema.domain.TreeniRepository;
import palvelinohjelmointi.kuntosaliOhjlema.domain.Tyyppi;
import palvelinohjelmointi.kuntosaliOhjlema.domain.TyyppiRepository;



@SpringBootApplication
public class KuntosaliOhjlemaApplication {
	private static final Logger log = LoggerFactory.getLogger(KuntosaliOhjlemaApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(KuntosaliOhjlemaApplication.class, args);
	}
	@Bean
	public CommandLineRunner treeniDemo(TreeniRepository trepository, TyyppiRepository yrepository, UserRepository urepository) {
		return (args) -> {
			log.info("luodaan treenityypit");
			yrepository.save(new Tyyppi("Rintapäivä"));
			yrepository.save(new Tyyppi("Selkäpäivä"));
			yrepository.save(new Tyyppi("Jalkapäivä"));
			yrepository.save(new Tyyppi("Käsipäivä"));
			
			trepository.save(new Treeni("Maken raivo maanantai", "rinta", 2 , 1, yrepository.findByNimi("Rintapäivä").get(0)));
			trepository.save(new Treeni("Käsi keskiviikko", "kädet", 1 , 1, yrepository.findByNimi("Käsipäivä").get(0)));
			trepository.save(new Treeni("Pohje perjantai", "jalat", 1 , 1, yrepository.findByNimi("Jalkapäivä").get(0)));
			trepository.save(new Treeni("Selkätreeni ", "selkä", 1 , 2, yrepository.findByNimi("Selkäpäivä").get(0)));
			
			User user1 = new User("user", "904398274098F9F52B54110E99A2069A", "USER");
			User user2 = new User("admin", "904398274098F9F52B54110E99A2069AC", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("hae treenit");
			for (Treeni treeni : trepository.findAll()) {
				log.info(treeni.toString());
			}
			
};
	}}
