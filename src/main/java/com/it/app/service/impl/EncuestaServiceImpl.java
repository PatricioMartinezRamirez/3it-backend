package com.it.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.app.models.EncuestaModel;
import com.it.app.repository.EncuestaRepository;
import com.it.app.service.EncuestaService;

@Service
public class EncuestaServiceImpl implements EncuestaService{
	
	@Autowired
	private EncuestaRepository repo;
	
	@Override
	public EncuestaModel registrar(EncuestaModel enc) {
		return repo.save(enc);
	}

	
	@Override 
	public List<EncuestaModel> listar() {
		return repo.findAll();
	}


	@Override
	public boolean existsEmailBD(String email) {
		return repo.existsByEmail(email);
	}

}
