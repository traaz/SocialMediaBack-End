package abc.socialmedia.apicontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import abc.socialmedia.business.abstracts.UserService;
import abc.socialmedia.core.utilities.results.DataResult;
import abc.socialmedia.core.utilities.results.Result;
import abc.socialmedia.entities.abstracts.User;



@RestController
@RequestMapping("api/users")
public class UserController {
	private UserService userService;
   
	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
    @GetMapping("/getall")
	public DataResult<List<User>> getAll(){
		return this.userService.getAll();
	}
    @PostMapping("add")
    public Result addUser(@RequestBody User newUser) {
    	return this.userService.addUser(newUser);
    }
    @DeleteMapping("deleteUser")
    public Result deleteUser(@RequestParam int userId) {
    	return this.userService.deleteUser(userId);
    }
	
  
    @GetMapping("getByUser")
    public User getByUser(@RequestParam int userId){
    	return this.userService.findByUserId(userId);
    			
    }
    @PutMapping("updateUser")
    public Result updateUser(@RequestParam int userId, @RequestBody User newUser) {
    	return this.userService.uptadeUser(userId, newUser);
    }

    
    
    
  
    
    
    
    
	

}
