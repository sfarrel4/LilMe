package com.lilme;

import java.io.IOException;
import javax.activation.DataHandler;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
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
		String bookSum = null;
		String bookAuthor = null;
		String bookLessons = null;
		String bookQuestions = null;
		String childName = "Stephen Farrell";
		String dateRead = "11/11/2015";
		
	
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		try{
			BookObject b = pm.getObjectById(BookObject.class, bookID);
			bookTitle = b.getBookTitle();
			bookImageUrl = b.getBookImage();
			bookSum = b.getBookSynop();
			bookAuthor = b.getBookAuthor();
			bookLessons = b.getBookLessons();
			bookQuestions = b.getBookQuestions();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		
			String htmlBody = "<!DOCTYPE html>"
					+ "<html>"
					+ "<head>"
					+ "<title> </title>"
					+ "</head>"
					+ "<body>"
						+ "<h1>Reading History for your child:  "+ childName + "</h1>"
						+ "<p>Date of reading: "+ dateRead + "</p>"
						+ "<h2>Today's Book was</h2>	<br><br>"
						+ "<br>	<img src="+ bookImageUrl + " />"
						+ "<br><br><br><br>"
						+ " <br>"
						+ "<b>Title</b>: <u>"+ bookTitle + "</u><br><br>"
						+ "<b>Author</b>:" + bookAuthor + " <br><br>"
						+ "<B>Summary:</b> <br>"
						+ ""+ bookSum +" "
						+ "<b>Lessons Learned:</b><br>"
						+ "" + bookLessons + ""
						+ "<br><br>"
						+ "<b>Continue the Learning!:<br> </b>"
						+ "" + bookQuestions + ""
						+ "<br><br>"
						+ "</body>"
						+ "</html>";        
	       

	        Multipart mp = new MimeMultipart();

	        MimeBodyPart htmlPart = new MimeBodyPart();
	       
		
		//String msgBody = "Your Child read " + bookTitle + "\n Here is a link to an image of the book: \n" + bookImageUrl  ;
		
		try{
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("ait390s1503stephen@gmail.com", "Lil' Me Daycare"));
			msg.addRecipient(Message.RecipientType.TO, 
					new InternetAddress(email, "Parent"));
			msg.setSubject("Take a look at what your child read today");
			htmlPart.setContent(htmlBody, "text/html");
		    mp.addBodyPart(htmlPart);
		    msg.setContent(mp);
			Transport.send(msg);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		resp.sendRedirect("index.html");
	}

}
