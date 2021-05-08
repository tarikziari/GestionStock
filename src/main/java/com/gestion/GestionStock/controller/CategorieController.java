package com.gestion.GestionStock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gestion.GestionStock.controller.api.CategorieApi;
import com.gestion.GestionStock.dto.CategorieDto;
import com.gestion.GestionStock.services.CategorieService;

public class CategorieController implements CategorieApi {
	
	private CategorieService  categorieService;
	
	@Autowired
	public CategorieController(CategorieService categorieService) {
		this.categorieService = categorieService;
	}

	public CategorieService getCategorieService() {
		return categorieService;
	}
	
	@Override
	public CategorieDto save(CategorieDto dto) {
		return categorieService.save(dto);
	}

	@Override
	public CategorieDto finById(Integer id) {
		return categorieService.finById(id);
	}

	@Override
	public CategorieDto findByCode(String code) {
		
		return categorieService.findByCode(code);
	}

	@Override
	public List<CategorieDto> findAll() {
		return categorieService.findAll();
	}

	@Override
	public void delete(Integer id) {
		categorieService.delete(id);
	
		
	}
	
	

}
