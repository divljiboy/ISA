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
public class RezervacijaController extends HttpServlet {

	private static final long serialVersionUID = -280662383637566334L;

	@EJB
	RestoranDaoLocal restoranDao;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		String restoran_i = req.getParameter("id");
		Integer restorani_id = Integer.parseInt(restoran_i);
		

		Restoran restoran = restoranDao.findById(restorani_id);
		req.setAttribute("restoranRezervacija", restoran);
		getServletContext().getRequestDispatcher("/rezervacija.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}
}
