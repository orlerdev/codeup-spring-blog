package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.List;

@Entity
@Table(name="posts")
public class Post{
//    /////////////////////////
//    TABLE CREATION
//    /////////////////////////
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;
@Column(nullable=false, length=500)
private String title;
@Column(nullable=false, length=500)
private String body;
@OneToOne(cascade=CascadeType.PERSIST)
@JoinColumn(name="user_id")
private User user;
@OneToMany(cascade=CascadeType.PERSIST)
private List<Comment> comments;

//    /////////////////////////
//    CONSTRUCTORS(EMPTY, OBJECT WITH NO ID, FULL OBJECT, FULL OBJECT WITH FOREIGN KEY)
//    /////////////////////////
public Post(){}

public Post(String title, String body){
	this.title = title;
	this.body = body;
}

public Post(long id, String title, String body){
	this.id = id;
	this.title = title;
	this.body = body;
}

public Post(String title, String body, User user){
	this.title = title;
	this.body = body;
	this.user = user;
}

public Post(long id, String title, String body, User user){
	this.id = id;
	this.title = title;
	this.body = body;
	this.user = user;
}

public Post(long id, String title, String body, User user, List<Comment> comments){
	this.id = id;
	this.title = title;
	this.body = body;
	this.user = user;
	this.comments = comments;
}

//    /////////////////////////
//    GETTERS AND SETTERS
//    /////////////////////////
public long getId(){
	return id;
}

public void setId(long id){
	this.id = id;
}

public String getTitle(){
	return title;
}

public void setTitle(String title){
	this.title = title;
}

public String getBody(){
	return body;
}

public void setBody(String body){
	this.body = body;
}

public User getUser(){
	return user;
}

public void setUser(User user){
	this.user = user;
}

public List<Comment> getComments(){
	return comments;
}

public void setComments(List<Comment> comments){
	this.comments = comments;
}
}
