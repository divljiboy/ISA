package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.awt.Menu;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Local;
import javax.ejb.Stateless;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
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

	

	@Override
	public void dodajMeni(Restoran r, Jelovnik m) {
		Jelovnik jelo=em.merge(m);
		Restoran res=em.merge(r);
		res.dodajJelovnik(jelo);
		em.persist(res);
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void izbrisiMeni(Restoran r, Jelovnik m) {
		Jelovnik jelo=em.merge(m);
		Restoran res=em.merge(r);
		res.izbrisiJelovnik(jelo);
		em.persist(res);
		
	}

	
	@Override
	public Set<Jelovnik> findAllKojiNisu(Restoran g, List<Jelovnik> ab) {

		Restoran rest = em.merge(g);
		Set<Jelovnik> meniji = rest.getJelovnik();
		Set<Jelovnik> mogucaResenja = new HashSet<Jelovnik>();
		
		Set<Jelovnik> meniji2 = new HashSet<Jelovnik>();
		for (Jelovnik pr : meniji) {
			meniji2.add(pr);
		}
		
		
		for(Jelovnik meni: ab){
			
				if(!meniji2.contains(meni))
				{
					mogucaResenja.add(meni);
				}
			
			
		}
		
		return mogucaResenja;
	}

	

	


	
}
