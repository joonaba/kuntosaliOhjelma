package palvelinohjelmointi.kuntosaliOhjlema;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.hibernate.hql.internal.ast.tree.IsNotNullLogicOperatorNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import palvelinohjelmointi.kuntosaliOhjlema.domain.Treeni;
import palvelinohjelmointi.kuntosaliOhjlema.domain.TreeniRepository;
import palvelinohjelmointi.kuntosaliOhjlema.domain.Tyyppi;

@RunWith(SpringRunner.class)
@DataJpaTest

public class TreeniRepositoryTests {
	
	@Autowired
	private TreeniRepository repository;
	
	@Test
	public void findByNimiShouldReturnTreeni() {
		List<Treeni> treenit = repository.findByNimi("Maken raivo maanantai");
				
			assertThat(treenit).hasSize(1);
			assertThat(treenit.get(0).getNimi()).isEqualTo("Maken raivo maananai");
	}
	@Test
	public void createNewTreeni() {
		Treeni treeni =new Treeni("Pohje treeni", "jalka", 1 , 1, new Tyyppi("pohjepäivä"));
		
	repository.save(treeni);
	assertThat(treeni.getId()).isNotNull();
}}
