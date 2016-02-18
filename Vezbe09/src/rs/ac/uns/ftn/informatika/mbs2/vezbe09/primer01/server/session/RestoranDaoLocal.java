package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelovnik;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Manager;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;

import java.util.List;

public interface RestoranDaoLocal extends GenericDaoLocal<Restoran, Integer> {

	
	List<Jelovnik> findMeniuRestoranu();
	List<Manager> ucitajMenadzera(Restoran r);
}
