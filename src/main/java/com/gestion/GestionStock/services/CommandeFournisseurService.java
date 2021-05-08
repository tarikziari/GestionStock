package com.gestion.GestionStock.services;

import java.util.List;

import com.gestion.GestionStock.dto.CommandeFournisseurDto;

public interface CommandeFournisseurService {
	
	CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto);
	
	CommandeFournisseurDto finById(Integer id);
	
	CommandeFournisseurDto findByCode(String code);
	
	List<CommandeFournisseurDto> findAll();
	
	void delete(Integer id);
	

}
