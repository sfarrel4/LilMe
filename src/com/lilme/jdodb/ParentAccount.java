package com.lilme.jdodb;

import java.util.Date;
import javax.jdo.PersistenceManager;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent; 
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Serialized;
import javax.jdo.Query;
import java.util.List;


@PersistenceCapable
public class ParentAccount {
   ///many side of the relation ship.. a parent can only own one child....
    @Persistent
    private ChildAccount childAccount;
	
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long parentid;
    
    @Persistent
    private String firstName;
    
    @Persistent
    private String middleInitial;

    @Persistent
    private String lastName;

    @Persistent
    private String email;
    
    //constructor for Parent Account
    
    public ParentAccount(String firstName, String lastName, String middleInitial, String email) {
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.email = email;

    }

    // accessors 

    public long getParentId() {
        return parentid;
    }

    public String getFirstName() {
        return firstName;
    }
    
    public String getMiddleInitial(){
    	return middleInitial;
    }

    public String getLastName() {
        return lastName;
    }
    public String getEmail(){
		return email;
}

// mutators
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleInitial(String middleInitial){
    	this.middleInitial = middleInitial;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setEmail(String email) {
    		this.email = email;
    }
    
    @SuppressWarnings("unchecked")
	public static List<ParentAccount> getAllParent(){
    	PersistenceManager pm = PMF.get().getPersistenceManager();
		List<ParentAccount> results = null;
		try {
			Query q = pm.newQuery(ParentAccount.class);
			q.setOrdering("lastName asc");
			results = (List<ParentAccount>) q.execute();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Parent not Found");
		}
		return results;
    }

}
