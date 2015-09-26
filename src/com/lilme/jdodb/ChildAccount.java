package com.lilme.jdodb;

import java.security.Key;
import java.util.Date;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class ChildAccount {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private long id;

    @Persistent
    private String firstName;
    
    @Persistent
    private char middleInitial;

    @Persistent
    private String lastName;

    @Persistent
    private Date dateOfBirth;
    
    @Persistent
    private boolean hasAllergies;
    
    @Persistent
    private int lunchGroup;
    
    @Persistent 
    private String[] allergies;

    public ChildAccount(String firstName, String lastName, char middleInitial, Date dateOfBirth, boolean hasAllergies, int lunchGroup, String[] allergies) {
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
    
    public char getMiddleInitial(){
    	return middleInitial;
    }
    
    public void setMiddleInitial(char middleInitial){
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
    
    public String[] getAllergies(){
    	return allergies;
    }
    
    
}