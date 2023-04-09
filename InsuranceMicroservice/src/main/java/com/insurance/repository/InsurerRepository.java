package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.domain.Insurer;

public interface InsurerRepository extends JpaRepository<Insurer, Long> {

	Insurer findByInsurerEmail(String insurerEmail);

}
