package com.lilme.jdodb;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Blob;

@PersistenceCapable
public class BookObject {
	
	 @PrimaryKey
	    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	    private Long id;
	    
	    @Persistent
	    private String bookTitle;
	    
	    @Persistent
	    private String bookSynop;
	    
	    @Persistent
	    private Blob bookImage;
	    
	    public BookObject(String bookTitle, String bookSynop, Blob bookImage){
	    	this.bookTitle = bookTitle;
	    	this.bookSynop = bookSynop;
	    	this.bookImage = bookImage;
	    }
	    
	    public Long getId() {
	        return id;
	    }
	    
	    public String getBookTitle(){
	    	return bookTitle;
	    }
	    
	    public void setBookTitle(String bookTitle){
	    	this.bookTitle = bookTitle;
	    }
	    
	    public String getBookSynop(){
	    	return bookSynop;
	    }
	    
	    public void setBookSynop(String bookSynop){
	    	this.bookSynop = bookSynop;
	    }
	    
	    public Blob getBookImage(){
	    	return bookImage;
	    }
	    
	    public void setBookImage(Blob bookImage){
	    	this.bookImage = bookImage;
	    }
}
