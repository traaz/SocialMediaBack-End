package abc.socialmedia.business.abstracts;

import java.util.List;

import abc.socialmedia.core.utilities.results.DataResult;
import abc.socialmedia.entities.abstracts.Fav;

public interface FavService {
	DataResult<List<Fav>> getAll();
	DataResult<List<Fav>> findByPostId(int postId);
}
