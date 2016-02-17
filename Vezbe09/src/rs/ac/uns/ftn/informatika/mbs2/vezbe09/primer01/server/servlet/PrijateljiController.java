package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.GostDaoLocal;

/**
 * 
 * @author Borko Arsovic
 *
 */

public class PrijateljiController extends HttpServlet {

	private static final long serialVersionUID = 8223585225422301298L;

	@EJB
	GostDaoLocal gostDao;

	protected void doGet(javax.servlet.http.HttpServletRequest req,
			javax.servlet.http.HttpServletResponse resp)
			throws javax.servlet.ServletException, java.io.IOException {

	//	HttpSession session = req.getSession();
	//	Gost g = (Gost) session.getAttribute("gost");
	//	int gost_id = g.getId();
		
		//List<Gost> prijatelji = gostDao.findPrijatelje(gost_id);
		//System.out.println(gostDao.findPrijatelje(gost_id));
		//req.setAttribute("prijatelji", prijatelji);
		getServletContext().getRequestDispatcher("/home.jsp").forward(req, resp);
		
		
	};

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
