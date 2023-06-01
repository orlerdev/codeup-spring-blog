package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Comment;
import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.CommentRepository;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class PostController{
public User randomUser(UserRepository usersDao){
	List<User> allUsers = usersDao.findAll();
	int randomInt = new Random().nextInt(allUsers.size());
	return allUsers.get(randomInt);
}

private final PostRepository postsDao;
private final UserRepository usersDao;
private final CommentRepository commentsDao;

public PostController(PostRepository postsDao, UserRepository userDao, CommentRepository commentDao){
	this.postsDao = postsDao;
	this.usersDao = userDao;
	this.commentsDao = commentDao;
}

//    /////////////////////////
//    UTILIZE A <SET> TO RESTRICT A POST HAVING UNIQUE COMMENTS
//    PREVENTS DUPLICATE COMMENTS
//    /////////////////////////
public Set<Comment> createCommentsSet(String comments){
	// CREATE AN EMPTY LIST OF COMMENTS
	Set<Comment> commentsSet = new HashSet<>();
	// IF THE USER ENTERS NOTHING, RETURN THE EMPTY SET
	if(comments.equals("")){
		return commentsSet;
	}
	// CREATE AN ARRAY OF STRINGS, AND ITERATE THROUGH IT
	for(String comment : comments.split(",")){
		Comment singleComment = new Comment(comment.trim());
		commentsSet.add(singleComment);
	}
	return commentsSet;
}


@GetMapping("/posts")
public String allPosts(Model model){
	List<Post> posts = postsDao.findAll();
	model.addAttribute("posts", posts);
	return "posts/index";
}

@GetMapping("/posts/{id}")
public String singlePost(@PathVariable long id, Model model){
	Post post = postsDao.findById(id);
	model.addAttribute("post", post);
	return "posts/show";
}

@GetMapping("/posts/create")
public String createPostForm(){
	return "posts/create";
}

@PostMapping("/posts/create")
public String submitForm(@RequestParam(name="title") String title, @RequestParam(name="body") String body){
	User user = randomUser(usersDao);
	Post post = new Post(title, body, user);
	postsDao.save(post);
	return "redirect:/user_posts";
}

@GetMapping("/partials/comment-modal.html")
public String createCommentForm() {
	return "/partials/comment-modal";
}

@PostMapping("/posts/create_comment")
public String createComment(@ModelAttribute Comment comment) {
	return "redirect:/posts/show";
}
}
