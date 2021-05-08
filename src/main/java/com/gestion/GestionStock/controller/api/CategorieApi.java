package com.gestion.GestionStock.controller.api;

import static com.gestion.GestionStock.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gestion.GestionStock.dto.CategorieDto;

public interface CategorieApi {

	@PostMapping(value=APP_ROOT+"/categorie/create", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	
	CategorieDto save(@RequestBody CategorieDto dto);
	
	@GetMapping(value=APP_ROOT+"/categorie/{idCategorie}",produces=MediaType.APPLICATION_JSON_VALUE)
	CategorieDto finById(@PathVariable("idCategorie") Integer id);
	
	@GetMapping(value=APP_ROOT+"/categorie/{code}",produces=MediaType.APPLICATION_JSON_VALUE)
	CategorieDto findByCode(@PathVariable("code") String code);
	
	@GetMapping(value=APP_ROOT+"/categorie/all",produces=MediaType.APPLICATION_JSON_VALUE)
	List<CategorieDto> findAll();
	
	@DeleteMapping(value=APP_ROOT+"/categorie/delete/{idCategorie}")
	void delete(@PathVariable("idCategorie") Integer id);
}
