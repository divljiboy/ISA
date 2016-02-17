package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Manager;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.ManagerDaoLocal;

/**
 * 
 * @author Borko Arsovic
 *
 */
public class DodajMenadzeraController extends HttpServlet {

	private static final long serialVersionUID = 6278961766489300238L;

	@EJB
	ManagerDaoLocal managerDao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String menadzer_id = req.getParameter("id");
		Integer restoran_id = Integer.parseInt(menadzer_id);
		if (restoran_id != null) {
			Manager manager = managerDao.findById(restoran_id);
			managerDao.remove(manager);
			System.out.println(manager.getFirstName());
		}
		

		getServletContext().setAttribute("menadzeri", managerDao.findAll());
		getServletContext().getRequestDispatcher("/menadzeri.jsp").forward(req,
				resp);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String ime = null;
		String prezime = null;
		String username = null;
		String sifra = null;
		Manager manager = null;

		if (req.getParameter("ime_menadzera") != null
				&& !req.getParameter("ime_menadzera").equals("")) {
			ime = req.getParameter("ime_menadzera");
		}
		if (req.getParameter("prezime_menadzera") != null
				&& !req.getParameter("prezime_menadzera").equals("")) {
			prezime = req.getParameter("prezime_menadzera");
		}
		if (req.getParameter("korisnicko_ime") != null
				&& !req.getParameter("korisnicko_ime").equals("")) {
			username = req.getParameter("korisnicko_ime");
		}
		if (req.getParameter("lozinka") != null
				&& !req.getParameter("lozinka").equals("")) {
			sifra = req.getParameter("lozinka");
		}

		if (ime != null && prezime != null && username != null && sifra != null) {
			manager = new Manager();
			manager.setFirstName(ime);
			manager.setLastName(prezime);
			manager.setUsername(username);
			manager.setPassword(sifra);
		}

		try {
			if (!managerDao.findAll().contains(manager)) {
				managerDao.persist(manager);
				getServletContext().setAttribute("menadzeri",
						managerDao.findAll());
				getServletContext().getRequestDispatcher("/menadzeri.jsp")
						.forward(req, resp);
			}
		} catch (Exception e) {
			resp.sendRedirect("http://localhost:8080/Vezbe09/menadzeri.jsp?Nijeuspelo");
		}

	};
}
