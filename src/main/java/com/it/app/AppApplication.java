package com.it.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.it.app.models.EncuestaModel;
import com.it.app.models.GeneroModel;
import com.it.app.repository.EncuestaRepository;
import com.it.app.repository.GeneroRepository;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
	
	
	@Bean
	public ApplicationRunner applicationRunner (GeneroRepository generoRepository, EncuestaRepository encuestaRepository) {
		
		return args -> {
			prepare(generoRepository, encuestaRepository);
		};
		
	}
	
	private void prepare(GeneroRepository generoRepository, EncuestaRepository encuestaRepository) {
		
		List<GeneroModel> generoModel= new ArrayList<>();
		generoModel.add(new GeneroModel(null,"Rock"));
		generoModel.add(new GeneroModel(null,"Jazz"));
		generoModel.add(new GeneroModel(null,"Country"));
		generoRepository.saveAll(generoModel);
		
		
		
		List<EncuestaModel> encuestaModel = new ArrayList<>();
		encuestaModel.add(new EncuestaModel(null,"example1@prueba.cl", "Rock"));
		encuestaRepository.saveAll(encuestaModel);
		
	}

}
