package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;


@Entity
@Table(name="comments")
public class Comment{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;
@Column(nullable=false, length=500)
private String content;
@OneToOne(cascade=CascadeType.PERSIST)
@JoinColumn(name="post_id")
private Post post;
@OneToOne(cascade=CascadeType.PERSIST)
@JoinColumn(name="user_id")
private User user;

//    /////////////////////////
//    GETTERS AND SETTERS
//    /////////////////////////
public long getId(){
	return id;
}

public void setId(long id){
	this.id = id;
}

public String getContent(){
	return content;
}

public void setContent(String content){
	this.content = content;
}

public Post getPost(){
	return post;
}

public void setPost(Post post){
	this.post = post;
}

public User getUser(){
	return user;
}

public void setUser(User user){
	this.user = user;
}

//    /////////////////////////
//    CONSTRUCTORS
//    /////////////////////////
public Comment(){
}

public Comment(long id, String content){
	this.id = id;
	this.content = content;
}

public Comment(String content){
	this.content = content;
}

public Comment(String content, Post post){
	this.content = content;
	this.post = post;
}

public Comment(String content, Post post, User user){
	this.content = content;
	this.post = post;
	this.user = user;
}

public Comment(long id, String content, Post post, User user){
	this.id = id;
	this.content = content;
	this.post = post;
	this.user = user;
}
}
