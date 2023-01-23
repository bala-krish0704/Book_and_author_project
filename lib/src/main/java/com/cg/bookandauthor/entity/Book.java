package com.cg.bookandauthor.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Book")

public class Book {
	@Id
	@Column(name = "authorid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int author_id;
	@Column(name = "bookid")
	private int book_id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "date")
	private String date;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "author_id")
	private Author author;
	

	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String string) {
		this.date = string;
	}
	public Book(int book_id, String title, String description, String date, int author_id) {
		super();
		this.book_id = book_id;
		this.title = title;
		this.description = description;
		this.date = date;
		this.author_id = author_id;
	}
	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", title=" + title + ", description=" + description + ", date=" + date
				+ ", author_id=" + author_id + "]";
	}

	
	

}
