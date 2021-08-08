package abc.socialmedia.business.abstracts;

import java.util.List;

import abc.socialmedia.core.utilities.results.DataResult;
import abc.socialmedia.core.utilities.results.Result;
import abc.socialmedia.entities.abstracts.User;


public interface UserService {
	DataResult<List<User>> getAll();
	
	User findByUserId(int userId);
	DataResult<List<User>> findByPostId(int postId);

	

	Result addUser(User newUser);
	Result deleteUser(int userId);
    Result uptadeUser(int userId,User newUser);
}
