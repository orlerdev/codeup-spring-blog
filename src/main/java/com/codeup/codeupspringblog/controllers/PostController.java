package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Comment;
import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.CommentRepository;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import com.codeup.codeupspringblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class PostController{

private final PostRepository postsDao;
private final UserRepository usersDao;
private final CommentRepository commentsDao;
private final EmailService emailService;


public PostController(PostRepository postsDao, UserRepository userDao, CommentRepository commentDao, EmailService emailService){
	this.postsDao = postsDao;
	this.usersDao = userDao;
	this.commentsDao = commentDao;
	this.emailService = emailService;
}

@GetMapping("/posts")
public String allPosts(Model model){
	List<Post> posts = postsDao.findAll();
	model.addAttribute("posts", posts);
	return "posts/index";
}

@GetMapping("/posts/create")
public String createPostForm(Model model){
	model.addAttribute("post", new Post());
	return "posts/create";
}

@PostMapping("/posts/create")
public String submitForm(@ModelAttribute Post post){
	User user = usersDao.findUserById(1L);
	post.setUser(user);
	post.setTitle(post.getTitle());
	post.setBody(post.getBody());
	postsDao.save(post);
	emailService.prepareAndSend(post, post.getTitle(), post.getBody(), "email@email.com");
	return "redirect:/posts";
}

@GetMapping("/posts/{id}")
public String singlePost(@PathVariable long id, Model model){
	Post post = postsDao.findPostById(id);
	model.addAttribute("post", post);
	return "posts/show";
}

@GetMapping("/posts/{id}/edit")
public String editPostForm(@PathVariable long id, Model model){
	Post post = postsDao.findPostById(id);
	model.addAttribute("post", post);
	return "/posts/create";
}

@PostMapping("/posts/{id}/edit ")
public String submitEditForm(@PathVariable long id, @ModelAttribute Post post){
	User user = usersDao.findUserById(1L);
	post.setUser(user);
	postsDao.save(post);
	post.setId(id);
	return "redirect:/posts";
}

//@GetMapping("/posts/create-comment")
//public String createCommentForm(@RequestParam(name="content") String content, Model model){
//	model.addAttribute("comment", new Comment());
//	model.addAttribute("content", content);
//	return "/posts/index";
//}
//
//@PostMapping("/partials/comment-modal")
//public String createCommentModal(@ModelAttribute Comment comment, Model model){
//	comment.setContent(comment.getContent());
//	commentsDao.save(comment);
//	return "/posts/index";
//}


//@PostMapping("/posts/edit")
//public String editForm(
//		@RequestParam(name="title") String title,
//		@RequestParam(name="body") String body,
//		@RequestParam(name="postId") Long postId){
//	User user = usersDao.findUserById(1L);
//	Post post = postsDao.findPostById(postId);
//	if(post != null){
//		postsDao.setPostById(postId, title, body);
//	} else{
//		Post newPost = new Post(title, body);
//		postsDao.save(newPost);
//	}
//	return "redirect:/posts";
//}

@PostMapping("/posts/create-comment")
public String createComment(@ModelAttribute Comment comment){
	User user = usersDao.findUserById(1L);
	comment.setContent(comment.getContent());
	commentsDao.save(comment);
	return "redirect:/posts";
}
}
