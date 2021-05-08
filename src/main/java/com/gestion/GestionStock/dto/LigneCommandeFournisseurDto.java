package com.gestion.GestionStock.dto;

import java.math.BigDecimal;

import com.gestion.GestionStock.model.LigneCommandeFournisseur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeFournisseurDto {
	
	private Integer id;
	
	private ArticleDto article;
	
	private CommandeFournisseurDto commandeFournisseur;
	
	private BigDecimal quantite;
	
	private BigDecimal prixUnitaire;
	
	private Integer identreprise ;
	
	public static LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur lignecommandeFournisseur) {
		
		if(lignecommandeFournisseur == null) {
			return null;
		}
		
		return LigneCommandeFournisseurDto.builder()
				.id(lignecommandeFournisseur.getId())
				.article(ArticleDto.fromEntity(lignecommandeFournisseur.getArticle()))
				.commandeFournisseur(CommandeFournisseurDto.fromEntity(lignecommandeFournisseur.getCommandeFournisseur()))
				.quantite(lignecommandeFournisseur.getQuantite())
				.prixUnitaire(lignecommandeFournisseur.getPrixUnitaire())
				.identreprise(lignecommandeFournisseur.getIdentreprise())
				.build();		
	}
	public static LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDto lignecommandeFournisseurDto) {
		
		if(lignecommandeFournisseurDto == null) {
			return null;
		}
		
		LigneCommandeFournisseur lignecommandeFournisseur = new LigneCommandeFournisseur();
		lignecommandeFournisseur.setId(lignecommandeFournisseurDto.getId());
		//lignecommandeFournisseur.setCommandeClient(lignecommandeFournisseur.fromEntity(lignecommandeFournisseurDto.getCommandeFournisseur()));
		lignecommandeFournisseur.setQuantite(lignecommandeFournisseurDto.getQuantite());
		lignecommandeFournisseur.setPrixUnitaire(lignecommandeFournisseurDto.getQuantite());
		lignecommandeFournisseur.setIdentreprise(lignecommandeFournisseurDto.getIdentreprise());
		
		return lignecommandeFournisseur;
	
	}

}
