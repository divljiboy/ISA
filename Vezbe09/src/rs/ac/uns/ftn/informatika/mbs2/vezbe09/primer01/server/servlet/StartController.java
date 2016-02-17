package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.GostDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.JeloDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.JelovnikDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.ManagerDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;



/**
 * 
 * @author Borko Arsovic
 *
 */
public class StartController extends HttpServlet {

	private static final long serialVersionUID = 5983923526687924025L;

	
	@EJB
	RestoranDaoLocal restoranDao;
	
	@EJB
	GostDaoLocal gostDao;
	
	@EJB
	ManagerDaoLocal managerDao;
	
	@EJB
	JeloDaoLocal jeloDao;
	
	@EJB
	JelovnikDaoLocal jelovnikDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {


	getServletContext().setAttribute("jela", jeloDao.findAll());		
	getServletContext().setAttribute("jelovnici", jelovnikDao.findAll());		

	getServletContext().setAttribute("menadzeri", managerDao.findAll());		
	getServletContext().setAttribute("korisnici", gostDao.findAll());
	getServletContext().setAttribute("restorani", restoranDao.findAll());
	getServletContext().getRequestDispatcher("/start.jsp").forward(req, resp);
			
}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
