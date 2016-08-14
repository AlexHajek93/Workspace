package com.revature.beans;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="UOP_TEXTBOOK")
public class Textbook {
	@Id
	@Column(name="BOOK_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="ISBN")
	private String isbn;
	@Column(name="TITLE")
	private String title;
	@Column(name="AUTHORS_NAME")
	private String author;
	@Column(name="YEAR")
	private int publishYear;
	//Mapping
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="materials")
	private Set<Course> courses;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPublishYear() {
		return publishYear;
	}
	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	public Textbook() {
		super();
	}
	public Textbook(int id, String isbn, String title, String author, int publishYear, Set<Course> courses) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publishYear = publishYear;
		this.courses = courses;
	}
	
}
