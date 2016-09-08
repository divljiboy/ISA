package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;
import java.util.Properties;

import javax.ejb.EJB;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.GostDaoLocal;



/**
 * 
 * @author 
 *
 */
public class RegisterGostController extends HttpServlet {

	private static final long serialVersionUID = -8188291444621503421L;

	@EJB
	private GostDaoLocal gostDao;

	@SuppressWarnings("static-access")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String username = null;
		String password = null;
		String password2 = null;

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

		Gost gost = null;
			

		
		if(password!=null && password2!=null && password.equals(password2) && username!=null){
			gost = new Gost();
			gost.setFirstName("user");
			gost.setLastName("user");
			gost.setUsername(username);
			gost.setPassword(password);
		}
		
		
	
		String to = username;
		final String pass = "borivoje92";		
		final String from = "borkoars@gmail.com";
		
		Properties properties = System.getProperties();
		
		String host = "smtp.gmail.com";
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.ssl.trust", host);
		properties.put("mail.smtp.user", from);
		properties.put("mail.smtp.password", pass);
		properties.put("mail.smtp.port", "587"); //465
		properties.put("mail.smtp.auth", "true");
		
		properties.setProperty("mail.smtp.host", host);
		
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(from, pass);
			}	
		});
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			message.setSubject("Aktivacija registracije");
			
			BodyPart messageBodyPart = new MimeBodyPart();
			
			messageBodyPart.setText("Registrovali ste se na sistem.");
			message.setText("Aktivaciju registracije mozete izvrsiti na sledecem linku: "+ "http://localhost:8080/Vezbe09/RegistracijaMejlom?username="+username+"&password="+password);
			
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from , pass);
			transport.send(message);
			transport.close();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		
		getServletContext().getRequestDispatcher("/loginKorisnik.jsp").forward(req, resp);
		
		/*
		try {
				gostDao.registraj(gost);
				getServletContext().getRequestDispatcher("/loginKorisnik.jsp").forward(req, resp);
		} catch (Exception e) {
			resp.sendRedirect("http://localhost:8080/Vezbe09/registracija.jsp?Nijeuspelo");
		}
		*/
				
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
