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
	
	public static LigneVenteDto fromEntity(LigneVente lignevente) {
		if(lignevente ==  null) {
			return null;
		}
		return LigneVenteDto.builder()
				.id(lignevente.getId())
				.vente(VentesDto.fromEnity(lignevente.getVente()))
				.quantite(lignevente.getQuantite())	
				.prixUnitaire(lignevente.getPrixUnitaire())
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
		return lignevente;
		
		
	}
	
}
