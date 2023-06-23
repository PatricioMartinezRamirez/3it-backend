package com.it.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface CrudService<T> {
	
	T registrar(T obj);
	List<T> listar();

}
