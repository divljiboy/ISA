package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Manager;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Sto;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;

public class KonfiguracijaMesta1 extends HttpServlet {

	private static final long serialVersionUID = 8062238015408642108L;

	@EJB
	RestoranDaoLocal restoranDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		
		HttpSession session = req.getSession();
		
		if(session.getAttribute("menadzer")!=null){
			Manager m = (Manager) session.getAttribute("menadzer");
			Sto sto = null;
			String red = req.getParameter("red");
			String kolona = req.getParameter("kolona");
			
			System.out.println("usao");
			System.out.println(red);
			System.out.println(kolona);
			
			if(red!=null && kolona !=null){
				sto = new Sto();
				sto.setBroj(1);
				sto.setPozicija(red+"+"+kolona);
			}
			
		//	restoranDao.addSto(m.getRestoran(),sto);
			
			session.setAttribute("restoran", m.getRestoran());
			getServletContext().getRequestDispatcher("/konfiguracijaMesta.jsp").forward(req, resp);
		}
	}
}
