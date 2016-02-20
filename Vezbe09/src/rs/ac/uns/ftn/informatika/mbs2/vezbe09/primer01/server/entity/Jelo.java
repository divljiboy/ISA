package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 
 * @author Borko Arsovic
 *
 */

@Entity
@Table(name = "jelo")
public class Jelo implements Serializable {

	public Jelo() {
	}

	public Jelo(String naziv, String opis, Double cena) {
		this.naziv = naziv;
		this.opis = opis;
		this.cena = cena;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jelo_id", unique = true, nullable = false)
	private int jelo_id;

	@Column(name = "jelo_naziv", unique = false, nullable = false)
	private String naziv;

	@Column(name = "jelo_opis", unique = false, nullable = false)
	private String opis;

	@Column(name = "jelo_cena", unique = false, nullable = false)
	private Double cena;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "jelo")
	private Set<Jelovnik> jelovnik;

	public Set<Jelovnik> getJelovnik() {
		return jelovnik;
	}

	public void setJelovnik(Set<Jelovnik> jelovnik) {
		this.jelovnik = jelovnik;
	}

	public int getJelo_id() {
		return jelo_id;
	}

	public void setJelo_id(int jelo_id) {
		this.jelo_id = jelo_id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Double getCena() {
		return cena;
	}

	public void setCena(Double cena) {
		this.cena = cena;
	}

}
