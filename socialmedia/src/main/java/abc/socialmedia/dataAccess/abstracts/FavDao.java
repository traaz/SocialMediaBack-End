package abc.socialmedia.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import abc.socialmedia.entities.abstracts.Fav;

public interface FavDao extends JpaRepository<Fav, Integer>{
	List<Fav> findByPostId(int postId);

}
