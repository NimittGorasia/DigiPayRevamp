package com.Digipaywallet.DigiPayWalletRevamp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the book_details database table.
 * 
 */
@Entity
@Table(name="book_details")
@NamedQuery(name="BookDetail.findAll", query="SELECT b FROM BookDetail b")
public class BookDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "books_generator")
	@SequenceGenerator(name="books_generator",sequenceName = "book_details_seq", allocationSize = 1)
	@Column(name="book_id")
	private long bookId;

	private String author;

	@Column(name="created_on")
	private Date createdOn;

	private String description;

	private String genre;

	private String image;

	private double price;

	private String title;

	public BookDetail() {
		//default entity
	}

	public long getBookId() {
		return this.bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}