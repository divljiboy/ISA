package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;

public class KonfiguracijaMesta extends HttpServlet {

	private static final long serialVersionUID = -768414798218043830L;

	@EJB
	RestoranDaoLocal restoranDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String restoran_id = req.getParameter("id");
		Restoran r = restoranDao.findById(Integer.parseInt(restoran_id));
		
		req.setAttribute("editRestoran", r);
		getServletContext().getRequestDispatcher("/kofiguracijaMesta.jsp").forward(req, resp);
		
	}
	
	
}
