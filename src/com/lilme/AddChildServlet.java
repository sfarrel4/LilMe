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
		 
		 @SuppressWarnings("deprecation")
		Date dateOfBirth = new Date(Integer.parseInt(DOBYear),Integer.parseInt(DOBMonth),Integer.parseInt(DOBDay));
		//String[] allergies = req.getParameterValues("allergies");
	
		 boolean hasAllergies = true;
		 int lunchGroup = Integer.parseInt(req.getParameter("lunchGroup"));
		/* for(int i = 0; i <= allergies.length; i++){
			 if(allergies[i].equals("none")){
				 hasAllergies = false;
			 }
		 }
		 */
		 
		 PersistenceManager pm = PMF.get().getPersistenceManager();
		 
		 ChildAccount c = new ChildAccount(firstName, lastName, middleInitial, dateOfBirth, hasAllergies, lunchGroup);
		
		 try{
			 pm.makePersistent(c);
		 }
		finally{
			pm.close();
		}
		
		
		
	}

}
