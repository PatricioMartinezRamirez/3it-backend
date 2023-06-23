package com.it.app.service;

import org.springframework.stereotype.Service;

import com.it.app.models.EncuestaModel;

@Service
public interface EncuestaService  extends CrudService<EncuestaModel>{

	boolean existsEmailBD(String email);
	
	

}
