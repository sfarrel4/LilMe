package com.lilme.jdodb;

import java.util.List;
import java.util.Date;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable
public class BookAssignment {
	
	 @PrimaryKey
	    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	    private Long id;
	    
	    @Persistent
	    private Long childID;
	    
	    @Persistent
	    private Long bookID;
	    
	    @Persistent
	    private Date  readDate;
	  
	    
	    public BookAssignment(Long childID, Long bookID){
	    	this.childID = childID;
	    	this.bookID = bookID;
	    	this.readDate =  new Date();

	    }
	    
	    public Long getID() {
	        return id;
	    }
	    
	    public Long getChildID(){
	    	return childID;
	    }
	    
	    public Long getBookID(){
	    	return bookID;
	    }
	    public Date getReadDate(){
	    	return readDate;
	    }
	    
	    public void setID(Long id){
	    	this.id= id;
	    }
	    
	    public void setChildID(Long childID){
	    	this.childID = childID   ;
	    }
	    
	    public void setBookID(Long bookID){
	    	this.bookID = bookID   ;
	    }
	    
	    

	    @SuppressWarnings("unchecked")
		public static List<BookAssignment> getAllAssigned(){
	    	PersistenceManager pm = PMF.get().getPersistenceManager();
			List<BookAssignment> results = null;
			try {
				Query q = pm.newQuery(BookAssignment.class);
				q.setOrdering("readDate asc");
				results = (List<BookAssignment>) q.execute();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Book Assignment not Found");
			}
			return results;
	    }
}
