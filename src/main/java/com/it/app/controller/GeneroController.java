package com.it.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.it.app.models.GeneroModel;
import com.it.app.service.GeneroService;

@RestController
@RequestMapping("/genero")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class GeneroController {
	
	@Autowired
	GeneroService service;
	
	
	@GetMapping("/listar-genero")
	public ResponseEntity<List<GeneroModel>> listarGenerosMusicales() {
		List<GeneroModel> lista = service.listar();
		return new ResponseEntity<List<GeneroModel>>(lista, lista.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
	}

}
