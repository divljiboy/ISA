package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.List;

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
	public List<Jelovnik> findMeniuRestoranu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Manager> ucitajMenadzera(Restoran r) {
		
		return null;
	}



	
}
