package abc.socialmedia.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import abc.socialmedia.entities.abstracts.Mention;

public interface MentionDao extends JpaRepository<Mention, Integer>{
	List<Mention> findByPostId(int postId);

}
