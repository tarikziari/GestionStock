package com.gestion.GestionStock.services;

import java.util.List;

import com.gestion.GestionStock.dto.CommandeClientDto;

public interface CommandeClientService {
	
	CommandeClientDto save(CommandeClientDto commandeClientDto);
	
	CommandeClientDto finById(Integer id);
	
	CommandeClientDto findByCode(String code);
	
	List<CommandeClientDto> findAll();
	
	void delete(Integer id);

}
