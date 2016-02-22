package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;



import java.util.HashSet;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Prijateljstvo;

/**
 * @author Borko Arsovic
 *
 */
public interface GostDaoLocal extends GenericDaoLocal<Gost, Integer> {

	 Gost findGostSaKorisnickimImenomILozinkom(String korisnickoIme,String lozinka);

	HashSet<Prijateljstvo> findPrijatelje(Gost g);
	void brisanjePrijatelja(Gost g, Gost g1);
	void registraj(Gost g);
	
	HashSet<Gost> findAllKojiMuNisuPrijatelji(Gost g);
	HashSet<Gost> pretraga(Gost g , String imeIliPrezime);
	void dodajPrijatelja(Gost g,Gost prijatelj);
}
