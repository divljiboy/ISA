package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="rezervacija")
public class Rezervcija implements Serializable {

	private static final long serialVersionUID = -5575474153829623758L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="rezervacija_id", unique = true, nullable = false)
	private int rezervacija_id;
	

	public Rezervcija() {
		super();
	}


	@Column(name="od", unique = false, nullable = true)
	private java.sql.Timestamp od;
	
	@Column(name="do", unique = false, nullable = true)
	private java.sql.Timestamp doo;
	
	
	
	
	@OneToOne()
	@JoinColumn(name = "restoran_id" ,referencedColumnName="restoran_id", nullable = false)
	public Restoran restoran;
	
	@OneToOne()
	@JoinColumn(name = "user_id" ,referencedColumnName="user_id", nullable = false)
	public Gost gost;
	
	
	@ManyToMany
	@JoinTable(name = "pozvani", joinColumns = @JoinColumn(name = "rezervacija_id", referencedColumnName = "rezervacija_id"), inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"))
	private Set<Gost> prijatelji = new HashSet<Gost>();


	@OneToOne()
	@JoinColumn(name = "sto_id" ,referencedColumnName="sto_id", nullable = false)
	public Sto sto;


	

	




	public java.sql.Timestamp getOd() {
		return od;
	}


	public void setOd(java.sql.Timestamp od) {
		this.od = od;
	}


	public java.sql.Timestamp getDoo() {
		return doo;
	}


	public void setDoo(java.sql.Timestamp doo) {
		this.doo = doo;
	}


	public Rezervcija(Timestamp od, Timestamp doo, Restoran restoran, Gost gost, Set<Gost> prijatelji, Sto sto) {
		super();
		this.od = od;
		this.doo = doo;
		this.restoran = restoran;
		this.gost = gost;
		this.prijatelji = prijatelji;
		this.sto = sto;
	}


	public int getRezervacija_id() {
		return rezervacija_id;
	}


	public void setRezervacija_id(int rezervacija_id) {
		this.rezervacija_id = rezervacija_id;
	}





	public Sto getSto() {
		return sto;
	}


	public void setSto(Sto sto) {
		this.sto = sto;
	}


	public Restoran getRestoran() {
		return restoran;
	}


	public void setRestoran(Restoran restoran) {
		this.restoran = restoran;
	}


	public Gost getGost() {
		return gost;
	}


	public void setGost(Gost gost) {
		this.gost = gost;
	}


	public Set<Gost> getPrijatelji() {
		return prijatelji;
	}


	public void setPrijatelji(Set<Gost> prijatelji) {
		this.prijatelji = prijatelji;
	}
	
	


	
}
