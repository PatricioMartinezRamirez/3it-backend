package com.it.app.test.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.it.app.controller.GeneroController;
import com.it.app.models.GeneroModel;
import com.it.app.service.GeneroService;
import com.it.app.test.controller.mock.GeneroMock;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class GeneroControllerTest {

	
	@InjectMocks
	private GeneroController generoController;
	
	
	@Mock
	private GeneroService generoService;
	
	
	@SuppressWarnings("null")
	public void listarGenerosMusicalesTest() {
		
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
       
        when(generoService.listar()).thenReturn(GeneroMock.mockListaEncuestas());
        ResponseEntity<List<GeneroModel>> responseEntity = generoController.listarGenerosMusicales();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        
        when(generoService.listar()).thenReturn(GeneroMock.mockListaEncuestas());
        ResponseEntity<List<GeneroModel>> responseEntity2 = null;
        assertThat(responseEntity2.getStatusCodeValue()).isEqualTo(204);
	}
}
