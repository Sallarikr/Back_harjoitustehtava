package back.Lankavarasto.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
public class Vari {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "vari_id")
	private Long id;

	@Size(min = 2, max = 50, message = "Sallittu pituus on 2-50 merkkiä")
	@Column(name = "vari")
	private String savy;

	@Column(name = "maara_varastossa")
	private int maara;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "lanka_id")
	private Lanka lanka;

	public Vari() {
		super();
	}

	public Vari(String savy, int maara) {
		super();
		this.savy = savy;
		this.maara = maara;
	}

	public Vari(Long id, String savy, int maara, Lanka lanka) {
		super();
		this.id = id;
		this.savy = savy;
		this.maara = maara;
		this.lanka = lanka;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSavy() {
		return savy;
	}

	public void setSavy(String savy) {
		this.savy = savy;
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
		return "Vari [id=" + id + ", savy=" + savy + ", maara=" + maara + ", lanka=" + lanka + "]";
	}
}
