package com.gestion.GestionStock.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gestion.GestionStock.dto.CategorieDto;
import com.gestion.GestionStock.exception.EntityNotFoundException;
import com.gestion.GestionStock.exception.ErrorCodes;
import com.gestion.GestionStock.exception.InvalidEntityException;
import com.gestion.GestionStock.model.Categorie;
import com.gestion.GestionStock.repository.CategorieRepository;
import com.gestion.GestionStock.services.CategorieService;
import com.gestion.GestionStock.validator.CategorieValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategorieServiceImpl implements CategorieService{
	
	private CategorieRepository categorieRepository;
	
	
	public CategorieServiceImpl(CategorieRepository categorieRepository){
		this.categorieRepository=categorieRepository;
	}
	
	@Override
	public CategorieDto save(CategorieDto Categoriedto) {
		
		List<String> errors = CategorieValidator.validate(Categoriedto);
		if(!errors.isEmpty()) {
			log.error("Categorie is not valid {}  ",Categoriedto);
			throw new InvalidEntityException("Categorie n'est pas Valid",ErrorCodes.CATEGORIE_NOT_VALID,errors);
		}
		return CategorieDto.fromEntity(
				categorieRepository.save(
						CategorieDto.toEntity(Categoriedto)
				));
	}
	
	@Override
	public CategorieDto finById(Integer id) {
		if(id==null) {
			log.error("Article ID is null");
		}
		Optional<Categorie> categorie=categorieRepository.findById(id);
				
		return Optional.of(CategorieDto.fromEntity(categorie.get())).orElseThrow(() -> 
		
		new EntityNotFoundException(
				"Aucun Categorie avec l'ID =" + id + "n'a ete trouve dans la BDD",
				ErrorCodes.CATEGORIE_NOT_FOUND)
		);
	}

	@Override
	public CategorieDto findByCode(String code) {
		
		if(StringUtils.hasLength(code)) {
			log.error("Article CODE is null");
			return null;
		}
		
		Optional<Categorie> categorie=categorieRepository.findCategorieByCode(code);
				
				return Optional.of(CategorieDto.fromEntity(categorie.get())).orElseThrow(() -> 
				new EntityNotFoundException(
						"Aucun Categorie avec le CODE =" + code + "n'a ete trouve dans la BDD",
						ErrorCodes.CATEGORIE_NOT_FOUND)
				);
	}

	@Override
	public List<CategorieDto> findAll() {
		return categorieRepository.findAll().stream()
				.map(CategorieDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if(id==null) {
			log.error("Categorie ID is null");
			return;
		}
		categorieRepository.deleteById(id);
		
	}
	
	
}
