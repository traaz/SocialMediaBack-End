package abc.socialmedia.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import abc.socialmedia.entities.abstracts.User;

public interface UserDao extends JpaRepository<User, Integer>{
	User findByUserMail(String userMail);
	User findByUserName(String userName);
    User findByUserId(int userId);
   List<User> findByPostId(final int postId);
}
