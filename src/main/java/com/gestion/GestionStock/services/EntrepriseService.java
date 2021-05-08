package com.gestion.GestionStock.services;

import java.util.List;

import com.gestion.GestionStock.dto.EntrepriseDto;

public interface EntrepriseService {
	
	EntrepriseDto save(EntrepriseDto entrepriseDto);
	
	EntrepriseDto finById(Integer id);
		
	List<EntrepriseDto> findAll();
	
	void delete(Integer id);

}
