package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Admin;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelo;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelovnik;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Manager;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Prijateljstvo;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;

@Stateless
@Remote(Init.class)
public class InitBean implements Init {

	@PersistenceContext(unitName = "Vezbe09")
	EntityManager em;

	public void init() {

		Admin admin = new Admin();
		admin.setFirstName("Borko");
		admin.setLastName("Arsovic");
		admin.setUsername("a");
		admin.setPassword("a");
		em.persist(admin);

		Gost gost1 = new Gost();
		gost1.setFirstName("Mitar");
		gost1.setLastName("Mitrovic");
		gost1.setUsername("gost");
		gost1.setPassword("gost");
		em.persist(gost1);

		Gost gost2 = new Gost();
		gost2.setFirstName("Lola");
		gost2.setLastName("Bojic");
		gost2.setUsername("gost2");
		gost2.setPassword("gost2");
		em.persist(gost2);

		Gost gost3 = new Gost();
		gost3.setFirstName("Pera");
		gost3.setLastName("Peric");
		gost3.setUsername("gost3");
		gost3.setPassword("gost3");
		em.persist(gost3);

		Gost gost4 = new Gost();
		gost4.setFirstName("Boba");
		gost4.setLastName("Mikic");
		gost4.setUsername("gost4");
		gost4.setPassword("gost4");
		em.persist(gost4);

		Gost gost5 = new Gost();
		gost5.setFirstName("Zivoin");
		gost5.setLastName("Misic");
		gost5.setUsername("gost5");
		gost5.setPassword("gost5");
		em.persist(gost5);

		Gost gost6 = new Gost();
		gost6.setFirstName("Moma");
		gost6.setLastName("Mitkovic");
		gost6.setUsername("gost6");
		gost6.setPassword("gost6");
		em.persist(gost6);

		Prijateljstvo prijateljstvo1 = new Prijateljstvo();
		prijateljstvo1.setGost(gost1);
		prijateljstvo1.setPrijatelj2(gost2);
		em.persist(prijateljstvo1);

		Prijateljstvo prijateljstvo2 = new Prijateljstvo();
		prijateljstvo2.setGost(gost1);
		prijateljstvo2.setPrijatelj2(gost3);
		em.persist(prijateljstvo2);

		Prijateljstvo prijateljstvo3 = new Prijateljstvo();
		prijateljstvo3.setGost(gost5);
		prijateljstvo3.setPrijatelj2(gost6);
		em.persist(prijateljstvo3);

		Manager manager = new Manager();
		manager.setFirstName("Zika");
		manager.setLastName("Petrovic");
		manager.setUsername("menadzer");
		manager.setPassword("menadzer");
		em.persist(manager);

		Restoran restoran1 = new Restoran();
		restoran1.setNaziv("Plava Frajla");
		restoran1.setOpis("Domaca kuhinja");
		restoran1.setBroj_stolova(20);
		em.persist(restoran1);

		Restoran restoran2 = new Restoran();
		restoran2.setNaziv("Panceta");
		restoran2.setOpis("Mediteranska kuhinja");
		restoran2.setBroj_stolova(20);
		em.persist(restoran2);

		Restoran restoran3 = new Restoran();
		restoran3.setNaziv("Fontana");
		restoran3.setOpis("Morska");
		restoran3.setBroj_stolova(20);
		em.persist(restoran3);

		Jelovnik jelovnik1 = new Jelovnik();
		jelovnik1.setNaziv("Meni1");
		em.persist(jelovnik1);

		Jelovnik jelovnik2 = new Jelovnik();
		jelovnik2.setNaziv("Meni2");
		em.persist(jelovnik2);

		Jelovnik jelovnik3 = new Jelovnik();
		jelovnik3.setNaziv("Meni3");
		em.persist(jelovnik3);

		Set<Jelovnik> meni = new HashSet<Jelovnik>();
		meni.add(jelovnik1);
		meni.add(jelovnik3);
		meni.add(jelovnik2);

		Set<Jelovnik> meni1 = new HashSet<Jelovnik>();
		meni1.add(jelovnik1);
		meni1.add(jelovnik2);

		Set<Jelovnik> meni2 = new HashSet<Jelovnik>();
		meni2.add(jelovnik2);

		restoran1.setJelovnik(meni);
		restoran2.setJelovnik(meni1);
		restoran3.setJelovnik(meni2);

		Jelo jelo1 = new Jelo();
		jelo1.setNaziv("Sarmica od zelja");
		jelo1.setOpis("Sarma sa zeljem");
		jelo1.setCena(530.00);
		//jelo1.setJelovnik(jelovnik1);
		em.persist(jelo1);

		Jelo jelo2 = new Jelo();
		jelo2.setNaziv("Pasulj");
		jelo2.setOpis("Corbast pasulj");
		jelo2.setCena(300.00);
		//jelo2.setJelovnik(jelovnik1);
		em.persist(jelo2);

		Jelo jelo3 = new Jelo();
		jelo3.setNaziv("Taljata");
		jelo3.setOpis("Taljata");
		jelo3.setCena(890.00);
		//jelo3.setJelovnik(jelovnik1);
		em.persist(jelo3);

		Jelo jelo4 = new Jelo();
		jelo4.setNaziv("Kiseli krastavac");
		jelo4.setOpis("Kiseli krastavac");
		jelo4.setCena(150.00);
		//jelo4.setJelovnik(jelovnik2);
		em.persist(jelo4);

		Jelo jelo5 = new Jelo();
		jelo5.setNaziv("Orasnica");
		jelo5.setOpis("Orasnica");
		jelo5.setCena(120.00);
		//jelo5.setJelovnik(jelovnik2);
		em.persist(jelo5);

		Jelo jelo6 = new Jelo();
		jelo6.setNaziv("Strudla");
		jelo6.setOpis("Strudla");
		jelo6.setCena(160.00);
		//jelo6.setJelovnik(jelovnik2);
		em.persist(jelo6);

		Jelo jelo7 = new Jelo();
		jelo7.setNaziv("Teletina ispod saca");
		jelo7.setOpis("Teletina ispod saca");
		jelo7.setCena(2100.00);
		//jelo7.setJelovnik(jelovnik3);
		em.persist(jelo7);

		Jelo jelo8 = new Jelo();
		jelo8.setNaziv("Lignje na zaru");
		jelo8.setOpis("Lignje na zaru");
		jelo8.setCena(900.00);
		//jelo8.setJelovnik(jelovnik3);
		em.persist(jelo8);

		Jelo jelo9 = new Jelo();
		jelo9.setNaziv("Morovicki tanjir");
		jelo9.setOpis("Morovicki tanjir");
		jelo9.setCena(1099.00);
		//jelo9.setJelovnik(jelovnik3);
		em.persist(jelo9);

		Jelo jelo10 = new Jelo();
		jelo10.setNaziv("Domaca supa");
		jelo10.setOpis("Domaca supa");
		jelo10.setCena(250.00);
		//jelo10.setJelovnik(jelovnik3);
		em.persist(jelo10);

	}
}