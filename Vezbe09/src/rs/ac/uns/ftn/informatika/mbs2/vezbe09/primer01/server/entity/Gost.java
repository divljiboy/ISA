package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * 
 * @author Borko Arsovic
 *
 */

@Entity
@Table(name = "gost")
@NamedQueries({
		@NamedQuery(name = "findGostSaKorisnickimImenomILozinkom", query = "SELECT k FROM Gost k WHERE k.username like :korisnickoIme AND k.password LIKE :lozinka")
	 })
public class Gost extends User implements Serializable{

	public Gost() {
		super();
	}

	@ManyToMany
	@JoinTable(name = "Prijateljstva", joinColumns = @JoinColumn(name = "prijatelji1", referencedColumnName = "user_id") , inverseJoinColumns = @JoinColumn(name = "prijatelji2", referencedColumnName = "user_id") )
	private Set<Gost> prijatelji;

	public Set<Gost> getPrijatelji() {
		return prijatelji;
	}

	public void setPrijatelji(Set<Gost> prijatelji) {
		this.prijatelji = prijatelji;
	}

	public void dodajPrijateljaa(Gost g) {

		if (!prijatelji.contains(g)) {
				prijatelji.add(g);		
		}

	}
	public void izbrisiPrijateljaa(Gost g) {

		if (prijatelji.contains(g)) {
			System.out.println("Sadrzi ga");
				prijatelji.remove(g);		
		}

	}

}
