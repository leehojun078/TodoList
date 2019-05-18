package kr.ac.hojun.cse.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.hojun.cse.model.Post;
import kr.ac.hojun.cse.service.PostService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping
	public String adminPage() {
		return "admin";
	}
	
	@RequestMapping("/postInventory")
	public String getPosts(Model model) { 
		
		List<Post> posts = postService.getPosts();
		model.addAttribute("posts",posts);
		
		return "postInventory";
	}
				
	//Get method
	@RequestMapping(value="/postInventory/addPost", method=RequestMethod.GET)
	public String addPost(Model model) throws ParseException {
		Post post = new Post();
		
		//초기화
		post.setPriority("상");
		post.setState("진행 중");
		model.addAttribute("post", post);
		
		return "addPost";
	}
	
	//Post method, input data binding
	@RequestMapping(value="/postInventory/addPost", method=RequestMethod.POST)
	public String addPostPost(@Valid Post post, BindingResult result) {
		
		if(result.hasErrors()) {
			/*
			System.out.println("form data has some errors");
			List<ObjectError> errors = result.getAllErrors();
			
			for(ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
			*/
			return "addPost";
		}
		
		if(!postService.addPost(post)) { 
			System.out.println("Adding post cannot be done");
		}
		
		return "redirect:/admin/postInventory"; 
	}
	
	//delete
	@RequestMapping(value="/postInventory/deletePost/{id}", method=RequestMethod.GET)
	public String deletePost(@PathVariable int id) throws ParseException {
		
		if(!postService.deletePost(id)) {
			System.out.println("Deleting post cannot be dones");
		}
		
		return "redirect:/admin/postInventory"; 
	}
	
	//update
	@RequestMapping(value="/postInventory/updatePost/{id}", method=RequestMethod.GET)
	public String updatePost(@PathVariable int id, Model model) throws ParseException {
		
		Post post = postService.getPostById(id);
		model.addAttribute("post", post);
		
		return "updatePost";
	}
	
	//update, data binding
	@RequestMapping(value="/postInventory/updatePost", method=RequestMethod.POST)
	public String updatePostPost(@Valid Post post, BindingResult result) {
		
		if(result.hasErrors()) {
			/*
			System.out.println("form data has some errors");
			List<ObjectError> errors = result.getAllErrors();
			
			for(ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
			*/
			return "updatePost";
		}
		
		if(!postService.updatePost(post)) { 
			System.out.println("Updating post cannot be done");
		}
		return "redirect:/admin/postInventory"; 
	}
	
	//complete
	@RequestMapping(value = "/postInventory/completePost/{id}", method = RequestMethod.GET)
	public String completePost(@PathVariable int id) throws ParseException {

		if (!postService.completePost(id)) {
			System.out.println("Completing post cannot be done");
		}

		return "redirect:/admin/postInventory";
	}
}