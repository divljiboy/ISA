package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * 
 * @author Borko Arsovic
 *
 */


@Entity
@Table(name="gost")
@NamedQueries({
@NamedQuery(name = "findGostSaKorisnickimImenomILozinkom", query = "SELECT k FROM Gost k WHERE k.username like :korisnickoIme AND k.password LIKE :lozinka"),
@NamedQuery(name="findPrijatelje",query="SELECT p.prijatelj2.id  FROM Prijateljstvo p WHERE p.gost.id like korisnik.id})")
})
public class Gost extends User {

	private static final long serialVersionUID = 4298151580183210814L;

	public Gost() {
		super();
	}
	
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "gost")
	private Set<Prijateljstvo> prijatelji = new HashSet<Prijateljstvo>();

	public Set<Prijateljstvo> getPrijatelji() {
		return prijatelji;
	}

	public void setPrijatelji(Set<Prijateljstvo> prijatelji) {
		this.prijatelji = prijatelji;
	}
	
	public void removePrijatelj(Gost g){
		if(g == null)
			return;
	}
	
	

	
}
