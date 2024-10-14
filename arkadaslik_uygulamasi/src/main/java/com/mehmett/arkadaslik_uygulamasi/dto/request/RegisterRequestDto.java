package com.mehmett.arkadaslik_uygulamasi.dto.request;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class RegisterRequestDto {
	@NotNull(message = "kullanıcı adı alanı zorunludur.")
	@Size(min = 3, max = 64, message = "kullanıcı adı 3 ile 64 karakter arasında olmalıdır.")
	String userName;

	@NotNull
	@NotEmpty
	@Size(min = 8, max = 64)
	@Pattern(
			message = "Sifre 8 ile 64 karakter arasında olmalıdır. Şifenizde en az bir büçük harf, bir küçük harf ve " +
					"bir özel karakter olmalıdır.",
			regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=*!])(?=\\S+$).{8,}$"
	)
	String password;
	@NotNull
	@NotEmpty
	String rePassword;
	@Email(message = "Lütfen geçerli bir email adresi giriniz.")
	String email;
	
	
}