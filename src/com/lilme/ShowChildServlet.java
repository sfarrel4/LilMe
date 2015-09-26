package com.lilme;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.jdo.Query;

import java.util.ArrayList;
import java.util.List;

import com.lilme.jdodb.ChildAccount;
import com.lilme.jdodb.PMF;

@SuppressWarnings("serial")
public class ShowChildServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		List<ChildAccount> childAccountList = getChildAccounts();
		List<String> firstNameList = new ArrayList<String>();
		
		for(int i=0; i<= childAccountList.size(); i++){
			firstNameList.add(childAccountList.get(i).getFirstName());
		}
		req.setAttribute("firstNameList", firstNameList);
		getServletConfig().getServletContext().getRequestDispatcher("/ShowChild.jsp").forward(req,resp);
		

	}
	
	@SuppressWarnings("unchecked")
	public List<ChildAccount> getChildAccounts(){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		List<ChildAccount> firstName = null;
	
		Query q = null;
		try{
			q = pm.newQuery("javax.jdo.query.SQL", "Select * from ChildAccount");
			q.setClass(ChildAccount.class);
			firstName = (List<ChildAccount>) q.execute();
			
		}
		finally{
			q.closeAll();
			pm.close();
		}
		return firstName;
	}
}
