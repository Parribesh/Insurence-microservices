package com.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.domain.Inquiry;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {

}
