package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * 
 * @author Borko Arsovic
 *
 */

@Entity
@Table(name="manager")
@NamedQuery(name = "findMenadzerSaKorisnickimImenomILozinkom", query = "SELECT k FROM Manager k WHERE k.username like :korisnickoIme AND k.password LIKE :lozinka")
public class Manager extends User{
	
	public Manager(){
		super();
	}

}
