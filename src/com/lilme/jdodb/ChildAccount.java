package com.lilme.jdodb;

import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Serialized;
import javax.jdo.Query;

@PersistenceCapable
public class ChildAccount {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;

    @Persistent
    private String firstName;
    
    @Persistent
    private String middleInitial;

    @Persistent
    private String lastName;

    @Persistent
    private String dateOfBirth;
    
    @Persistent
    private boolean hasAllergies;
    
    @Persistent
    private int lunchGroup;
    
    @Persistent
    private String[] allergies;
    
    public ChildAccount(String firstName, String lastName, String middleInitial, String dateOfBirth, boolean hasAllergies, int lunchGroup, String[] allergies) {
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.hasAllergies = hasAllergies;
        this.lunchGroup = lunchGroup;
        this.allergies = allergies;
    }

    // Accessors for the fields. JDO doesn't use these, but your application does.

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getMiddleInitial(){
    	return middleInitial;
    }
    
    public void setMiddleInitial(String middleInitial){
    	this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDOB() {
        return dateOfBirth;
    }
    public void setDOB(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public boolean getHasAlerrgies(){
    	return hasAllergies;
    }
    public void setHasAllergies(boolean hasAllergies){
    	this.hasAllergies = hasAllergies;
    }
    public int getLunchGroup(){
    	return lunchGroup;
    }
    public void setLunchGroup(int lunchGroup){
    	this.lunchGroup = lunchGroup;
    }
    
    public String[] getAllergies(){
    	return allergies;
    }
    /** Josh's attempt for separating groups
    @SuppressWarnings("unchecked")
	public static List<ChildAccount> getChildren(int i){
    	PersistenceManager pm = PMF.get().getPersistenceManager();
		
    	List<ChildAccount> results = null;
		if (i == 4) {
			try {
				Query q = pm.newQuery(ChildAccount.class);
				q.setOrdering("lastName asc");
				results = (List<ChildAccount>) q.execute();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Child not Found");
			}
			return results;
		} else{
			try {
				Query q = pm.newQuery("javax.jdo.query.JDOQL", 
					    "SELECT FROM ChildAccount.class");
				q.setOrdering("lastName asc");
				q.declareParameters("int group");
				q.setFilter("lunchGroup == group");
				results = (List<ChildAccount>) q.execute(i);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Child not Found");
			}
			return results;
		}
    }*/
    
    @SuppressWarnings("unchecked")
	public static List<ChildAccount> getAllChild(){
    	PersistenceManager pm = PMF.get().getPersistenceManager();
		List<ChildAccount> results = null;
		try {
			Query q = pm.newQuery(ChildAccount.class);
			//q.setGrouping("lunchGroup asc");
			q.setOrdering("lastName asc");
			results = (List<ChildAccount>) q.execute();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Child not Found");
		}
		return results;
    }
}