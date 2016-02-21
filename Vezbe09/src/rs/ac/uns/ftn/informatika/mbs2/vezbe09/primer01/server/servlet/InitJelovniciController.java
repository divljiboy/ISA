package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import javax.ejb.EJB;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Manager;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.JelovnikDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;

public class InitJelovniciController extends HttpServlet {

	private static final long serialVersionUID = -659523657390341017L;
	@EJB
	JelovnikDaoLocal jelovnikDao;
	
	@EJB
	RestoranDaoLocal restoranDao;

	protected void doGet(javax.servlet.http.HttpServletRequest req,
			javax.servlet.http.HttpServletResponse resp)
			throws javax.servlet.ServletException, java.io.IOException {

		HttpSession session = req.getSession();
		
		if(session.getAttribute("admin")!=null){
			session.setAttribute("sviJelovnici",jelovnikDao.findAll() );			
			getServletContext().getRequestDispatcher("/jelovnici.jsp").forward(req, resp);
		}
		
		if(session.getAttribute("menadzer")!=null){
			Manager m=(Manager) session.getAttribute("menadzer");
			Restoran r=m.getRestoran();
			session.setAttribute("nisuJelovnici",restoranDao.findAllKojiNisu(r, jelovnikDao.findAll()));
			session.setAttribute("sviJelovnici",jelovnikDao.findAll() );
			session.setAttribute("jelovnici",restoranDao.findMeniuRestoranu(r));
			
			getServletContext().getRequestDispatcher("/jelovnici.jsp").forward(req, resp);
		}
		
	};

}
