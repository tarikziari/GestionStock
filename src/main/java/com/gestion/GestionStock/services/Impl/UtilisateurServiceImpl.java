package com.gestion.GestionStock.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gestion.GestionStock.dto.UtilisateurDto;
import com.gestion.GestionStock.exception.EntityNotFoundException;
import com.gestion.GestionStock.exception.ErrorCodes;
import com.gestion.GestionStock.exception.InvalidEntityException;
import com.gestion.GestionStock.model.Utilisateur;
import com.gestion.GestionStock.repository.UtilisateurRepository;
import com.gestion.GestionStock.services.UtilisateurService;
import com.gestion.GestionStock.validator.UtilisateurValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {
	
	private UtilisateurRepository utilisateurRepository;
	
	public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	} 
	
	@Override
	public UtilisateurDto save(UtilisateurDto utilisateurDto) {
		
		List<String> errors = UtilisateurValidator.validate(utilisateurDto);
		if(!errors.isEmpty()) {
			
			log.error("Utilisateur is not valid {}  ",utilisateurDto);
			throw new InvalidEntityException("Utilisateur n'est pas Valid",ErrorCodes.UTILISATEUR_NOT_VALID,errors);
		}
		return UtilisateurDto.fromEntity(
				utilisateurRepository.save(
						UtilisateurDto.toEntity(utilisateurDto)
				));
	}

	@Override
	public UtilisateurDto finById(Integer id) {
	
		if(id==null) {
			log.error("Utilisateur ID is null");
		}
		Optional<Utilisateur> utilisateur=utilisateurRepository.findById(id);
				
		return Optional.of(UtilisateurDto.fromEntity(utilisateur.get())).orElseThrow(() -> 
		
		new EntityNotFoundException(
				"Aucun Utilisateur avec l'ID =" + id + "n'a ete trouve dans la BDD",
				ErrorCodes.UTILISATEUR_NOT_FOUND)
		);
	}

	@Override
	public List<UtilisateurDto> findAll() {

		
		return utilisateurRepository.findAll().stream()
				.map(UtilisateurDto::fromEntity)
				.collect(Collectors.toList());
		
	}

	@Override
	public void delete(Integer id) {
		
		
		if(id==null) {
			log.error("Utilisateur ID is null");
		}
		utilisateurRepository.deleteById(id);
		
		
	}
	
	

}
