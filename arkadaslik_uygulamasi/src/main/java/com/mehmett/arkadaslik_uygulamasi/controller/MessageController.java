package com.mehmett.arkadaslik_uygulamasi.controller;

import com.mehmett.arkadaslik_uygulamasi.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DİKKAT!!!!
 *
 */
@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {
	
	private final MessageService messageService;
	
}