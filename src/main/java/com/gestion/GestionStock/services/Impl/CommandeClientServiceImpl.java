package com.gestion.GestionStock.services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gestion.GestionStock.dto.CommandeClientDto;
import com.gestion.GestionStock.dto.LigneCommandeClientDto;
import com.gestion.GestionStock.exception.EntityNotFoundException;
import com.gestion.GestionStock.exception.ErrorCodes;
import com.gestion.GestionStock.exception.InvalidEntityException;
import com.gestion.GestionStock.model.Article;
import com.gestion.GestionStock.model.Client;
import com.gestion.GestionStock.model.CommandeClient;
import com.gestion.GestionStock.model.LigneCommandeClient;
import com.gestion.GestionStock.repository.ArticleRepository;
import com.gestion.GestionStock.repository.ClientRepository;
import com.gestion.GestionStock.repository.CommandeClientRepository;
import com.gestion.GestionStock.repository.LigneCommandeClientRepository;
import com.gestion.GestionStock.services.CommandeClientService;
import com.gestion.GestionStock.validator.CommandeClientValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CommandeClientServiceImpl implements CommandeClientService{

	
	private CommandeClientRepository commandeClientRepository;
	private LigneCommandeClientRepository ligneCommandeClientRepository;
	private ClientRepository clientRepository;
	private ArticleRepository articleRepository;
	
	/**
	 * @param commandeClientRepository
	 * @param clientRepository
	 * @param articleRepository
	 */
	@Autowired
	public CommandeClientServiceImpl(CommandeClientRepository commandeClientRepository,ClientRepository clientRepository,
									ArticleRepository articleRepository,LigneCommandeClientRepository ligneCommandeClientRepositor) {
		
		this.commandeClientRepository = commandeClientRepository;
		this.clientRepository = clientRepository;
		this.articleRepository = articleRepository;
		this.ligneCommandeClientRepository=ligneCommandeClientRepositor;
		
	}
	
	@Override
	public CommandeClientDto save(CommandeClientDto commandeClientDto) {
		
			List<String> errors =CommandeClientValidator.validate(commandeClientDto);
			
			if(!errors.isEmpty()) {
				
				log.error("Commande client n'est pas valide");
				throw new InvalidEntityException("La commande client n'est pas valid",ErrorCodes.COMMANDE_CLIENT_NOT_VALID,errors);
				
			}
			
			Optional<Client> client =clientRepository.findById(commandeClientDto.getClient().getId());
			
			if(!client.isPresent()) {
				
				log.warn("Client with ID {} was not found in the DB",commandeClientDto.getClient().getId());
				throw new EntityNotFoundException("Aucun client avec l'ID"+ commandeClientDto.getClient().getId() +"n'a pas trouve dans la BDD",
						ErrorCodes.CLIENT_NOT_FOUND);
				
			}
			
			List<String> articleErrors = new ArrayList<String>();			
			if(commandeClientDto.getLigneCommandeClients() != null) {				
					commandeClientDto.getLigneCommandeClients().forEach(LigComdClt ->{						
						if( LigComdClt.getArticle() != null) {
							
							Optional<Article> article=articleRepository.findById(LigComdClt.getArticle().getId());							
							if(article.isEmpty()) {								
								articleErrors.add("L'article avec l'ID"+LigComdClt.getArticle().getId()+"n'existe pas");								
							}						
						}	else {							
							articleErrors.add("Impossible d'enregistrer une commande avec un articel NULL");							
						}
				} );
			}
			
			if(!articleErrors.isEmpty()) {				
				log.warn("Article n'existe pas dans la BDD");
				throw new InvalidEntityException("Article n'existe pas dans la BDD ",ErrorCodes.ARTICLE_NOT_FOUND,articleErrors);
				
			}
			
			CommandeClient  saveComdClt = commandeClientRepository.save(CommandeClientDto.toEntity(commandeClientDto));			
			commandeClientDto.getLigneCommandeClients().forEach(LigComdClt ->{				
				LigneCommandeClient  ligneCommandeClient = LigneCommandeClientDto.toEntity(LigComdClt);
				ligneCommandeClient.setCommandeClient(saveComdClt);
				ligneCommandeClientRepository.save(ligneCommandeClient);
				
			});
			
			return CommandeClientDto.fromEntity(saveComdClt);
		}

	
	
	@Override
	public CommandeClientDto finById(Integer id) {		
			if(id == null) {
				log.error("Commande client ID is NULL");				
			}
			
			return commandeClientRepository.findById(id)					
					.map(CommandeClientDto::fromEntity)
					.orElseThrow(() -> new EntityNotFoundException(
							"Aucun commande client n'a ete trouve avec L'ID " +id ,ErrorCodes.COMMANDE_CLIENT_NOT_FOUND							
							));
	}

	@Override
	public CommandeClientDto findByCode(String code) {		
			if(!StringUtils.hasLength(code)) {				
				log.error("Commande client  CODE is NULL");
				return null;
			}
					
			return commandeClientRepository.findCommandeClientBycode(code)					
					.map(CommandeClientDto::fromEntity)
					.orElseThrow(() -> new EntityNotFoundException(
							"Aucun commande client n'a ete trouve avec le CODE " +code ,ErrorCodes.COMMANDE_CLIENT_NOT_FOUND							
							));
	}

	@Override
	public List<CommandeClientDto> findAll() {		
			return commandeClientRepository.findAll().stream()
					.map(CommandeClientDto::fromEntity)
					.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		
			if(id == null) {				
				log.error("Commande client  ID is NULL");
				return;
			}
			commandeClientRepository.deleteById(id);
		}
		
	
}
