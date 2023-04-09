package back.Lankavarasto.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
public class Vari {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="vari_id")
	private Long id;
	
	@Column(name="lanka_id")
	private String malli;
	
	private String vari;
	
	@Column(name="maara_varastossa")
	private int maara;

	public Vari() {
		super();
	}

	public Vari(Long id, String malli, String vari, int maara) {
		super();
		this.id = id;
		this.malli = malli;
		this.vari = vari;
		this.maara = maara;
	}

	public Vari(String malli, String vari, int maara) {
		super();
		this.malli = malli;
		this.vari = vari;
		this.maara = maara;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMalli() {
		return malli;
	}

	public void setMalli(String malli) {
		this.malli = malli;
	}

	public String getVari() {
		return vari;
	}

	public void setVari(String vari) {
		this.vari = vari;
	}

	public int getMaara() {
		return maara;
	}

	public void setMaara(int maara) {
		this.maara = maara;
	}

	@Override
	public String toString() {
		return "Vari [id=" + id + ", malli=" + malli + ", vari=" + vari + ", maara=" + maara
				+ "]";
	}

	
}
