package abc.socialmedia.apicontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import abc.socialmedia.business.abstracts.MentionService;
import abc.socialmedia.core.utilities.results.DataResult;
import abc.socialmedia.core.utilities.results.Result;
import abc.socialmedia.entities.Dto.MentionAdd;
import abc.socialmedia.entities.abstracts.Mention;


@RestController
@RequestMapping("api/mentions")
public class MentionController {
	private MentionService mentionService;
    @Autowired
	public MentionController(MentionService mentionService) {
		super();
		this.mentionService = mentionService;
	}
    @GetMapping("/getall")
   	public DataResult<List<Mention>> getAll(){
   		return this.mentionService.getAll();
   	}
   	
    @PostMapping("/add")
   	public Result add(@RequestBody MentionAdd mentionAdd) {
   		return this.mentionService.add(mentionAdd);
   	}
   @GetMapping("getByMention")
    public DataResult<List<Mention>> getByMention(@RequestParam int postId){
    	return this.mentionService.findByPostId(postId);
   }
    @DeleteMapping("deleteMention")
    public Result deleteMention(@RequestParam int mentionId) {
    	return this.mentionService.deleteMention(mentionId);
    }
       
    
	

}
