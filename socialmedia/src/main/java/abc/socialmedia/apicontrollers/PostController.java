package abc.socialmedia.apicontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import abc.socialmedia.business.abstracts.PostService;
import abc.socialmedia.core.utilities.results.DataResult;
import abc.socialmedia.core.utilities.results.Result;
import abc.socialmedia.entities.Dto.PostAdd;
import abc.socialmedia.entities.abstracts.Post;

@RestController
@RequestMapping("api/posts")
public class PostController {
	private PostService postService;
    @Autowired
	public PostController(PostService postService) {
		super();
		this.postService = postService;
	}
    @GetMapping("/getall")
   	public DataResult<List<Post>> getAll(){
   		return this.postService.getAll();
   	}
   	
    @PostMapping("/add")
   	public Result addPost(@RequestBody PostAdd newPostAdd) {
   		return this.postService.addPost(newPostAdd);
   	}
    @GetMapping("getByPostAccordingToUserId")
    public DataResult<List<Post>> getByPostAccordingToUserId(@RequestParam int userId){
    	return this.postService.findByUserId(userId);
    }
    @GetMapping("getByPostAccordingToPostId")
    public Post getByPostAccordingToPostId(@RequestParam int postId) {
    	return this.postService.findByPostId(postId);
    }
    @DeleteMapping("deletePost")
    public Result deletePost(@RequestParam int postId) {
    	return this.postService.deletePost(postId);
    }
       
       
      
	

}
