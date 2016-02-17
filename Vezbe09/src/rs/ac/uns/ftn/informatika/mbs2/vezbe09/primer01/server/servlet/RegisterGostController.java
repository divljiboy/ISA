package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.GostDaoLocal;

/**
 * 
 * @author Borko Arsovic
 *
 */
public class RegisterGostController extends HttpServlet {

	private static final long serialVersionUID = -8188291444621503421L;

	@EJB
	private GostDaoLocal gostDao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String username = null;
		String password = req.getParameter("lozinka");
		String password2 = req.getParameter("lozinka2");

		if ((req.getParameter("korisnickoIme") != null)
				&& !"".equals(req.getParameter("korisnickoIme"))) {
			username = req.getParameter("korisnickoIme");
		}

		if ((req.getParameter("lozinka") != null)
				&& !"".equals(req.getParameter("lozinka"))) {
			password = req.getParameter("lozinka");
		}

		if ((req.getParameter("lozinka2") != null)
				&& !"".equals(req.getParameter("lozinka2"))) {
			password2 = req.getParameter("lozinka2");
		}

		Gost gost = new Gost();
		if(username!=null){
			gost.setUsername(username);
		}
		if(password!=null && password2!=null && password==password2){
			gost.setPassword(password);
		}
				
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
