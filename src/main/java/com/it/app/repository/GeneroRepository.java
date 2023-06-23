package com.it.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.app.models.GeneroModel;

@Transactional
@Repository
public interface GeneroRepository extends JpaRepository<GeneroModel, Integer>{

}
