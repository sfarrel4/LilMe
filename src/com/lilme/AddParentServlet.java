package com.lilme;

import java.io.IOException;
import java.util.Date;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lilme.jdodb.*;

@SuppressWarnings("serial")
public class AddParentServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doPost(req, resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String firstName = req.getParameter("firstName");
		String middleInitial = req.getParameter("middleInitial");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");

		

		//String[] childrenList = req.getParameterValues("childrenList");   

		String[] validTest = {firstName, middleInitial, lastName, email};
		boolean validEntry = isEmpty(validTest);
		if (validEntry == false){
			PersistenceManager pm = PMF.get().getPersistenceManager();
			ParentAccount p = new ParentAccount(firstName, lastName, middleInitial, email);

			try{
				pm.makePersistent(p);
			}
			finally{
				pm.close();
			}
			resp.sendRedirect("CreateParent.jsp");
		} else {
			resp.sendRedirect("CreateParent.jsp");
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