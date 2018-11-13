package palvelinohjelmointi.kuntosaliOhjlema.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import  palvelinohjelmointi.kuntosaliOhjlema.domain.Treeni;

public interface TreeniRepository extends CrudRepository<Treeni, Long> {

	List<Treeni> findByNimi(String nimi);
	
}