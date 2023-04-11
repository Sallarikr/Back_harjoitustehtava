package back.Lankavarasto.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
public class Ohje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="ohje_id")
	private Long id;
	
	private String suunnittelija, nimi, lahde, luokittelu;
	
	public Ohje() {
		super();
	}

	public Ohje(Long id, String suunnittelija, String nimi, String lahde, String luokittelu) {
		super();
		this.id = id;
		this.suunnittelija = suunnittelija;
		this.nimi = nimi;
		this.lahde = lahde;
		this.luokittelu = luokittelu;
	}

	public Ohje(String suunnittelija, String nimi, String lahde, String luokittelu) {
		super();
		this.suunnittelija = suunnittelija;
		this.nimi = nimi;
		this.lahde = lahde;
		this.luokittelu = luokittelu;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSuunnittelija() {
		return suunnittelija;
	}

	public void setSuunnittelija(String suunnittelija) {
		this.suunnittelija = suunnittelija;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getLahde() {
		return lahde;
	}

	public void setLahde(String lahde) {
		this.lahde = lahde;
	}

	public String getLuokittelu() {
		return luokittelu;
	}

	public void setLuokittelu(String luokittelu) {
		this.luokittelu = luokittelu;
	}

	@Override
	public String toString() {
		return "Ohje [id=" + id + ", suunnittelija=" + suunnittelija + ", nimi=" + nimi + ", lahde=" + lahde
				+ ", luokittelu=" + luokittelu + "]";
	}
}