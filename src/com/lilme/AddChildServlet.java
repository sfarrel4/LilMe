package com.lilme;

import java.io.IOException;
import java.util.Date;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lilme.jdodb.*;

@SuppressWarnings("serial")
public class AddChildServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doPost(req, resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String firstName = req.getParameter("firstName");
		String middleInitial = req.getParameter("middleInitial");
		String lastName = req.getParameter("lastName");
		String DOBMonth = req.getParameter("DOBMonth");
		String DOBDay = req.getParameter("DOBDay");
		String DOBYear = req.getParameter("DOBYear");
		String lunchTest = req.getParameter("lunchGroup");
		boolean hasAllergies = false;

		String dateOfBirth = DOBMonth + "/" + DOBDay + "/" + DOBYear;
		String[] allergies = req.getParameterValues("allergies");

		if (allergies != null){
			hasAllergies = true;
		}

		int lunchGroup = Integer.parseInt(req.getParameter("lunchGroup"));

		String[] validTest = {firstName, lastName, DOBMonth, DOBDay, DOBYear, lunchTest};
		boolean validEntry = isEmpty(validTest);
		if (validEntry == false){
			PersistenceManager pm = PMF.get().getPersistenceManager();
			ChildAccount c = new ChildAccount(firstName, lastName, middleInitial, dateOfBirth, hasAllergies, lunchGroup, allergies);

			try{
				pm.makePersistent(c);
			}
			finally{
				pm.close();
			}
			resp.sendRedirect("CreateChild.jsp");
		} else {
			resp.sendRedirect("CreateChild.jsp");
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