package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;



import java.util.List;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;

/**
 * 
 * @author Borko Arsovic
 *
 */
public interface GostDaoLocal extends GenericDaoLocal<Gost, Integer> {

	 Gost findGostSaKorisnickimImenomILozinkom(String korisnickoIme,String lozinka);
	 List<Gost> findPrijatelje(int gostId);
}
