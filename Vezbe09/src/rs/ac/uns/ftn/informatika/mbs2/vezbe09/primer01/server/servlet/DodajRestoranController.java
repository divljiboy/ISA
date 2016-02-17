package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;

/**
 * 
 * @author Borko Arsovic
 *
 */
public class DodajRestoranController extends HttpServlet {

	private static final long serialVersionUID = -3563896427589397605L;

	@EJB
	RestoranDaoLocal restoranDao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String ime = null;
		String opis = null;
		Integer brStolova = null;
		Restoran restoran = null;
		
		if (req.getParameter("ime_restorana") != null
				&& !req.getParameter("ime_restorana").equals("")) {
			ime = req.getParameter("ime_restorana");
		}
		if (req.getParameter("opis_restorana") != null
				&& !req.getParameter("opis_restorana").equals("")) {
			opis = req.getParameter("opis_restorana");
		}
		if (req.getParameter("br_stolova") != null
				&& !req.getParameter("br_stolova").equals("")) {
			brStolova = Integer.parseInt(req.getParameter("br_stolova"));
		}

		if (ime != null && opis != null && brStolova != null) {
			restoran = new Restoran();
			restoran.setNaziv(ime);
			restoran.setOpis(opis);
			restoran.setBroj_stolova(brStolova);
		}
		
		
		try {
			if (!restoranDao.findAll().contains(restoran)) {
				restoranDao.persist(restoran);
				getServletContext().setAttribute("restorani", restoranDao.findAll());
				getServletContext().getRequestDispatcher("/restorani.jsp").forward(req, resp);
			}
		} catch (Exception e) {
		//	getServletContext().getRequestDispatcher("/restorani.jsp?UpisNijeUspeo").forward(req, resp);
			resp.sendRedirect("http://localhost:8080/Vezbe09/restorani.jsp?Nijeuspelo");
			
		}
		
		

	}
}
