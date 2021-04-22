package com.gestion.GestionStock.dto;

import com.gestion.GestionStock.model.Roles;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class RolesDto {
	
	private Integer id;
	
	private String roleName;
	
	private UtilisateurDto utilisateur;
	
	public static UtilisateurDto fromEntity(Roles roles) {
		if(roles == null) {
			return null;
		}
		return 	 UtilisateurDto.builder()
				.id(roles.getId())
				.utilisateur(UtilisateurDto.fromEntity(roles.getUtilisateur()))
				.build();
	}


}
