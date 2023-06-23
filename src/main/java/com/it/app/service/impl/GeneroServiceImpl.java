package com.it.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.app.models.GeneroModel;
import com.it.app.repository.GeneroRepository;
import com.it.app.service.GeneroService;

@Service
public class GeneroServiceImpl implements GeneroService{
	
	@Autowired
	private GeneroRepository repo;
	
	@Override
	public GeneroModel registrar(GeneroModel gen) {
		return repo.save(gen);
	}

	
	@Override 
	public List<GeneroModel> listar() {
		return repo.findAll();
	}
}
