package com.gestion.GestionStock.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gestion.GestionStock.dto.FournisseurDto;
import com.gestion.GestionStock.exception.EntityNotFoundException;
import com.gestion.GestionStock.exception.ErrorCodes;
import com.gestion.GestionStock.exception.InvalidEntityException;
import com.gestion.GestionStock.model.Fournisseur;
import com.gestion.GestionStock.repository.FournisseurRepository;
import com.gestion.GestionStock.services.FournisseurService;
import com.gestion.GestionStock.validator.FournisseurValidator;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {
	
	private FournisseurRepository fournisseurRepository;
	
	
	public FournisseurServiceImpl(FournisseurRepository fournisseurRepository) {
		this.fournisseurRepository = fournisseurRepository;
	} 

;
	
	
	@Override
	public FournisseurDto save(FournisseurDto fournisseurDto) {
		List<String> errors = FournisseurValidator.validate(fournisseurDto);
		if(!errors.isEmpty()) {
			
			log.error("Fournisseur is not valid {}  ",fournisseurDto);
			throw new InvalidEntityException("Fournisseur n'est pas Valid",ErrorCodes.FOURNISSEUR_NOT_VALID,errors);
		}
		return FournisseurDto.fromEntity(
				fournisseurRepository.save(
						FournisseurDto.toEntity(fournisseurDto)
				));
	}

	@Override
	public FournisseurDto finById(Integer id) {

		
		if(id==null) {
			log.error("Fournisseur ID is null");
		}
		Optional<Fournisseur> fournisseur=fournisseurRepository.findById(id);
				
		return Optional.of(FournisseurDto.fromEntity(fournisseur.get())).orElseThrow(() -> 
		
		new EntityNotFoundException(
				"Aucun Fournisseur avec l'ID =" + id + "n'a ete trouve dans la BDD",
				ErrorCodes.FOURNISSEUR_NOT_FOUND)
		);
	}

	
	@Override
	public List<FournisseurDto> findAll() {

		
		return fournisseurRepository.findAll().stream()
				.map(FournisseurDto::fromEntity)
				.collect(Collectors.toList());
		
	}

	
	
	@Override
	public void delete(Integer id) {
		
		if(id==null) {
			log.error("Fournisseur ID is null");
		}
		fournisseurRepository.deleteById(id);
		
	}

	
}
