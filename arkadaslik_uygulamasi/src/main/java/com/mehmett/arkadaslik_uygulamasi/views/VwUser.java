package com.mehmett.arkadaslik_uygulamasi.views;

import com.mehmett.arkadaslik_uygulamasi.entity.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class VwUser {
	String username;
	String name;
	String avatar;
	
	
}