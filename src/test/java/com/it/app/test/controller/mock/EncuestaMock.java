package com.it.app.test.controller.mock;

import java.util.ArrayList;
import java.util.List;

import com.it.app.models.EncuestaModel;


public class EncuestaMock {

	public static List<EncuestaModel> mockListaEncuestas() {
		
		List<EncuestaModel> result = new ArrayList<EncuestaModel>();
		EncuestaModel model = new EncuestaModel();
		
		model.setId(1);
		model.setEmail("patricio@martinez.cl");
		model.setGenero("Rock");
		result.add(model);
		
		model.setId(2);
		model.setEmail("patricio2@martinez.cl");
		model.setGenero("Blues");
		result.add(model);
		
		model.setId(2);
		model.setEmail("patricio3@martinez.cl");
		model.setGenero("Jazz");
		result.add(model);
	
		
		return result;
		
	}
	
public static EncuestaModel mockInsertarEncuesta() {
		
		EncuestaModel model = new EncuestaModel();
		
		model.setId(1);
		model.setEmail("patricio@martinez.cl");
		model.setGenero("Rock");
		
		return model;
		
	}
	
}
