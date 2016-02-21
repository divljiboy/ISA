package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.awt.Menu;
import java.util.List;
import java.util.Set;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelovnik;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Manager;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;

public interface RestoranDaoLocal extends GenericDaoLocal<Restoran, Integer> {

	
	Set<Jelovnik> findMeniuRestoranu(Restoran r);
	List<Manager> ucitajMenadzera(Restoran r);
	 void dodajMeni(Restoran r,Jelovnik m);
	 void izbrisiMeni(Restoran r,Jelovnik m);
	 Set<Jelovnik> findAllKojiNisu(Restoran g,List<Jelovnik> ab);
}
