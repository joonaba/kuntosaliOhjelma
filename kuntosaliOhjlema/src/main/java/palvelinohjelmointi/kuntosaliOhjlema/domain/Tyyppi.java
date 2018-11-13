package palvelinohjelmointi.kuntosaliOhjlema.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Entity;

import palvelinohjelmointi.kuntosaliOhjlema.domain.Treeni;

@Entity
public class Tyyppi {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long tyyppiid;
	private String nimi;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tyyppi")
	private List<Treeni> treenit;

	public Tyyppi() {}
	
	public Tyyppi(String nimi) {
		super();
		this.nimi = nimi;
	}
	
	public Long getTyyppiid() {
		return tyyppiid;
	}
	
	public void setTyyppiid(Long tyyppiid) {
		this.tyyppiid = tyyppiid;
	}
	
	public String getNimi() {
		return nimi;
	}
	
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	
	public List<Treeni> getTreenit() {
		return treenit;
	}

	public void setTreenit(List<Treeni> treenit) {
		this.treenit = treenit;
	}
	
	@Override
	public String toString() {
		return "Tyyppi [tyyppiid=" + tyyppiid + ", nimi=" + nimi + "]";
	}
	
}


