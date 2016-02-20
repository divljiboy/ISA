package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;


import java.util.List;
import java.util.Set;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;

/**
 * 
 * @author Borko Arsovic
 *
 */

@Stateless
@Local(GostDaoLocal.class)
public class GostDaoBean extends GenericDaoBean<Gost, Integer> implements
		GostDaoLocal {

	@Override
	public Gost findGostSaKorisnickimImenomILozinkom(String korisnickoIme,
			String lozinka) {
		Query q = em.createNamedQuery("findGostSaKorisnickimImenomILozinkom");
		q.setParameter("korisnickoIme", korisnickoIme);
		q.setParameter("lozinka", lozinka);
		Gost result = (Gost) q.getSingleResult();
		return result;
	}

	@Override
	public Set<Gost> findPrijatelji(Gost g) {
		Gost gost=em.merge(g);
		return gost.getPrijatelji();
	}

	
	
	


}
