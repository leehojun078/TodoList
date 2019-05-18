package kr.ac.hojun.cse.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hojun.cse.dao.PostDao;
import kr.ac.hojun.cse.model.Post;

@Service
public class PostService {

	@Autowired
	private PostDao postDao;
	
	public List<Post> getPosts(){
		return postDao.getPosts();
	}

	public boolean addPost(Post post) {
		
		return postDao.addPost(post); 
	}


	public boolean deletePost(int id) {
		
		return postDao.deletePost(id);
	}

	public Post getPostById(int id) {
		
		return postDao.getPostById(id);
	}

	public boolean updatePost(Post post) {
		
		return postDao.updatePost(post);
	}

	public boolean completePost(int id) {
		
		return postDao.completePost(id);
	}
	
}
