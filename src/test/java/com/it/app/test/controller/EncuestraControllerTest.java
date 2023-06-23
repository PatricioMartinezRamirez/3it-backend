package com.it.app.test.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.it.app.controller.EncuestaController;
import com.it.app.exception.RequestException;
import com.it.app.models.EncuestaModel;
import com.it.app.service.EncuestaService;
import com.it.app.test.controller.mock.EncuestaMock;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class EncuestraControllerTest {
	
	@InjectMocks
	private EncuestaController encuestaController;
	
	@Mock
	private EncuestaService encuestaService;
	
	@SuppressWarnings("null")
	@Test
	public void listarEncuestasTest() {
		
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
       
        when(encuestaService.listar()).thenReturn(EncuestaMock.mockListaEncuestas());
        ResponseEntity<List<EncuestaModel>> responseEntity = encuestaController.listarEncuestas();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        
        when(encuestaService.listar()).thenReturn(EncuestaMock.mockListaEncuestas());
        ResponseEntity<List<EncuestaModel>> responseEntity2 = null;
        assertThat(responseEntity2.getStatusCodeValue()).isEqualTo(204);
	}
	
	@Test
	public void registrarTest() throws IOException {
		
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        EncuestaModel model = new EncuestaModel();
        model.setEmail("patricio@martinez1.cl");
        model.setGenero("Rock");
        
        if(encuestaService.existsEmailBD(model.getEmail())) throw new RequestException("El correo ingresado ya cuenta con una encuesta registrada.");
        
        when(encuestaService.registrar(model)).thenReturn(EncuestaMock.mockInsertarEncuesta());
        ResponseEntity <EncuestaModel> responseEntity = encuestaController.registrar(model);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
		
	}

}
