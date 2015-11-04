package com.lilme;

import java.io.IOException;
import java.util.Properties;

import javax.jdo.PersistenceManager;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lilme.jdodb.BookObject;
import com.lilme.jdodb.PMF;
import com.lilme.jdodb.ParentAccount;

public class EmailBookServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doPost(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String email = req.getParameter("email");
		Long bookID = Long.valueOf(req.getParameter("book"));
		
		String bookTitle = null;
		String bookImageUrl = null;
	
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		try{
			BookObject b = pm.getObjectById(BookObject.class, bookID);
			bookTitle = b.getBookTitle();
			bookImageUrl = b.getBookImage();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		
		String msgBody = "Your Child read " + bookTitle + "\n Here is a link to an image of the book: \n" + bookImageUrl  ;
		
		try{
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("ait390s1503stephen@gmail.com", "Lil' Me Daycare"));
			msg.addRecipient(Message.RecipientType.TO, 
					new InternetAddress(email, "Parent"));
			msg.setSubject("Take a look at what your child read today");
			msg.setText(msgBody);
			Transport.send(msg);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		resp.sendRedirect("index.html");
	}

}
