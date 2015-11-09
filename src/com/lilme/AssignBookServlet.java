package com.lilme;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lilme.jdodb.BookObject;
import com.lilme.jdodb.ChildAccount;
import com.lilme.jdodb.PMF;

public class AssignBookServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doPost(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String bookTitle = req.getParameter("bookTitle");
		String bookAuthor = req.getParameter("bookAuthor");
		String bookSynop = req.getParameter("bookSynop");
		String bookLessons = req.getParameter("bookLessons");
		String bookQuestions = req.getParameter("bookQuestions");
		String bookImageURL = req.getParameter("bookImageURL");
		String[] validTest = {bookTitle, bookAuthor, bookSynop, bookLessons, bookQuestions, bookImageURL};
		boolean validEntry = isEmpty(validTest);
		if (validEntry == false){
			PersistenceManager pm = PMF.get().getPersistenceManager();
			BookObject b = new BookObject(bookTitle, bookAuthor, bookSynop, bookLessons, bookQuestions, bookImageURL);

			try{
				pm.makePersistent(b);
			}
			finally{
				pm.close();
			}
			resp.sendRedirect("CreateBook.jsp");
		} else {
			resp.sendRedirect("CreateBook.jsp");
		}
	}

	public boolean isEmpty(String[] s){
		boolean isEmpty = false;
		for (int i=0; i<s.length; i++) {
			if (s[i].equals("") || s[i] == null) {
				isEmpty = true;
			}
		}
		return isEmpty;
	}
		
		
	

}
