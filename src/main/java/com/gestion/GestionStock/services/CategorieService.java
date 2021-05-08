package com.gestion.GestionStock.services;

import java.util.List;


import com.gestion.GestionStock.dto.CategorieDto;

public interface CategorieService {

	CategorieDto save(CategorieDto Categoriedto);
	
	CategorieDto finById(Integer id);
	
	CategorieDto findByCode(String code);
	
	List<CategorieDto> findAll();
	
	void delete(Integer id);
}
