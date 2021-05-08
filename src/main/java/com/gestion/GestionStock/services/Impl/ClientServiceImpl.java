package com.gestion.GestionStock.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gestion.GestionStock.dto.ClientDto;
import com.gestion.GestionStock.exception.EntityNotFoundException;
import com.gestion.GestionStock.exception.ErrorCodes;
import com.gestion.GestionStock.exception.InvalidEntityException;
import com.gestion.GestionStock.model.Client;
import com.gestion.GestionStock.repository.ClientRepository;
import com.gestion.GestionStock.services.ClientService;
import com.gestion.GestionStock.validator.ClientValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService{
	
	private ClientRepository clientRepository;


	public ClientServiceImpl(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Override
	public ClientDto save(ClientDto clientDto) {
		
		List<String> errors = ClientValidator.validate(clientDto);
		if(!errors.isEmpty()) {
			
			log.error("Client is not valid {}  ",clientDto);
			throw new InvalidEntityException("Client n'est pas Valid",ErrorCodes.CLIENT_NOT_VALID,errors);
		}
		return ClientDto.fromEntity(
				clientRepository.save(
						ClientDto.toEntity(clientDto)
				));
	}

	@Override
	public ClientDto finById(Integer id) {
		if(id==null) {
			log.error("Article ID is null");
		}
		Optional<Client> client=clientRepository.findById(id);
				
		return Optional.of(ClientDto.fromEntity(client.get())).orElseThrow(() -> 
		
		new EntityNotFoundException(
				"Aucun Client avec l'ID =" + id + "n'a ete trouve dans la BDD",
				ErrorCodes.CLIENT_NOT_FOUND)
		);
	}

	@Override
	public List<ClientDto> findAll() {
	
		return clientRepository.findAll().stream()
				.map(ClientDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if(id==null) {
			log.error("Client ID is null");
		}
		clientRepository.deleteById(id);
		
	}
	

}
