package com.gestion.GestionStock.services;

import java.util.List;

import com.gestion.GestionStock.dto.UtilisateurDto;

public interface UtilisateurService {

	UtilisateurDto save(UtilisateurDto utilisateurDto);
	
	UtilisateurDto finById(Integer id);
		
	List<UtilisateurDto> findAll();
	
	void delete(Integer id);
}
