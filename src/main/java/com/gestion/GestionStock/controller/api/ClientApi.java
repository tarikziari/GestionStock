package com.gestion.GestionStock.controller.api;

import static com.gestion.GestionStock.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gestion.GestionStock.dto.ClientDto;



public interface ClientApi {

	@PostMapping(value=APP_ROOT+"/clients/create", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	
	ClientDto save(@RequestBody ClientDto dto);
	
	@GetMapping(value=APP_ROOT+"/clients/{idClient}",produces=MediaType.APPLICATION_JSON_VALUE)
	ClientDto finById(@PathVariable("idClient") Integer id);
	
	 
	@GetMapping(value=APP_ROOT+"/clients/all",produces=MediaType.APPLICATION_JSON_VALUE)
	List<ClientDto> findAll();
	
	@DeleteMapping(value=APP_ROOT+"/clients/delete/{idClient}")
	void delete(@PathVariable("idClient") Integer id);
}
