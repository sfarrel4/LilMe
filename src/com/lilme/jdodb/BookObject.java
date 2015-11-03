package com.lilme.jdodb;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
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
	    private String bookAuthor;
	    
	    @Persistent
	    private String bookSynop;
	    
	    @Persistent
	    private String bookLessons;
	    
	    @Persistent
	    private String bookQuestions;
	    
	    @Persistent
	    private String bookImage;
	    
	    public BookObject(String bookTitle, String bookAuthor, String bookSynop, String bookLessons, String bookQuestions, String bookImage){
	    	this.bookTitle = bookTitle;
	    	this.bookAuthor = bookAuthor;
	    	this.bookSynop = bookSynop;
	    	this.bookLessons = bookLessons;
	    	this.bookQuestions = bookQuestions;
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
	    
	    public String getBookAuthor(){
	    	return bookTitle;
	    }
	    
	    public void setBookAuthor(String bookAuthor){
	    	this.bookAuthor = bookAuthor;
	    }
	    
	    public String getBookSynop(){
	    	return bookSynop;
	    }
	    
	    public void setBookSynop(String bookSynop){
	    	this.bookSynop = bookSynop;
	    }
	    
	    public String getBookLessons(){
	    	return bookLessons;
	    }
	    
	    public void setBookLessons(String bookLessons){
	    	this.bookLessons = bookLessons;
	    }
	    
	    public String getBookQuestions(){
	    	return bookQuestions;
	    }
	    
	    public void setBookQuestions(String bookQuestions){
	    	this.bookQuestions = bookQuestions;
	    }
	    
	    public String getBookImage(){
	    	return bookImage;
	    }
	    
	    public void setBookImage(String bookImage){
	    	this.bookImage = bookImage;
	    }
	    
	    @SuppressWarnings("unchecked")
		public static List<BookObject> getAllBooks(){
	    	PersistenceManager pm = PMF.get().getPersistenceManager();
			List<BookObject> results = null;
			try {
				Query q = pm.newQuery(BookObject.class);
				q.setOrdering("bookTitle asc");
				results = (List<BookObject>) q.execute();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Books not Found");
			}
			return results;
	    }
}
