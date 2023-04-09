package com.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.domain.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
