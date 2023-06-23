package com.it.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.app.models.EncuestaModel;

@Transactional
@Repository
public interface EncuestaRepository extends JpaRepository<EncuestaModel, Integer>{
	
	boolean existsByEmail(String email);

}
