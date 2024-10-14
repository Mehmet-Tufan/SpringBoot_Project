package com.mehmett.arkadaslik_uygulamasi.service;

import com.mehmett.arkadaslik_uygulamasi.dto.request.AddFollowRequestDto;
import com.mehmett.arkadaslik_uygulamasi.entity.Follow;
import com.mehmett.arkadaslik_uygulamasi.exception.ArkadaslikException;
import com.mehmett.arkadaslik_uygulamasi.exception.ArkadaslikException3;
import com.mehmett.arkadaslik_uygulamasi.exception.ErrorType;
import com.mehmett.arkadaslik_uygulamasi.exception.ErrorType3;
import com.mehmett.arkadaslik_uygulamasi.repository.FollowRepository;
import org.springframework.stereotype.Service;

@Service
public class FollowService {
	private final FollowRepository followRepository;
	private final UserService userService;
	
	public FollowService(FollowRepository followRepository, UserService userService) {
		this.followRepository = followRepository;
		this.userService = userService;
	}
	
	public void addFollow(AddFollowRequestDto dto) {
		if (!userService.existById(dto.getUserId()) || !userService.existById(dto.getFollowId())) {
//			throw new RuntimeException("kulllanıci id yada takipci id bulunamadı. ");
			throw new ArkadaslikException3(ErrorType3.FOLLOW_USERID_FOLLOWINGID_NOTFOUND);
//			throw new ArkadaslikException(ErrorType.FOLLOW_USERID_FOLLOWINGID_NOTFOUND);
		}
		
		Follow follow = Follow.builder().followId(dto.getFollowId()).userId(dto.getUserId()).build();
		followRepository.save(follow);
	}
}