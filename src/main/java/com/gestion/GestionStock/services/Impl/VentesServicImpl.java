package com.gestion.GestionStock.services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gestion.GestionStock.dto.LigneVenteDto;
import com.gestion.GestionStock.dto.VentesDto;
import com.gestion.GestionStock.exception.EntityNotFoundException;
import com.gestion.GestionStock.exception.ErrorCodes;
import com.gestion.GestionStock.exception.InvalidEntityException;
import com.gestion.GestionStock.model.Article;
import com.gestion.GestionStock.model.LigneVente;
import com.gestion.GestionStock.model.Ventes;
import com.gestion.GestionStock.repository.ArticleRepository;
import com.gestion.GestionStock.repository.LigneVenteRepository;
import com.gestion.GestionStock.repository.VentesRepository;
import com.gestion.GestionStock.services.VentesService;
import com.gestion.GestionStock.validator.VentesValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class VentesServicImpl implements VentesService {

	private LigneVenteRepository ligneVentesRepository;
	private VentesRepository ventesRepository;
	private ArticleRepository articleRepository;
	
	/**
	 * @param ligneVentesRepository
	 * @param ventesRepository
	 * @param articleRepository
	 */
	@Autowired
	public VentesServicImpl(LigneVenteRepository ligneVentesRepository, VentesRepository ventesRepository,
			ArticleRepository articleRepository) {		
		this.ligneVentesRepository = ligneVentesRepository;
		this.ventesRepository = ventesRepository;
		this.articleRepository = articleRepository;
		
	}
		
	@Override
	public VentesDto save(VentesDto ventesDto) {		
		List<String> errors	=	VentesValidator.validate(ventesDto);		
		if(!errors.isEmpty()) {			
			log.error("Ventes n'est pas valide !");			
			throw new InvalidEntityException("L'objet Ventes  n'est pas valid",ErrorCodes.VENTE_NOT_VALID,errors);
		}
		
		List<String> articleError = new ArrayList<String>();		
		ventesDto.getLigneVente().forEach(ligneVent ->{			
			Optional<Article> article =articleRepository.findById(ligneVent.getArticle().getId());			
			if(article.isEmpty()) {				
				articleError.add("Aucun article avec l'ID" + ligneVent.getArticle().getId() +" n'a ete trouve dans la BDD ");
				}	
		});
		
		if(!articleError.isEmpty()) {
			log.error(" One or more error articles were not found in DB , {} ", errors);
			throw new InvalidEntityException("Un ou plusieurs Article n'a ete trouve dans la BDD ",ErrorCodes.VENTE_NOT_VALID,errors); 
		}		
		
		
		Ventes  saveVentes = ventesRepository.save(VentesDto.toEntity(ventesDto));
		
		ventesDto.getLigneVente().forEach(ligneVent ->{
			
			LigneVente  ligneVente = LigneVenteDto.toEntity(ligneVent);
			ligneVente.setVente(saveVentes);
			ligneVentesRepository.save(ligneVente);
		});
		
		return VentesDto.fromEnity(saveVentes);
	}
	
	
	@Override
	public VentesDto finById(Integer id) {
		if(id == null) {
			log.error("Vente ID is null");
			return null;
		}
			return ventesRepository.findById(id)					
					.map(VentesDto::fromEnity)
					.orElseThrow(() -> new EntityNotFoundException(
							"Aucun Vente n'a ete trouve dans la BDD  " +id ,ErrorCodes.VENTE_NOT_FOUND						
							));
		}
	

	@Override
	public VentesDto findByCode(String code) {
		
		if(!StringUtils.hasLength(code)) {				
			log.error(" Vente  CODE is NULL ");				
			return null;
		}
				
		return ventesRepository.findVentsByCode(code)				
				.map(VentesDto::fromEnity)
				.orElseThrow(() -> new EntityNotFoundException(
						"Aucun Vente n'a ete trouve avec le CODE " +code ,ErrorCodes.VENTE_NOT_FOUND							
						));
	}
	
	@Override
	public List<VentesDto> findAll() {
		return ventesRepository.findAll().stream()
				.map(VentesDto::fromEnity)
				.collect(Collectors.toList());
	}
	@Override
	public void delete(Integer id) {
		if(id == null) {				
			log.error(" Vnete  ID is NULL");				
			return;
		}			
		ventesRepository.deleteById(id);
		
	}
	
	
	
	
}
