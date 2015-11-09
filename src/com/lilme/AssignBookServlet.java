package com.lilme;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;
import java.util.List;

import com.lilme.jdodb.BookAssignment;
import com.lilme.jdodb.ChildAccount;
import com.lilme.jdodb.PMF;

public class AssignBookServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doPost(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String childIDNum = req.getParameter("childID");
		String bookIDNum = req.getParameter("bookID");
		String[] validTest = {childIDNum, bookIDNum};
		boolean validEntry = isEmpty(validTest);
		
		Long childID = Long.parseLong(childIDNum);
		Long bookID = Long.parseLong(bookIDNum);
		
		List<BookAssignment> allAssigned = BookAssignment.getAllAssigned();
		boolean notExists = true;
		Date todaysDate = new Date();
		
		for (int i = 0; i < allAssigned.size(); i++){
			if (childID == allAssigned.get(i).getChildID() && todaysDate == allAssigned.get(i).getReadDate()){
				notExists = false;
				i += allAssigned.size();
			}
		}
		
		if (validEntry == false && notExists){
			PersistenceManager pm = PMF.get().getPersistenceManager();
			BookAssignment b = new BookAssignment(childID, bookID);

			try{
				pm.makePersistent(b);
			}
			finally{
				pm.close();
			}
			resp.sendRedirect("AssignBook.jsp");
		} else {
			resp.sendRedirect("AssignBook.jsp");
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
