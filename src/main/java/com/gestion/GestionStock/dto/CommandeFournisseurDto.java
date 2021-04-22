package com.gestion.GestionStock.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestion.GestionStock.model.CommandeFournisseur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandeFournisseurDto {

	private Integer id;
	
	private String code;
	
	private Instant dateCommande;
	
	private FournisseurDto fournisseur;
	
	@JsonIgnore
	private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;
	
	public static CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur) {
		if(commandeFournisseur == null) {
			return null;
		}
		return CommandeFournisseurDto.builder()
				.id(commandeFournisseur.getId())
				.code(commandeFournisseur.getCode())
				.dateCommande(commandeFournisseur.getDateCommande())
				.fournisseur(FournisseurDto.fromEntity(commandeFournisseur.getFournisseur()))
				.build();			
	  }
	public static CommandeFournisseur toEntity(CommandeFournisseurDto commandefournisseurDto) {
		if(commandefournisseurDto == null) {
			return null;
		}
		CommandeFournisseur commandefournsseur = new CommandeFournisseur();
		commandefournsseur.setId(commandefournisseurDto.getId());
		commandefournsseur.setCode(commandefournisseurDto.getCode());
		commandefournsseur.setDateCommande(commandefournisseurDto.getDateCommande());
		
		return commandefournsseur;

		
	}

}
