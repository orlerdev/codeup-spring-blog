package com.codeup.codeupspringblog.models;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false, length = 50)
  private String username;

  @Column(nullable = false, length = 50)
  private String email;

  @Column(nullable = false, length = 50)
  private String password;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
  private List<Post> posts;

  public User() {}
  public User(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
}
