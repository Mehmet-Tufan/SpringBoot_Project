package com.mehmett.arkadaslik_uygulamasi.controller;

import static com.mehmett.arkadaslik_uygulamasi.constant.RestApis.*;

import com.mehmett.arkadaslik_uygulamasi.dto.request.AddFollowRequestDto;
import com.mehmett.arkadaslik_uygulamasi.dto.response.BaseResponse;
import com.mehmett.arkadaslik_uygulamasi.service.FollowService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(FOLLOW)
@RequiredArgsConstructor
public class FollowController {
	private final FollowService followService;
	//http://localhost:9090/follow/add-follow?userId=1&followId=5
	@PostMapping(ADDFOLLOW)
	public ResponseEntity<BaseResponse<Boolean>> addfollow(@RequestBody @Valid AddFollowRequestDto dto) {
		followService.addFollow(dto);

		return ResponseEntity.ok(BaseResponse.<Boolean>builder()
		        .data(true)
				.success(true)
				.code(200)
				.message("takip işlemi başarı ile tamamlandı").build());

	}
	
}