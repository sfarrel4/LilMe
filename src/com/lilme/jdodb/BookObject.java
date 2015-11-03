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
	    
	   // @Persistent
	   // private Blob bookImage;
	    @Persistent
	    private String bookImageURL;
	    
	    public BookObject(String bookTitle, String bookSynop, String bookImageURL){
	    	this.bookTitle = bookTitle;
	    	this.bookSynop = bookSynop;
	    	//this.bookImage = bookImage;
	    	this.bookImageURL = bookImageURL;
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
	    
	    public String getBookImage(){
	    	return bookImageURL;
	    }
	    
	    public void setBookImage(String bookImage){
	    	this.bookImageURL = bookImage;
	    }
}
