package com.it.app.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.it.app.exception.RequestException;
import com.it.app.models.EncuestaModel;
import com.it.app.service.EncuestaService;



@RestController
@RequestMapping("/encuesta")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class EncuestaController {
	
	@Autowired
	EncuestaService service;
	
	
	@GetMapping("/listar-encuestas")
	public ResponseEntity<List<EncuestaModel>> listarEncuestas() {
		List<EncuestaModel> lista = service.listar();
		return new ResponseEntity<List<EncuestaModel>>(lista, lista.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
	}

	
	@PostMapping("/guardar-encuesta")
	public ResponseEntity<EncuestaModel> registrar(@Valid @RequestBody EncuestaModel encuesta) throws IOException {
		if(service.existsEmailBD(encuesta.getEmail())) throw new RequestException("El correo ingresado ya cuenta con una encuesta registrada.");
		EncuestaModel em = service.registrar(encuesta);
			return new ResponseEntity<>(em , HttpStatus.CREATED);
		

	}

}
