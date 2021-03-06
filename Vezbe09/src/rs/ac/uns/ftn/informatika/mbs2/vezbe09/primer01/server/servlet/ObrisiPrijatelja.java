package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.GostDaoLocal;


/**
 * 
 * @author 
 *
 */
public class ObrisiPrijatelja extends HttpServlet {

	private static final long serialVersionUID = -7354193966836426632L;

	@EJB
	GostDaoLocal gostDao;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpSession session = req.getSession();
		if(session.getAttribute("gost")!=null){
			Gost gost = (Gost) session.getAttribute("gost");
			String deletePrijatelj = req.getParameter("id");
			
			Gost prijateljZaBrisanje = gostDao.findById(Integer.parseInt(deletePrijatelj));
			gostDao.brisanjePrijatelja(gost , prijateljZaBrisanje);
			Set<Gost> prijateji = gostDao.findPrijatelje(gost);
			Set<Gost> mogucaResenja = gostDao.findAllKojiMuNisuPrijatelji(gost);
			req.setAttribute("nisuprijatelji", mogucaResenja);
			session.setAttribute("prijatelji", prijateji);
			getServletContext().getRequestDispatcher("/prijatelji.jsp").forward(req, resp);
		}
	}
	
}
