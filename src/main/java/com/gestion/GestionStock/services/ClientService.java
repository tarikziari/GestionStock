package com.gestion.GestionStock.services;

import java.util.List;

import com.gestion.GestionStock.dto.ClientDto;

public interface ClientService {
	
	ClientDto save(ClientDto clientDto);
	
	ClientDto finById(Integer id);
		
	List<ClientDto> findAll();
	
	void delete(Integer id);

}
