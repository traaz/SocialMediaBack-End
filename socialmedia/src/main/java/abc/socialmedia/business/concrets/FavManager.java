package abc.socialmedia.business.concrets;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import abc.socialmedia.business.abstracts.FavService;
import abc.socialmedia.core.utilities.results.DataResult;
import abc.socialmedia.core.utilities.results.SuccesDataResult;
import abc.socialmedia.dataAccess.abstracts.FavDao;
import abc.socialmedia.entities.abstracts.Fav;
@Service
public class FavManager implements FavService{
	private FavDao favDao;
	
	
    @Autowired
	public FavManager(FavDao favDao) {
		super();
		this.favDao = favDao;
	}



	@Override
	public DataResult<List<Fav>> getAll() {
		return new SuccesDataResult<List<Fav>>(this.favDao.findAll(), "fav listesi listelendi");
	}



	@Override
	public DataResult<List<Fav>> findByPostId(int postId) {
		return new SuccesDataResult<List<Fav>>(this.favDao.findByPostId(postId), "post'un aldiği fav sayisi gösterildi");
	}

}
