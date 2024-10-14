package com.mehmett.arkadaslik_uygulamasi.repository;

import com.mehmett.arkadaslik_uygulamasi.entity.Gender;
import com.mehmett.arkadaslik_uygulamasi.entity.User;
import com.mehmett.arkadaslik_uygulamasi.views.VwUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA, spring boot'un yapısı gereği her bir interface için gerekli olan
 */
public interface UserRepository extends JpaRepository<User, Long> {
//	List<User> butunDatalarıBanaVer();
	
	/**
	 * Kadın kullanıcıları listelemek istiyoruz.
	 */
	
	// YANLIŞ List<User> kadinKullanicilariGetir();
	
	/**
	 * JPA Repository belli keywordlerle sorgu -- JPA
	 */
	
	List<User> findAllByGender(Gender gender);
	
	/**
	 * select * from user where gender = ?1 and age = ?2 select * from user where gender = ?1 or name = ?2
	 */
	
	List<User> findAllByGenderAndAge(Gender gender, int age);
	
	List<User> findAllByGenderOrName(Gender gender, String name);
	
	/**
	 * Sorgu sadace tek bir sonuç dönecek ise return type
	 * Entity ya da Optional<Entity> kullanılır
	 * select * from user where username = ?1
	 */
	
	// BU sorgu kullanıcıyı bulursa değer döner yok ise null döner
//	User findByUsername(String username);
	
	Optional<User> findOptionalByUsername(String username);
	
	/**
	 * select * from user where age>?1
	 * select * from user where age>=?1
	 */
	
	List<User> findAllByAge(int age);// Yaşı buna eşit olanlar
	
	List<User> findAllByAgeGreaterThan(int age); // Yaşı büyük olanlar
	
	List<User> findAllByAgeGreaterThanEqual(int age); // Yaşı büyük ve eşit olanlar
	
	List<User> findAllByAgeLessThan(int age); // bundab küçük olanlar
	
	List<User> findAllByAgeLessThanEqual(int age); // Yaşı küçük ve eşit olanlar
	
	
	/**
	 * select * from user where username like '%[VALUE]%'
	 * select * from user where username like '[VALUE]%'
	 * select * from user where username like '%[VALUE]'
	 * select * from user where username like '___ [VALUE]%'
	 */
	
	List<User> findAllByUsernameLike (String username);
	
	List<User> findAllByUsernameLikeIgnoreCase (String username);
	
	/**
	 * bununla başlayanlar -> startingWith
	 * bununla bitenler -> endingWith
	 * bunu içerenler -> containing
	 */
	
	List<User> findAllByUsernameStartingWith(String username);
	
	List<User> findAllByUsernameEndingWith(String username);
	
	List<User> findAllByUsernameContaining(String username);
	
	List<User> findAllByUsernameContainingIgnoreCaseAndAgeGreaterThanAndEmailEndingWith(String username, int age, String email);
	
	/**
	 * sorgu neticesinde dönen verilerde sıralama yapmak istiyorsak
	 * select * from user order by age asc
	 * select * from user order by age desc
	 */
	
	List<User> findAllByOrderByAgeAsc();
	
	List<User> findAllByOrderByAgeDesc();
	
	// select * from user where name = ?1 and  order by age desc
	
	List<User> findAllByNameOrderByAgeDesc(String name);
	
	/**
	 * Sorgular genellikle kısıtlanarak kullanılmaktadır. Böylece sorgu performansını arttırır.
	 * select * from tbl_user limit 5 [TOP] oracle,mssql
	 * select * from tbl_user order by age desc limit 1
	 */
	
	User findTopByOrderByAgeDesc();

	List<User> findTop5ByOrderByAge();
	
	/**
	 * Belli aralıkları sorgulamak istediğimizde
	 * select * from tbl_user where age>5 and age<25
	 * select * from tbl_user where age>=5 and age<=25
	 * select * from tbl_user where age between 5 and 25
	 */
	
	List<User> findAllByAgeBetween(int age1, int age2);//[age1,age2)] sınırları dahil eder

	List<User> findAllByUsernameContainingAndAgeBetween (String username, int age1, int age2);
	
	
	/**
	 * Boolean değeri sorgularken kullanılacak keyword
	 * hesabı aktif olan kullanıcılar
	 */
	
	List<User> findAllByIsActiveTrue();// hesebı aktif olan kullanıcıları getirir
	List<User> findAllByIsActiveFalse();// hesebı pasif alan kullanıcıları getirir
	
	/**
	 * mükerrer kayıtları tekiltirmek istediğimde
	 *
	 */
	
//	List<String> findDistinctByName ();
	
	
	List<User> findAllByIsActiveIsNull (); // aktif bilgisi null olanları getirir
	List<User> findAllByIsActiveIsNotNull (); // aktif bilgisi null olmayanları getirir
	
	/**
	 * Belli kullsnıcıların listesine ihtiyac duymaktayız, burada id kullanılacak diyelim.
	 * id si
	 * select * from tbl_user where id in (1,2,3,4,5)
	 * select * from tbl_user where id in (select followerid from tbl_follow where id = 5)
	 */
	
	List<User> findAllByIdIn(List<Long> ids);
	
	/**
	 * JPQL -> Jakarta Persistence Query Language
	 * HQL -> Hibernate Query Language -> from User
	 * NATIVESQL -> bildiğimiz SQL sorguları
	 */
//	@Query("select * from tbl_user  where name = ?")//NATIVESQL -> bildiðimiz SQL sorguları
//	List<User> banaAdiSuOlanKullanıcılarıGetir(String name);
	
	@Query("select u from User u where u.name = ?1") //JPQL -> Jakarta Persistence Query Language
	List<User> banaAdiSuOlanKullanıcılarıGetir(String name);
	
	@Query("select u from User u where u.age = ?1 and u.email like ?2")
	List<User> yasiSuOlanVeMailAdresiBuOlan(int age, String email);
	
	@Query(nativeQuery = true, value = "select * from User where age > ?1")
	List<User> yasiBuyukOlanlarıGetir(int age);
	
	/**
	 * Loggin olacak bir kullanıcı Un , Pwd girmeli bu kritere uyan kullanıcı varsa
	 * giris yapmalı sql sorgusunu yazmamız gerekiyor.
	 * select Count(*)>0 from tbl_user where username = ?1 and password = ?2
	 */
	
	@Query("select count(u)>0 from User u where u.username = ?1 and u.password = ?2")
	User buKullaniciVarMi(String username, String password);
	
	Boolean existsByUsernameAndPassword(String username, String password);//yukardaki ile aynı sorgu
	
	@Query("select new com.mehmett.arkadaslik_uygulamasi.views.VwUser( u.username,u.name,u.avatar) from User u")
	List<VwUser> tumKullanicilariGetir();
	
	
	List<User> findAllByNameContainingIgnoreCase(String name);
	
//	List<User> findAllByUserNameContainingIgnoreCase(String username);
	
//	@Query("select u from User u where u.id = ?1 ")
	User searchUserById(Long id);
}
/**
 * JpaRepository-> içerisindeki tüm metodların kodlamaları standarttır.
 */