package com.mehmett.arkadaslik_uygulamasi.repository;

import com.mehmett.arkadaslik_uygulamasi.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {

}