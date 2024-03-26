package com.example.demo.model;

import java.util.List;

import com.example.demo.entity.Person;

import lombok.Data;

@Data
public class CustomResponse<E> {
	
	boolean status;
	String mensaje;
	List<E> data;
	
	public CustomResponse(boolean status, String mensaje, List<Person> data) {
		super();
		this.status = status;
		this.mensaje = mensaje;
		this.data = (List<E>) data;
	}

	
	

}
