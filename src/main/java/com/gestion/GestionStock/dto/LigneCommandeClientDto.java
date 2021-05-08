package com.gestion.GestionStock.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestion.GestionStock.model.LigneCommandeClient;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class LigneCommandeClientDto {
	
	private Integer id;
	
	private ArticleDto article;
	
	@JsonIgnore
	private CommandeClientDto commandeClient;
	
	private BigDecimal quantite;
	
	private BigDecimal prixUnitaire;
	
	private Integer identreprise;

	public static LigneCommandeClientDto fromEntity(LigneCommandeClient lignecommandeclient) {
		
		if(lignecommandeclient == null) {
			return null;
		}
		
		return LigneCommandeClientDto.builder()
				.id(lignecommandeclient.getId())
				.article(ArticleDto.fromEntity(lignecommandeclient.getArticle()))
				.commandeClient(CommandeClientDto.fromEntity(lignecommandeclient.getCommandeClient()))
				.quantite(lignecommandeclient.getQuantite())
				.prixUnitaire(lignecommandeclient.getPrixUnitaire())
				.identreprise(lignecommandeclient.getIdentreprise())
				.build();		
	}
	public static LigneCommandeClient toEntity(LigneCommandeClientDto lignecommandeclientDto) {
		
		if(lignecommandeclientDto == null) {
			return null;
		}
		
		LigneCommandeClient lignecommandeclient = new LigneCommandeClient();
		lignecommandeclient.setId(lignecommandeclientDto.getId());
		//lignecommandeclient.setCommandeClient(CommandeClientDto.fromEntity(lignecommandeclientDto.getCommandeClient()));
		lignecommandeclient.setQuantite(lignecommandeclientDto.getQuantite());
		lignecommandeclient.setPrixUnitaire(lignecommandeclientDto.getQuantite());
		lignecommandeclient.setIdentreprise(lignecommandeclientDto.getIdentreprise());
		
		return lignecommandeclient;
	
	}
}
