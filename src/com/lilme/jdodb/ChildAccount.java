package com.lilme.jdodb;

import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
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
    private Date dateOfBirth;
    
    @Persistent
    private boolean hasAllergies;
    
    @Persistent
    private int lunchGroup;
    /*
    @Persistent 
    private String[] allergies;
    */
    public ChildAccount(String firstName, String lastName, String middleInitial, Date dateOfBirth, boolean hasAllergies, int lunchGroup) {
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.hasAllergies = hasAllergies;
        this.lunchGroup = lunchGroup;
        //this.allergies = allergies;
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

    public Date getDOB() {
        return dateOfBirth;
    }
    public void setDOB(Date dateOfBirth) {
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
    /*
    public String[] getAllergies(){
    	return allergies;
    }
    */
    @SuppressWarnings("unchecked")
	public static List<ChildAccount> getAllChild(){
    	PersistenceManager pm = PMF.get().getPersistenceManager();
		List<ChildAccount> results = null;
		try {

			//Query q = pm.newQuery("SELECT * FROM ChildAccount");
			Query q = pm.newQuery(ChildAccount.class);
			//q.setOrdering("name asc");

			results = (List<ChildAccount>) q.execute();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Child not Found");
		}
		return results;
    }
    
}