package com.lilme;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lilme.jdodb.BookObject;
import com.lilme.jdodb.ChildAccount;
import com.lilme.jdodb.PMF;

public class AddBookServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doPost(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String bookTitle = req.getParameter("bookTitle");
		String bookSynop = req.getParameter("bookSynop");
		String bookImageURL = req.getParameter("bookImageURL");
		String[] validTest = {bookTitle, bookSynop, bookImageURL};
		boolean validEntry = isEmpty(validTest);
		if (validEntry == false){
			PersistenceManager pm = PMF.get().getPersistenceManager();
			BookObject b = new BookObject(bookTitle, bookSynop, bookImageURL);

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
