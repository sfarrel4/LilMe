package com.lilme;

import java.io.IOException;
import java.util.*;
import java.text.*;

import javax.jdo.PersistenceManager;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lilme.jdodb.PMF;
import com.lilme.jdodb.ParentAccount;

public class SendUpdateServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doPost(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		String redirectURL = req.getParameter("url");
		String email = null;
		List<ParentAccount> parents = ParentAccount.getAllParent();
		
		Date today = new Date();
		SimpleDateFormat df = new SimpleDateFormat("MM.dd.yyyy");
		
		for (int i = 0; i < parents.size(); i++){
			 email = parents.get(i).getEmail();
			Properties props = new Properties();
			Session session = Session.getDefaultInstance(props, null);
			
			String htmlBody = "<!DOCTYPE html>"
					+ "<html>"
					+ "<head>"
					+ "<title> </title>"
					+ "</head>"
					+ "<body>"
						+ "<h1>" + subject + "</h1>"
						+ "<p>Today's Date: "+ df.format(today) + "</p>"
						+ " <br>"
						+ "<p>Message as follows: </b> <br />"+ content + "</p><br />"
						+ "From: Lil Me Daycare"
					+ "</body>"
					+ "</html>";        
	       
			Multipart mp = new MimeMultipart();

			MimeBodyPart htmlPart = new MimeBodyPart();
	    
			try{
				Message msg = new MimeMessage(session);
				msg.setFrom(new InternetAddress("ait390s1503josh@gmail.com", "Lil' Me Daycare"));
				msg.addRecipient(Message.RecipientType.TO, 
					new InternetAddress(email, "Parent"));
				msg.setSubject(subject);
				htmlPart.setContent(htmlBody, "text/html");
				mp.addBodyPart(htmlPart);
				msg.setContent(mp);
				Transport.send(msg);
			}
			catch(Exception f){
				f.printStackTrace();
			}
			resp.sendRedirect(redirectURL);
		}
	}
}
