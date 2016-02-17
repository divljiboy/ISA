package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 
 * @author Borko Arsovic
 *
 */

@Entity
@Table(name = "jelovnik")
public class Jelovnik {

	public Jelovnik() {
	}

	public Jelovnik(String naziv) {
		this.naziv = naziv;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "jelovnik_id", unique = true, nullable = false)
	private int id;

	@Column(name = "jelovnik_naziv", unique = false, nullable = false)
	private String naziv;

	

	
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="jelovnik") 
	private Set<Restoran> restorani;
	
	

	@ManyToMany
	@JoinTable(name = "jelovnik_jelo", joinColumns = @JoinColumn(name = "jelovnik_id", referencedColumnName = "jelovnik_id") , inverseJoinColumns = @JoinColumn(name = "jelo_id", referencedColumnName = "jelo_id") )
	private Set<Jelo> jelo;
	


	public Set<Restoran> getRestorani() {
		return restorani;
	}

	public void setRestorani(Set<Restoran> restorani) {
		this.restorani = restorani;
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
/*
	public void setJela(HashSet<Jelo> jela) {
		this.jela = jela;
	}

	Collection<Jelo> getJela() {
		if (jela == null)
			jela = new HashSet<Jelo>();
		return jela;
	}

	Iterator<Jelo> getIteratorJela() {
		if (jela == null)
			jela = new HashSet<Jelo>();
		return jela.iterator();
	}

	public void removeAllJela() {
		if (jela != null) {
			jela.clear();
		}
	}

	public void removeJelo(Jelo jelo) {
		if (jelo == null)
			return;
		if (this.jela != null) {
			if (this.jela.contains(jelo))
				this.jela.remove(jelo);
		}

	}
	
	public void addJelo(Jelo jelo){
		if(jelo == null)
			return;
		if(this.jela== null)
			this.jela = new HashSet<Jelo>();
		if(!this.jela.contains(jelo)){
			this.jela.add(jelo);
		}
	}
	
	///Divljaku je glupavo
	public void setJelo(Collection<Jelo> jela){
		removeAllJela();
		for(Iterator<Jelo> i = jela.iterator(); i.hasNext();)
			addJelo(i.next());
	}*/

}