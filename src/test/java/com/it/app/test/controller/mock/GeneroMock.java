package com.it.app.test.controller.mock;

import java.util.ArrayList;
import java.util.List;

import com.it.app.models.GeneroModel;



public class GeneroMock {
	
public static List<GeneroModel> mockListaEncuestas() {
		
		List<GeneroModel> result = new ArrayList<GeneroModel>();
		GeneroModel model = new GeneroModel();
		
		model.setId(1);
		model.setNombre("Rock");
		result.add(model);
		
		model.setId(2);
		model.setNombre("Blues");
		result.add(model);
		
		model.setId(2);
		model.setNombre("Jazz");
		result.add(model);
	
		
		return result;
		
	}

}
