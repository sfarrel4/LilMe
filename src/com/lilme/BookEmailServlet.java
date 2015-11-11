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

import com.lilme.jdodb.BookObject;
import com.lilme.jdodb.BookAssignment;
import com.lilme.jdodb.ChildAccount;
import com.lilme.jdodb.PMF;
import com.lilme.jdodb.ParentAccount;

public class BookEmailServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doPost(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String[] children = req.getParameterValues("childID");
		String[] books = req.getParameterValues("bookID");
		Long[] childIDs = new Long[children.length];
		Long[] bookIDs = new Long[books.length];
		List<ParentAccount> parents = ParentAccount.getAllParent();
		List<BookAssignment> allAssigned = BookAssignment.getAllAssigned();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		//Date comparison variables
		Date today = new Date();
		SimpleDateFormat df = new SimpleDateFormat("MM.dd.yyyy");
		
		//Strings needed for e-mail content
		String bookTitle = null;
		String bookAuthor = null;
		String bookSum = null;
		String bookLessons = null;
		String bookQuestions = null;
		String bookImageUrl = null;
		String childName = null;
		
		
		
		//convert child ID into long
		for (int a = 0; a < children.length; a++){
			childIDs[a] = Long.parseLong(children[a]);
		}
		//convert book ID into long
		for (int b = 0; b < books.length; b++){
			if (books[b] != null){
				bookIDs[b] = Long.parseLong(books[b]);
			}
		}
		//make entry that the child[c] read book[c]
		for (int c = 0; c < childIDs.length; c++){
			if (allAssigned.get(c).getChildID() != childIDs[c] && df.format(allAssigned.get(c).getReadDate()).equals( df.format(new Date())) && bookIDs[c] != null){
				BookAssignment b = new BookAssignment(childIDs[c], bookIDs[c]);

				try{
					pm.makePersistent(b);
				}
				finally{
					pm.close();
				}
			}
		}
		//send emails that the children[d] read books[d]
		for (int d = 0; d < childIDs.length; d++){
			if(bookIDs[d] != null){
				for (int e = 0; e < parents.size(); e++){
					if (parents.get(e).getChildID() == childIDs[d]){
						BookObject book = pm.getObjectById(BookObject.class, bookIDs[d]);
						ChildAccount child = pm.getObjectById(ChildAccount.class, childIDs[d]);
						String email = parents.get(e).getEmail();
						bookTitle = book.getBookTitle();
						bookAuthor = book.getBookAuthor();
						bookSum = book.getBookSynop();
						bookLessons = book.getBookLessons();
						bookQuestions = book.getBookQuestions();
						bookImageUrl = book.getBookImage();
						childName = child.getFirstName() + " " + child.getMiddleInitial() + " " + child.getLastName();
						
						Properties props = new Properties();
						Session session = Session.getDefaultInstance(props, null);
						
							String htmlBody = "<!DOCTYPE html>"
									+ "<html>"
									+ "<head>"
									+ "<title> </title>"
									+ "</head>"
									+ "<body>"
										+ "<h1>Reading History for your child:  "+ childName + "</h1>"
										+ "<p>Date of reading: "+ df.format(today) + "</p>"
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
							msg.setFrom(new InternetAddress("ait390s1503josh@gmail.com", "Lil' Me Daycare"));
							msg.addRecipient(Message.RecipientType.TO, 
									new InternetAddress(email, "Parent"));
							msg.setSubject("Take a look at what your child read today");
							htmlPart.setContent(htmlBody, "text/html");
						    mp.addBodyPart(htmlPart);
						    msg.setContent(mp);
							Transport.send(msg);
							
						}
						catch(Exception f){
							f.printStackTrace();
						}
						resp.sendRedirect("index.html");
					}
				}
			}
		}
	}

}
