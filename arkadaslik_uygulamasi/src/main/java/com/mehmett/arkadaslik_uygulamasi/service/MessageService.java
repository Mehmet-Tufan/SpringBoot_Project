package com.mehmett.arkadaslik_uygulamasi.service;

import com.mehmett.arkadaslik_uygulamasi.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {
	private final MessageRepository messageRepository;

	
}