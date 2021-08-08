package abc.socialmedia.business.abstracts;

import java.util.List;

import abc.socialmedia.core.utilities.results.DataResult;
import abc.socialmedia.core.utilities.results.Result;
import abc.socialmedia.entities.Dto.PostAdd;
import abc.socialmedia.entities.abstracts.Post;



public interface PostService {
	DataResult<List<Post>> getAll();
	
	DataResult<List<Post>> findByUserId(int userId);
	Post findByPostId(int postId);

	Result addPost(PostAdd newPostAdd);
	Result deletePost(int postId); 


}
