package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import javax.ejb.Local;
import javax.ejb.Stateless;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelo;

/**
 * 
 * @author Borko Arsovic
 *
 */

@Stateless
@Local(JeloDaoLocal.class)
public class JeloDaoBean extends GenericDaoBean<Jelo, Integer> implements JeloDaoLocal{

}
