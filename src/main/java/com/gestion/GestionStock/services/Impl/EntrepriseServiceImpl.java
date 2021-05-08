package com.gestion.GestionStock.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gestion.GestionStock.dto.EntrepriseDto;
import com.gestion.GestionStock.exception.EntityNotFoundException;
import com.gestion.GestionStock.exception.ErrorCodes;
import com.gestion.GestionStock.exception.InvalidEntityException;
import com.gestion.GestionStock.model.Entreprise;
import com.gestion.GestionStock.repository.EntrepriseRepository;
import com.gestion.GestionStock.services.EntrepriseService;
import com.gestion.GestionStock.validator.EntrepriseValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {
	
	private EntrepriseRepository entrepriseRepository;
	 
	public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository) {
		this.entrepriseRepository = entrepriseRepository;
	}

	
	
	
	@Override
	public EntrepriseDto save(EntrepriseDto entrepriseDto) {

		List<String> errors = EntrepriseValidator.validate(entrepriseDto);
		if(!errors.isEmpty()) {
			
			log.error("Entreprise is not valid {}  ",entrepriseDto);
			throw new InvalidEntityException("Entreprise n'est pas Valid",ErrorCodes.ENTREPRISE_NOT_VALID,errors);
		}
		return EntrepriseDto.fromEntity(
				entrepriseRepository.save(
						EntrepriseDto.toEntity(entrepriseDto)
				));
	}

	@Override
	public EntrepriseDto finById(Integer id) {

		if(id==null) {
			log.error("Entreprise ID is null");
		}
		Optional<Entreprise> entreprise=entrepriseRepository.findById(id);
				
		return Optional.of(EntrepriseDto.fromEntity(entreprise.get())).orElseThrow(() -> 
		
		new EntityNotFoundException(
				"Aucun Entreprise avec l'ID =" + id + "n'a ete trouve dans la BDD",
				ErrorCodes.ENTREPRISE_NOT_FOUND)
		);
	}

	
	@Override
	public List<EntrepriseDto> findAll() {


		return entrepriseRepository.findAll().stream()
				.map(EntrepriseDto::fromEntity)
				.collect(Collectors.toList());
		
		
	}

	
	@Override
	public void delete(Integer id) {
		
		if(id==null) {
			log.error("Entreprise ID is null");
		}
		entrepriseRepository.deleteById(id);
		
	}
	
	

	
}
