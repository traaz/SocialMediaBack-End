package abc.socialmedia.business.concrets;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import abc.socialmedia.core.utilities.results.DataResult;
import abc.socialmedia.core.utilities.results.ErrorResult;
import abc.socialmedia.core.utilities.results.Result;
import abc.socialmedia.business.abstracts.UserService;

import abc.socialmedia.core.utilities.results.SuccesDataResult;
import abc.socialmedia.core.utilities.results.SuccesResult;
import abc.socialmedia.dataAccess.abstracts.UserDao;
import abc.socialmedia.entities.abstracts.User;

@Service
public class UserManager implements UserService{
	private UserDao userDao;
	
	
    @Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}


	@Override
	public DataResult<List<User>> getAll() {
		return new SuccesDataResult<List<User>>(this.userDao.findAll(), "kullanicilar listelendi");
	}


	@Override
	public Result addUser(User newUser) {
		if(newUser.getUserMail().isBlank()|| newUser.getUserName().isBlank() || newUser.getUserPassword().isBlank()) {
			return new ErrorResult("tum alanlari doldurunuz.");
		}
		else if(newUser.getUserPassword().length()<8) {
			return new ErrorResult("sifre en az 8 haneli olmalı.");
		}else if(!checkMail(newUser.getUserMail())) {
			return new ErrorResult("siteye kayitli bir mail adresi girdiniz.");
		}else if(!checkUserName(newUser.getUserName())) {
			return new ErrorResult("siteye kayitli bir kullanici adi girdiniz.");
		}else {
			this.userDao.save(newUser);
			return new SuccesResult("kullanici kayit edildi");
	}

	
	}
	public boolean checkMail(String userMail) {
    	if(this.userDao.findByUserMail(userMail)==null) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean checkUserName(String userName) {
    	if(this.userDao.findByUserName(userName)==null) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }


	@Override
	public User findByUserId(int userId) {
		return this.userDao.findByUserId(userId);
	}


	@Override
	public Result deleteUser(int userId) {
	    this.userDao.deleteById(userId);
	    return new SuccesResult("kullanici silindi");
	}


	@Override
	public Result uptadeUser(int userId,User newUser) {
		User user=userDao.findByUserId(userId);
		user.setUserName(newUser.getUserName());
		user.setUserPassword(newUser.getUserPassword());
		user.setUserMail(newUser.getUserMail());
		
		if(user.getUserPassword().length()<8) {
			return new ErrorResult("sifre en az 8 haneli olmalı.");
		}
		else {
			this.userDao.save(user);
			return new SuccesResult("kullanici bilgileri güncellendi.");
		}
		
	}


	@Override
	public DataResult<List<User>> findByPostId(int postId) {
		return this.findByPostId(postId);
	}










	


	
	

}
