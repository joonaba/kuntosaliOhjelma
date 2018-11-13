package palvelinohjelmointi.kuntosaliOhjlema.domain;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Treeni {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String nimi;
    private String lihakset;
    private Integer kerta;
    private Integer kesto;
    


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "tyyppiid")
    private Tyyppi tyyppi;
    
    
    public Treeni() {}

	public Treeni(String nimi, String lihakset, Integer kerta, Integer kesto, Tyyppi tyyppi) {
		super();
		this.nimi = nimi;
		this.lihakset = lihakset;
		this.kerta = kerta;
		this.kesto = kesto;
		this.tyyppi = tyyppi;
		
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getLihakset() {
		return lihakset;
	}

	public void setLihakset(String lihakset) {
		this.lihakset = lihakset;
	}

	public Integer getKerta() {
		return kerta;
	}

	public void setKerta(Integer kerta) {
		this.kerta = kerta;
	}
	
	public Integer getKesto() {
		return kesto;
	}

	public void setKesto(Integer kesto) {
		this.kesto = kesto;
	}
	
	public Tyyppi getTyyppi() {
		return tyyppi;
	}
	
	public void setTyyppi(Tyyppi tyyppi) {
		this.tyyppi = tyyppi;
	}
	
	
	
	@Override
	public String toString() {
		if (this.tyyppi !=null)
			return "Treeni [id=" + id + ", nimi=" + nimi + ", lihakset=" + lihakset + ", kerta=" + kerta + ", kesto=" + kesto + ", tyyppi=" + this.getTyyppi() + "]";
			else
		return "Treeni [id=" + id + ", nimi=" + nimi + ", lihakset=" + lihakset + ", kerta=" + kerta + ", kesto=" + kesto + "]";
	}
}

