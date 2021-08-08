package abc.socialmedia.business.concrets;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import abc.socialmedia.business.abstracts.PostService;
import abc.socialmedia.business.abstracts.UserService;
import abc.socialmedia.core.utilities.results.DataResult;
import abc.socialmedia.core.utilities.results.ErrorResult;
import abc.socialmedia.core.utilities.results.Result;
import abc.socialmedia.core.utilities.results.SuccesDataResult;
import abc.socialmedia.core.utilities.results.SuccesResult;
import abc.socialmedia.dataAccess.abstracts.PostDao;
import abc.socialmedia.entities.Dto.PostAdd;
import abc.socialmedia.entities.abstracts.Post;
import abc.socialmedia.entities.abstracts.User;
@Service
public class PostManager implements PostService{
	private PostDao postDao;
	private UserService userService;
    @Autowired
	public PostManager(PostDao postDao,UserService userService) {
		super();
		this.postDao = postDao;
		this.userService=userService;
	}

	@Override
	public DataResult<List<Post>> getAll() {
		return new SuccesDataResult<List<Post>>(this.postDao.findAll(), "postlar listelendi");
	}
	
	@Override
	public Result addPost(PostAdd newPostAdd) {
		User user=userService.findByUserId(newPostAdd.getUserId());//userın idsi var mı yok mu kontrol ettik
		if(user==null) {
			return null;
		}
		Post post=new Post();
		post.setPostId(newPostAdd.getPostId());
		post.setUserId(user);
		post.setText(newPostAdd.getText());
		if(post.getText().length()>161) {
			return new ErrorResult("post için verilen 161 karakteri aştınız.");
		}else {
			this.postDao.save(post);
			return new SuccesResult("post gönderildi");
		}
		
	}

    @Override
	public DataResult<List<Post>> findByUserId(int userId) {
    	return new SuccesDataResult<List<Post>>(this.postDao.findByUserId(userId), "Kullanıcı postları listelendi");
	}

	@Override
	public Post findByPostId(int postId) {
		return this.postDao.findByPostId(postId);
	}

	@Override
	public Result deletePost(int postId) {
		this.postDao.deleteById(postId);
		return new SuccesResult("post silindi");
	}

	

}
