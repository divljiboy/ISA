package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.List;
import java.util.Set;

import javax.ejb.Local;
import javax.ejb.Stateless;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelovnik;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Manager;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;

@Stateless
@Local(RestoranDaoLocal.class)
public class RestoranDaoBean extends GenericDaoBean<Restoran, Integer> implements
		RestoranDaoLocal {

	
	@Override
	public List<Manager> ucitajMenadzera(Restoran r) {
		
		return null;
	}

	@Override
	public Set<Jelovnik> findMeniuRestoranu(Restoran r) {
		Restoran res=em.merge(r);
		
		
		return  (Set<Jelovnik>) res.getJelovnik();
		
	}



	
}
