package crm_app07service;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm_app07entity.UserEntity;
import crm_app07repository.UserRepository;
import utils.MD5;

public class LoginService {
	private UserRepository userRepository = new UserRepository();

	public boolean checkLogin(String email, String password, String remember, HttpServletResponse resp,
            HttpServletRequest req) {
    String passwordEncode = MD5.getMd5(password);
    List<UserEntity> listUsers = userRepository.findByEmailAndPassword(email, passwordEncode);

    boolean isSuccess = listUsers.size() > 0;

    if (isSuccess) {
        // Lưu thông tin vào cookie
        UserEntity user = listUsers.get(0);

        // Nếu không có role, mặc định là ROLE_USER
        String role = user.getRolename() != null ? user.getRolename() : "ROLE_USER"; 

        // Tạo cookie cho xác thực
        Cookie authCookie = new Cookie("authen", role);
        resp.addCookie(authCookie);
        authCookie.setMaxAge(60);
        
        Cookie emailCookie = new Cookie("ckEmail", email); 
        emailCookie.setMaxAge(24 * 60 * 60);
        resp.addCookie(emailCookie); 

       
    }

    if (remember != null && isSuccess) {
        Cookie ckEmail = new Cookie("ckEmail", email);
        Cookie ckPassword = new Cookie("ckPassword", password);
        resp.addCookie(ckEmail);
        resp.addCookie(ckPassword);
    }

    return isSuccess;
}


	
	 public void logout(HttpServletRequest req, HttpServletResponse resp) {
	        // Xóa cookie xác thực
	        Cookie[] cookies = req.getCookies();
	        if (cookies != null) {
	            for (Cookie cookie : cookies) {
	                if ("authen".equals(cookie.getName()) || "ckEmail".equals(cookie.getName()) || "ckPassword".equals(cookie.getName())) {
	                    cookie.setMaxAge(0);
	                    resp.addCookie(cookie);
	                }
	            }
	        }
	    }

	    public String getRoleName(String email) {
	        // Tìm kiếm người dùng qua email và trả về tên role của họ
	        List<UserEntity> listUsers = userRepository.findByEmail(email);
	        
	        if (listUsers != null && !listUsers.isEmpty()) {
	            UserEntity user = listUsers.get(0);
	            return user.getRolename(); 
	        }
	        return null; 
	    }

}
