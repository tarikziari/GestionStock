package com.gestion.GestionStock.services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gestion.GestionStock.dto.CommandeFournisseurDto;
import com.gestion.GestionStock.dto.LigneCommandeFournisseurDto;
import com.gestion.GestionStock.exception.EntityNotFoundException;
import com.gestion.GestionStock.exception.ErrorCodes;
import com.gestion.GestionStock.exception.InvalidEntityException;
import com.gestion.GestionStock.model.Article;
import com.gestion.GestionStock.model.CommandeFournisseur;
import com.gestion.GestionStock.model.Fournisseur;
import com.gestion.GestionStock.model.LigneCommandeFournisseur;
import com.gestion.GestionStock.repository.ArticleRepository;
import com.gestion.GestionStock.repository.CommandeFournisseurRepository;
import com.gestion.GestionStock.repository.FournisseurRepository;
import com.gestion.GestionStock.repository.LigneCommandeFournisseurRepository;
import com.gestion.GestionStock.services.CommandeFournisseurService;
import com.gestion.GestionStock.validator.CommandeFournisseurValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CommandeFournisseurServiceImpl implements CommandeFournisseurService {
	
	private CommandeFournisseurRepository commandeFournisseurRepository;
	private LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;
	private FournisseurRepository fournisseurRepository;
	private ArticleRepository articleRepository;
	
	
	/**
	 * @param commandeFournisseurRepository
	 * @param ligneCommandeFournisseurRepository
	 * @param fournisseurRepository
	 * @param articleRepository
	 */
	public CommandeFournisseurServiceImpl(CommandeFournisseurRepository commandeFournisseurRepository,
			LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository,
			FournisseurRepository fournisseurRepository, ArticleRepository articleRepository) {
		this.commandeFournisseurRepository = commandeFournisseurRepository;
		this.ligneCommandeFournisseurRepository = ligneCommandeFournisseurRepository;
		this.fournisseurRepository = fournisseurRepository;
		this.articleRepository = articleRepository;
	}

	@Override
	public CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto) {		
			List<String> errors =CommandeFournisseurValidator.validate(commandeFournisseurDto);			
			if(!errors.isEmpty()) {				
				log.error(" Commande Fournisseur n'est pas valide");
				throw new InvalidEntityException(" La commande Fournisseur n'est pas valid ",ErrorCodes.COMMANDE_FOURNISSSEUR_NOT_VALID,errors);				
			}
			
			Optional<Fournisseur> fournisseur =fournisseurRepository.findById(commandeFournisseurDto.getFournisseur().getId());			
			if(!fournisseur.isPresent()) {				
				log.warn(" Fournisseur with ID {} was not found in the DB",commandeFournisseurDto.getFournisseur().getId());
				throw new EntityNotFoundException(" Aucun fournisseur avec l'ID"+ commandeFournisseurDto.getFournisseur().getId() +" n'a pas trouve dans la BDD ",
						ErrorCodes.FOURNISSEUR_NOT_FOUND);				
			}
			
			List<String> articleErrors = new ArrayList<String>();
			
			if( commandeFournisseurDto.getLigneCommandeFournisseurs() != null ) {				
				commandeFournisseurDto.getLigneCommandeFournisseurs().forEach(LigComdClt ->{						
						if( LigComdClt.getArticle() != null) {							
							Optional<Article> article=articleRepository.findById(LigComdClt.getArticle().getId());							
							if(article.isEmpty()) {								
								articleErrors.add("L'article avec l'ID"+LigComdClt.getArticle().getId()+"n'existe pas");								
							}
							
						}	else {							
							articleErrors.add(" Impossible d'enregistrer une commande avec un article NULL");
							}
				} );
			}
			
			if(!articleErrors.isEmpty()) {				
				log.warn(" Article n'existe pas dans la BDD ");
				throw new InvalidEntityException(" Article n'existe pas dans la BDD ",ErrorCodes.ARTICLE_NOT_FOUND,articleErrors);				
			}
			
			CommandeFournisseur  saveComdFour = commandeFournisseurRepository.save(CommandeFournisseurDto.toEntity(commandeFournisseurDto));			
			commandeFournisseurDto.getLigneCommandeFournisseurs().forEach(LigComdFour ->{				
				LigneCommandeFournisseur  ligneCommandeFournisseur = LigneCommandeFournisseurDto.toEntity(LigComdFour);
				ligneCommandeFournisseur.setCommandeFournisseur(saveComdFour);
				ligneCommandeFournisseurRepository.save(ligneCommandeFournisseur);				
			});			
			return CommandeFournisseurDto.fromEntity(saveComdFour);
		}

	
	@Override
	public CommandeFournisseurDto finById(Integer id) {		
			if(id == null) {				
				log.error(" Commande fournisseur ID is NULL ");			
			}
			
			return commandeFournisseurRepository.findById(id)					
					.map(CommandeFournisseurDto::fromEntity)
					.orElseThrow(() -> new EntityNotFoundException(
							"Aucun commande fournisseur n'a ete trouve avec L'ID " +id ,ErrorCodes.COMMANDE_FOURNISSSEUR_NOT_FOUND							
							));
	}

	@Override
	public CommandeFournisseurDto findByCode(String code) {		
			if(!StringUtils.hasLength(code)) {				
				log.error(" Commande fournisseur  CODE is NULL ");				
				return null;
			}
					
			return commandeFournisseurRepository.findCommandeFournisseurBycode(code)					
					.map(CommandeFournisseurDto::fromEntity)
					.orElseThrow(() -> new EntityNotFoundException(
							"Aucun commande fournisseur n'a ete trouve avec le CODE " +code ,ErrorCodes.COMMANDE_FOURNISSSEUR_NOT_FOUND							
							));
	}

	@Override
	public List<CommandeFournisseurDto> findAll() {		
			return commandeFournisseurRepository.findAll().stream()
					.map(CommandeFournisseurDto::fromEntity)
					.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {		
			if(id == null) {				
				log.error("Commande fournisseur  ID is NULL");				
				return;
			}			
			commandeFournisseurRepository.deleteById(id);
		}
		
	

}
