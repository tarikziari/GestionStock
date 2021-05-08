package com.gestion.GestionStock.dto;


import java.math.BigDecimal;

import com.gestion.GestionStock.model.LigneVente;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LigneVenteDto {
	
	private Integer id;
	
	private VentesDto vente;

	private BigDecimal quantite;
	
	private BigDecimal prixUnitaire;
	
	private ArticleDto article;
	
	private Integer identreprise ;
	
	public static LigneVenteDto fromEntity(LigneVente ligneVente) {
		if(ligneVente ==  null) {
			return null;
		}
		return LigneVenteDto.builder()
				.id(ligneVente.getId())
				.vente(VentesDto.fromEnity(ligneVente.getVente()))
				.quantite(ligneVente.getQuantite())	
				.prixUnitaire(ligneVente.getPrixUnitaire())
				.identreprise(ligneVente.getIdentreprise())
				.build();
		}
	public static LigneVente toEntity(LigneVenteDto ligneventeDto) {
		
		if (ligneventeDto == null) {
			return null;
		}
		LigneVente lignevente =new LigneVente();
		lignevente.setId(ligneventeDto.getId());
		//lignevente.setVente(ligneventeDto.getVente());
		lignevente.setQuantite(ligneventeDto.getQuantite());
		lignevente.setPrixUnitaire(ligneventeDto.getPrixUnitaire());
		lignevente.setIdentreprise(ligneventeDto.getIdentreprise());
		
		return lignevente;
		
		
	}

	

	
}
