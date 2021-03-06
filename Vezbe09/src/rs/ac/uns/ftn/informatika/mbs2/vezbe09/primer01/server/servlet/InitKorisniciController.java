package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.GostDaoLocal;

public class InitKorisniciController extends HttpServlet {

	private static final long serialVersionUID = -3960861046755872297L;

	@EJB
	GostDaoLocal gostDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		if(session.getAttribute("admin")!=null){
			session.setAttribute("korisniciSistema", gostDao.findAll());
			
			getServletContext().getRequestDispatcher("/prijatelji.jsp").forward(req, resp);
		}
		
	}
}
