package crm_app07service;

import crm_app07entity.UserEntity;
import crm_app07entity.RoleEntity;
import crm_app07repository.UserRepository;
import crm_app07repository.RoleRepository;
import utils.MD5;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UserService {
	private UserRepository userRepository = new UserRepository();
	
	
	public List<UserEntity> getAllUserTable() {
		List<UserEntity> listUsers = userRepository.findAll();
		return listUsers;
	}

	public boolean deleteUserById(int id) {
		int count = userRepository.deleteById(id);

		return count > 0;
	}

	public boolean insertUser(String email, String password, String fullname, int roleId) {
		return userRepository.insert(email, MD5.getMd5(password), fullname, roleId) > 0;
	}
	public UserEntity getUserById(int id) {
	    return userRepository.findById(id);
	}
	public boolean updateUser(String email, String password, String fullname, int roleId,int id) {
	    int count = userRepository.updateUser(email,MD5.getMd5(password), fullname, roleId, id);
	    return count > 0;
	}

	
	 public boolean register(String email, String password, String fullname, int roleId) {
	        String encodedPassword = MD5.getMd5(password);
	        int rowsInserted = userRepository.insert(email, encodedPassword, fullname, roleId);
	        return rowsInserted > 0;
	    }
	 
	 public String getEmailFromCookies(HttpServletRequest req) {
		    if (req.getCookies() != null) {
		        for (Cookie cookie : req.getCookies()) {
		            if ("ckEmail".equals(cookie.getName())) { // Giả sử cookie chứa email được lưu với tên "authen_email"
		                return cookie.getValue();
		            }
		        }
		    }
		    return null;
		}

}