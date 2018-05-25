package selfCase;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		/*int i=Integer.parseInt(request.getParameter("a"));
		int j=Integer.parseInt(request.getParameter("b"));
		int k= i+j;*/
		/*HttpSession  session= request.getSession();
		
		String str = (String) session.getAttribute("t1");
		String str2 = (String) session.getAttribute("t2");
		

		
		Cookie cookies[] = request.getCookies();
		
		String str = "null";
		String str2 = "null";
		
		for(Cookie c :cookies)
		{
			if(c.getName().equals("t1"))
			{
				str = c.getValue();
			}
			if(c.getName().equals("t2"))
			{
				str2 = c.getValue();
			}
			
		}*/
		StoreToJdbc storeToJdbc = new StoreToJdbc();
		String fromAddr = "sangeethsudhakar94@gmail.com";
		String toAddr = request.getParameter("a");
		final String userName = "sangeethsudhakar94@gmail.com";
		final String password = "mammootty@1";
		String subject = request.getParameter("b");
		String text = request.getParameter("c");
		
		MailDetails mailDetails = new MailDetails(toAddr,subject,text);
		try {
			storeToJdbc.saveMailDetails(mailDetails);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Properties prop = new Properties();
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.put("mail.smtp.socketFactory.port", "465");

		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromAddr));
			message.setRecipients(RecipientType.TO, InternetAddress.parse(toAddr));
			message.setSubject(subject);
			message.setText(text);

			Transport.send(message);
			System.out.println("Sent!");
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	

		PrintWriter out = response.getWriter();
		out.print("email sent");
		
	}

}
