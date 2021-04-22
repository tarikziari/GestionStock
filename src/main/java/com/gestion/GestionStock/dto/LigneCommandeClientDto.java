package com.gestion.GestionStock.dto;

import java.math.BigDecimal;

import com.gestion.GestionStock.model.LigneCommandeClient;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class LigneCommandeClientDto {
	
	private Integer id;
	
	private ArticleDto article;
	
	private CommandeClientDto commandeClient;
	
	private BigDecimal quantite;
	
	private BigDecimal prixUnitaire;

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
				.build();		
	}
	public static LigneCommandeClient toEntity(LigneCommandeClientDto lignecommandeclientDto) {
		if(lignecommandeclientDto == null) {
			return null;
		}
		LigneCommandeClient lignecommandeclient = new LigneCommandeClient();
		lignecommandeclient.setId(lignecommandeclient.getId());
		//lignecommandeclient.setCommandeClient(CommandeClientDto.fromEntity(lignecommandeclientDto.getCommandeClient()));
		lignecommandeclient.setQuantite(lignecommandeclient.getQuantite());
		lignecommandeclient.setPrixUnitaire(lignecommandeclient.getQuantite());
		return lignecommandeclient;
	
	}
}
