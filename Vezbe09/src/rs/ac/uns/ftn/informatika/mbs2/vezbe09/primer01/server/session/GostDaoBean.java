package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Prijateljstvo;

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
	public HashSet<Prijateljstvo> findPrijatelje(Gost g) {
		Gost gst = em.merge(g);
		Set<Prijateljstvo> prijatelji = gst.getPrijatelji();
		return (HashSet<Prijateljstvo>) prijatelji;
	}

	@Override
	public HashSet<Gost> findAllKojiMuNisuPrijatelji(Gost g) {
		Gost gost = em.merge(g);
		HashSet<Prijateljstvo> prijatelji = (HashSet<Prijateljstvo>) gost
				.getPrijatelji();
		HashSet<Gost> prijateljiUlogovnog = new HashSet<Gost>();
		for (Prijateljstvo pr : prijatelji) {
			prijateljiUlogovnog.add(pr.getPrijatelj2());
		}

		HashSet<Gost> mogucaResenja = new HashSet<Gost>();

		for (Gost gst : findAll()) {
			if (!prijateljiUlogovnog.contains(gst)) {
				if (!gst.equals(gost))
					mogucaResenja.add(gst);
			}
		}
		return mogucaResenja;
	}
	
	@Override
	public HashSet<Gost> pretraga(Gost g, String imeIliPrezime) {
		Gost gost = em.merge(g);
		HashSet<Gost> mogucaResenja = findAllKojiMuNisuPrijatelji(gost);
		HashSet<Gost> result = new HashSet<Gost>();
		for(Gost gst : mogucaResenja){
			if(gst.getFirstName().contains(imeIliPrezime) || gst.getLastName().contains(imeIliPrezime)){
				result.add(gst);
				System.out.println(gst.getFirstName());
			}
		}
		return result;
	}
	
	@Override
	public void dodajPrijatelja(Gost g, Gost prijatelj) {
		Gost gost = em.merge(g);
		Prijateljstvo prijateljstvo = new Prijateljstvo();
		prijateljstvo.setGost(gost);
		prijateljstvo.setPrijatelj2(prijatelj);
		em.persist(prijateljstvo);
	}

	@Override
	public void brisanjePrijatelja(Gost g, Gost g1) {
		Gost gost = em.merge(g);
		Gost prijateljZaBrisanje = em.merge(g1);
		HashSet<Prijateljstvo> prijatelji = (HashSet<Prijateljstvo>) gost
				.getPrijatelji();
		Prijateljstvo zabr = new Prijateljstvo();

		for (Prijateljstvo pr : prijatelji) {
			if (pr.getPrijatelj2().equals(prijateljZaBrisanje)) {
				zabr = pr;
				break;
			}
		}
		em.remove(zabr);
	}

	@Override
	public void registraj(Gost g) {
		System.out.println(g.getFirstName());
		if(!findAll().contains(g))
			em.persist(g);
	}



}
