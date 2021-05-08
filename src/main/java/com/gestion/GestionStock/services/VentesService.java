package com.gestion.GestionStock.services;

import java.util.List;

import com.gestion.GestionStock.dto.VentesDto;



public interface VentesService {

	
	
	VentesDto save(VentesDto ventesDto);
	
	VentesDto finById(Integer id);
	
	VentesDto findByCode(String code);
	
	List<VentesDto> findAll();
	
	void delete(Integer id);

	
}
