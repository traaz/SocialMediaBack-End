package abc.socialmedia.apicontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import abc.socialmedia.business.abstracts.FavService;
import abc.socialmedia.core.utilities.results.DataResult;
import abc.socialmedia.entities.abstracts.Fav;


@RestController
@RequestMapping("api/favs")
public class FavController {
	private FavService favService;
    @Autowired
	public FavController(FavService favService) {
		super();
		this.favService = favService;
	}
    @GetMapping("/getall")
   	public DataResult<List<Fav>> getAll(){
   		return this.favService.getAll();
   	}
   	@GetMapping("getByFav")
   	public DataResult<List<Fav>> getByFav(@RequestParam int postId){
   		return this.favService.findByPostId(postId);
   	}
   	
	

}
