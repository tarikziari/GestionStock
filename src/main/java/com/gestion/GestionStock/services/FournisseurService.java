package com.gestion.GestionStock.services;

import java.util.List;

import com.gestion.GestionStock.dto.FournisseurDto;

public interface FournisseurService {

	
	FournisseurDto save(FournisseurDto fournisseurDto);
	
	FournisseurDto finById(Integer id);
		
	List<FournisseurDto> findAll();
	
	void delete(Integer id);
}
