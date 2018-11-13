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
			log.info("save a couple of books");
			yrepository.save(new Tyyppi("Rintapäivä"));
			yrepository.save(new Tyyppi("Selkäpäivä"));
			yrepository.save(new Tyyppi("Jalkapäivä"));
			yrepository.save(new Tyyppi("Käsipäivä"));
			
			trepository.save(new Treeni("Maken raivo maanantai", "rinta", 1 , 1, yrepository.findByNimi("Rintapäivä").get(0)));
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("hae treenit");
			for (Treeni treeni : trepository.findAll()) {
				log.info(treeni.toString());
			}
			
};
	}}