package com.mehmett.arkadaslik_uygulamasi.service;

import com.mehmett.arkadaslik_uygulamasi.dto.request.RegisterRequestDto;
import com.mehmett.arkadaslik_uygulamasi.entity.Gender;
import com.mehmett.arkadaslik_uygulamasi.entity.User;
import com.mehmett.arkadaslik_uygulamasi.repository.UserRepository;
import com.mehmett.arkadaslik_uygulamasi.views.VwUser;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * DİKKAT!!!!! spring boot bir sınıfın refaransını oluşturmak için mutlaka
 * o sınıfın işaretli olmasını talep eder, yani bir sınıftan nesne türetecek mi
 * bilmek ister.
 */
@Service
public class UserService {
	/**
	 *  Service temel işlemleri yerine getirir. Gerekli gördüğü bilgileri repository'e
	 *  aktarır. Bu
	 */
	
//	@Autowired
//	private UserRepository userRepository;
	
	/**
	 * Dependency Injection / DI
	 * Spring boot'ta
	 */
	
	private  final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void addUser(String userName, String avatar, Gender gender) {
		User user= User.builder().username(userName).avatar(avatar).gender(gender).build();
		userRepository.save(user);
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public List<User> kadinKullanicilariGetir() {
		return userRepository.findAllByGender(Gender.FAMALE);
	}

	
	public void createUser(String username, String password, String email,String name) {
		User user= User.builder().username(username).password(password).email(email).name(name).build();
		userRepository.save(user);
	}
	
	public List<User> findAllByName(String name) {
		return userRepository.findAllByNameContainingIgnoreCase(name);
	}
	
	public  User searchUserById(Long id) {
		return userRepository.searchUserById(id);
	}
	
	public User findById(Long id) {
	return 	userRepository.findById(id).orElse(null);
	}

//	public List<User> findAllByUserName(String userName) {
//		return userRepository.findAllByUserNameContainingIgnoreCase(userName);
//	}
	

	public User register(RegisterRequestDto dto) {
		return userRepository.save(User.builder()
		                               .username(dto.getUserName())
		                               .password(dto.getPassword())
		                               .password(dto.getRePassword())
		                               .email(dto.getEmail()).build());
	}
	
	public List<VwUser> getAllUserList() {
		return userRepository.tumKullanicilariGetir();
	}
	
	/**
	 * Aranılan kullanıcı id sini DB de sorgular kayıt var ise true, yok ise false döndürür
	 * @param userId
	 * @return
	 */
	public boolean existById( Long userId) {
		return userRepository.existsById(userId);
	}
	
	/**
	 * Aranılan kullanıcı id sini DB de sorgular optional ile SARMALANMIS bir user döner.
	 * @param userId
	 * @return
	 */
	public Optional<User> findOptionalById( Long userId) {
		return userRepository.findById(userId);
	}
}