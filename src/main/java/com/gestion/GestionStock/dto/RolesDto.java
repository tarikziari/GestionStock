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
	
	private Integer identreprise ;
	
	
	public static RolesDto fromEntity(Roles roles) {
		if(roles == null) {
			return null;
		}
	return RolesDto.builder()
			.id(roles.getId())
			.roleName(roles.getRoleName())
			.utilisateur(UtilisateurDto.fromEntity(roles.getUtilisateur()))
			.identreprise(roles.getIdentreprise())
			.build();
	}


}
