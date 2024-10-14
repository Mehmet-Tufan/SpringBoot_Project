package com.mehmett.arkadaslik_uygulamasi.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AddFollowRequestDto {
	/**
	 * String username
	 * Kullanıcı tarafından hiç göndermemesi
	 * @NotNull -> username = null
	 */
	
	@NotNull // bir değerin hiç var olmaması
	Long userId;
	@NotNull
	Long followId;
}