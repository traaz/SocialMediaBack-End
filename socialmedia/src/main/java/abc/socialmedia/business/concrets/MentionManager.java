package abc.socialmedia.business.concrets;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import abc.socialmedia.business.abstracts.MentionService;
import abc.socialmedia.business.abstracts.PostService;
import abc.socialmedia.business.abstracts.UserService;
import abc.socialmedia.core.utilities.results.DataResult;
import abc.socialmedia.core.utilities.results.ErrorResult;
import abc.socialmedia.core.utilities.results.Result;
import abc.socialmedia.core.utilities.results.SuccesDataResult;
import abc.socialmedia.core.utilities.results.SuccesResult;
import abc.socialmedia.dataAccess.abstracts.MentionDao;
import abc.socialmedia.entities.Dto.MentionAdd;
import abc.socialmedia.entities.abstracts.Mention;
import abc.socialmedia.entities.abstracts.Post;
import abc.socialmedia.entities.abstracts.User;
@Service
public class MentionManager implements MentionService{
	private MentionDao mentionDao;
	private PostService postService;
	private UserService userService;
    @Autowired
	public MentionManager(MentionDao mentionDao,PostService postService,UserService userService) {
		super();
		this.mentionDao = mentionDao;
		this.postService=postService;
		this.userService=userService;
	}

	@Override
	public DataResult<List<Mention>> getAll() {
		return new SuccesDataResult<List<Mention>>(this.mentionDao.findAll(), "mentionlar listelendi");
	}

	@Override
	public Result add(MentionAdd mentionAdd) {
		Post post=postService.findByPostId(mentionAdd.getPostId());
		if(post==null) {
			return null;
		}
		User user=userService.findByUserId(mentionAdd.getUserId());
				//findByUserId(mentionAdd.getUserId());
		if(user==null) {
			return null;
		}
		Mention mention=new Mention();
		mention.setMentionId(mentionAdd.getMentionId());
		mention.setText(mentionAdd.getText());
		mention.setPostId(post);
		mention.setUserId(user);
		if(mention.getText().length()>161) {
			return new ErrorResult("mention için verilen 161 karakteri aştınız.");
		}else {
			this.mentionDao.save(mention);
			return new SuccesResult("mention gönderildi");
		}
	}

	@Override
	public DataResult<List<Mention>> findByPostId(int postId) {
		return new SuccesDataResult<List<Mention>>(this.mentionDao.findByPostId(postId), "post'un mentionları listelendi");
	}
	
	@Override
	public Result deleteMention(int mentionId) {
		this.mentionDao.deleteById(mentionId);
		return new SuccesResult("mention silindi");
	}

	

}
