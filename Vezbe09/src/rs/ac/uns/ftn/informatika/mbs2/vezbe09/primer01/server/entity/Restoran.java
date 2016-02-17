package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author Borko Arsovic
 *
 */

@Entity
@Table(name = "restoran")
public class Restoran {

	public Restoran() {
	}
	
	public Restoran(String naziv, String opis){
		this.naziv = naziv;
		this.opis = opis;
		
	}
	

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "restoran_id", unique = true, nullable = false)
	private int id;

	@Column(name = "restoran_naziv", unique = true, nullable = false)
	private String naziv;

	@Column(name = "restoran_opis", unique = false, nullable = true)
	private String opis;
	
	@Column(name="broj_stolova" , unique = false, nullable = true)
	private int broj_stolova;
	
	

	@ManyToMany
	@JoinTable(name = "restoran_jelovnik", joinColumns = @JoinColumn(name = "restoran_id", referencedColumnName = "restoran_id") , inverseJoinColumns = @JoinColumn(name = "jelovnik_id", referencedColumnName = "jelovnik_id") )
	private Set<Jelovnik> jelovnik;
	
	
	public Set<Jelovnik> getJelovnik() {
		return jelovnik;
	}

	public void setJelovnik(Set<Jelovnik> jelovnik) {
		this.jelovnik = jelovnik;
	}


	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "restoran")
	public Set<Sto> stolovi = new HashSet<Sto>();
	
	
	
	
	public int getBroj_stolova() {
		return broj_stolova;
	}

	public void setBroj_stolova(int broj_stolova) {
		this.broj_stolova = broj_stolova;
		
	}

//	public HashSet<Jelovnik> getJelovnici() {
//		return jelovnici;
//	}

	public void setStolovi(Set<Sto> stolovi) {
		this.stolovi = stolovi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	/*public void setJelovnici(HashSet<Jelovnik> jelovnici) {
		this.jelovnici = jelovnici;
	}*/
	
	public Collection<Sto> getStolovi(){
		if(stolovi == null)
			stolovi = new HashSet<Sto>();
		return stolovi;
	}
	
	/*
	public Collection<Jelovnik>  getJelovnik(){
		if(jelovnici == null){
			jelovnici = new HashSet<Jelovnik>();
		}
		return jelovnici;
	}
	
	*/
	
	public Iterator<Sto> getIteratorStolovi(){
		if(stolovi == null)
			stolovi = new HashSet<Sto>();
		return stolovi.iterator();
	}
	
	/*public Iterator<Jelovnik> getIteratorJelovnici(){
		if(jelovnici == null){
			jelovnici = new HashSet<Jelovnik>();
		}
		return jelovnici.iterator();
	}
*/
	public void addSto(Sto sto){
		if(sto ==null)
			return;
		if(stolovi == null)
			stolovi = new HashSet<Sto>();
		if(!stolovi.contains(sto))
			stolovi.add(sto);
	}
	

	/*public void addJelovnik(Jelovnik jelovnik){
		if(jelovnik == null)
			return;
		if(jelovnici == null){
			jelovnici = new HashSet<Jelovnik>();
		}
		if(!jelovnici.contains(jelovnik)){
			jelovnici.add(jelovnik);
		}
		
	}*/
	
	public void dodajStolove(int br_stolova){
		if(stolovi==null)
			stolovi = new HashSet<Sto>();
		removeAllStolovi();

	}
	
	
	public void removeSto(Sto sto){
		if(sto!=null)
			return;
		if(stolovi!=null){
			if(stolovi.contains(sto))
				stolovi.remove(sto);
		}
	}
	
	/*public void removeJelovnik(Jelovnik jelovnik){
		if(jelovnik == null)
			return;
		if(jelovnici!=null){
			if(jelovnici.contains(jelovnik)){
				jelovnici.remove(jelovnik);
			}
		}
	}
	*/
	
	public void removeAllStolovi(){
		if(stolovi!=null){
			stolovi.clear();
		}
	}
	
	/*public void removeAllJelovnici(){
		if(jelovnici != null){
			jelovnici.clear();
		}
	}
	*/
}
