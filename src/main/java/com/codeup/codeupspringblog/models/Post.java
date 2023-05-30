package com.codeup.codeupspringblog.models;
import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false, length = 50)
  private String title;

  @Column(nullable = false, length = 150)
  private String body;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  public Post() {}
  public Post(String title, String body) {
    this.title = title;
    this.body = body;
  }

  public Post(String title, String body, User user) {
    this.title = title;
    this.body = body;
    this.user = user;
  }

  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getBody() {
    return body;
  }
  public void setBody(String body) {
    this.body = body;
  }
  public User getUser() {
    return user;
  }
  public void setUser(User user) {
    this.user = user;
  }
}
