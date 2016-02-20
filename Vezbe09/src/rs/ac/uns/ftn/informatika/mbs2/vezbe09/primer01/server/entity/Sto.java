package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author Borko Arsovic
 *
 */

@Entity
@Table(name = "sto")
public class Sto implements Serializable{

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sto_id", unique = true, nullable = false)
	private int id;

	@Column(name = "broj_stola", unique = false, nullable = false)
	private int broj;

	@Column(name = "pozicija_stola", unique = false, nullable = false)
	private int pozicija;
	
		
	@OneToOne()
	@JoinColumn(name = "restoran_id" ,referencedColumnName="restoran_id", nullable = false)
	public Restoran restoran;

	public Sto() {
	}

	public Sto(int br, int pozicija) {
		this.broj = br;
		this.pozicija = pozicija;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBroj() {
		return broj;
	}

	public void setBroj(int broj) {
		this.broj = broj;
	}

	public int getPozicija() {
		return pozicija;
	}

	public void setPozicija(int pozicija) {
		this.pozicija = pozicija;
	}




	
	

}
