package back.Lankavarasto.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
public class Vari {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="vari_id")
	private Long id;
		
	private String vari;
	
	@Column(name="maara_varastossa")
	private int maara;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "lanka_id")
	private Lanka lanka;
	
	
	public Vari() {
		super();
	}

	public Vari(Long id, String vari, int maara, Lanka lanka) {
		super();
		this.id = id;
		this.vari = vari;
		this.maara = maara;
		this.lanka = lanka;
	}

	public Vari(String vari, int maara) {
		super();
		this.vari = vari;
		this.maara = maara;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Lanka getLanka() {
		return lanka;
	}

	public void setLanka(Lanka lanka) {
		this.lanka = lanka;
	}

	@Override
	public String toString() {
		return "Vari [id=" + id + ", vari=" + vari + ", maara=" + maara + ", lanka=" + lanka + "]";
	}

	
}
