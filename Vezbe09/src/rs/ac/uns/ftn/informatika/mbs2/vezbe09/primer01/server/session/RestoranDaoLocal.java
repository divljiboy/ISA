package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.List;
import java.util.Set;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelovnik;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Manager;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;

public interface RestoranDaoLocal extends GenericDaoLocal<Restoran, Integer> {

	
	Set<Jelovnik> findMeniuRestoranu(Restoran r);
	List<Manager> ucitajMenadzera(Restoran r);
}
