package abc.socialmedia.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import abc.socialmedia.entities.abstracts.Post;


public interface PostDao extends JpaRepository<Post, Integer>{
	
	List<Post> findByUserId(int userId);
	Post findByPostId(int postId);
	

}
