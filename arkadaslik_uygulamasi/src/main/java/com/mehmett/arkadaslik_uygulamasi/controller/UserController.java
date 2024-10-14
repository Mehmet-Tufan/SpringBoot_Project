package com.mehmett.arkadaslik_uygulamasi.controller;

import static com.mehmett.arkadaslik_uygulamasi.constant.RestApis.*;
import com.mehmett.arkadaslik_uygulamasi.constant.RestApis;
import com.mehmett.arkadaslik_uygulamasi.dto.request.RegisterRequestDto;
import com.mehmett.arkadaslik_uygulamasi.dto.response.BaseResponse;
import com.mehmett.arkadaslik_uygulamasi.entity.Gender;
import com.mehmett.arkadaslik_uygulamasi.entity.User;
import com.mehmett.arkadaslik_uygulamasi.service.UserService;
import com.mehmett.arkadaslik_uygulamasi.views.VwUser;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Control sınıfları son kullanıcı ile iletişime geçiş için gelen istemleri handle edecek
 *
 */

@RestController
@RequestMapping(USER)
public class UserController {
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	// http://localhost:9090/user/add-user
	@GetMapping(ADDUSER)
	public String addUser() {
		userService.addUser("Mehmet", "https://picsum.photos/100/100", Gender.MALE);
		userService.addUser("Deniz", "https://picsum.photos/100/100", Gender.MALE);
		userService.addUser("Bahar", "https://picsum.photos/100/100", Gender.FAMALE);
		userService.addUser("Canan", "https://picsum.photos/100/100", Gender.FAMALE);
		return "Kayitlar başarı ile eklendi";
	}
	// http://localhost:9090/user/add-all-user
	@GetMapping(ADDALLUSER)
	public List<User> addAllUser() {
		return userService.getAllUsers();
	}
	@GetMapping(GETADDALLUSERFEMALE)
	public List<User> getAllUsersFemale() {
		return userService.kadinKullanicilariGetir();
	}
	
	// http://localhost:9090/user/login
	@PostMapping(LOGIN)
	public void dologin(String userName, String password) {
		System.out.println("kullanıcı adı : " + userName);
		System.out.println("sifre : " + password);
	}
	
	// http://localhost:9090/create-user.html
	@PostMapping(CREATEUSER)
	public void createUser(String userName, String password, String eMail, String name) {
		System.out.println("kullanıcı adı : " + userName);
		System.out.println("sifre : " + password);
		System.out.println("email : " + eMail);
		System.out.println("name : " + name);
		userService.createUser(userName, password, eMail, name);
	}
	
	// http://localhost:9090/find-all-name.html
	@GetMapping("/find-all-name") // find-all-by-name
	public List<User> findAllByName(String name) {
		return userService.findAllByName(name);
	}
	
//	// http://localhost:9090/user/find-all-by-user-name
//	@GetMapping("/find-all-by-user-name")
//	public List<User> findAllByUserName(String userName) {
//		return userService.findAllByUserName(userName);
//	}
	
	// http://localhost:9090/search-user-id.html
	@GetMapping("/search-user-id")
	public User searchUserById(Long id) {
		System.out.println("id : " + id);
		return userService.searchUserById(id);
	}
	
	// http://localhost:9090/user/find-by-id
	@GetMapping(FINDBYID)
	public User findById(Long id) {
		return userService.findById(id);
	}
	
	/**
	 * Data Transfer Object - DTO
	 * Bilgi alırken yada gönderirkrn -> Request-Response
	 * Bilgileri alırken kısıtlı tutmak ve ihtiyaca göre talep etmek zorundayız
	 * Gelen verilerin tutarlılığını Controller katmanında incelemek zorundayız
	 * Kullanıcıya dönüş yapacağımız bilgileri kısıtlı tutmak zorundayız zira
	 * güvenlik için gizlenmesi gereken bilgiler vardır. Ayrıca ne kadar
	 * çok veri gönderimi o kadar kaynak kullanımı demektir.
	 */
	@PostMapping(REGISTER)
	public ResponseEntity<User> register(@RequestBody @Valid RegisterRequestDto dto){
		if (!dto.getPassword().equals(dto.getRePassword())) {
			return ResponseEntity.badRequest().body(null);
		}
		User user = userService.register(dto);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/get-all-user-list")
	public ResponseEntity<List<VwUser>> getAllUserList(){
		return ResponseEntity.ok(userService.getAllUserList());
	}
	
	@GetMapping("/get-all-view-user")
	public ResponseEntity<BaseResponse<List<VwUser>>> getAllViewUser(){
		return ResponseEntity.ok(
				BaseResponse.<List<VwUser>>builder()
				.success(true)
				.message("kullanıcı listesi başarılı şekilde getirildi. ")
				.code(200)
				.data(userService.getAllUserList())
				.build()
		);
	}
	
}