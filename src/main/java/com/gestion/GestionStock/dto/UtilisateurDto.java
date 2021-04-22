package com.gestion.GestionStock.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.gestion.GestionStock.model.Roles;
import com.gestion.GestionStock.model.Utilisateur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UtilisateurDto {
	
	private Integer id;
	
	private String nom;
	
	private String prenom;
	
	private String email;
	
	private String DateDeNaissance;
	
	private String motDePass;
	
	private AdresseDto adresse;
	
	private String photo;
	
	private EntrepriseDto entreprise;
	
	private List<RolesDto> roles;
	
	public static UtilisateurDto fromEntity(Utilisateur utilisateur){
		if(utilisateur == null) {
			return null;
		}
		
		
		return UtilisateurDto.builder()			
				.id(utilisateur.getId())
				.nom(utilisateur.getNom())
				.prenom(utilisateur.getPrenom())
				.email(utilisateur.getEmail())
				.motDePass(utilisateur.getMotDePass())
				.DateDeNaissance(utilisateur.getDateDeNaissance())
				.adresse(AdresseDto.fromEntity(utilisateur.getAdresse()))
				.photo(utilisateur.getPrenom())
				.entreprise(EntrepriseDto.fromEntity(utilisateur.getEntreprise()))
				.roles(
						utilisateur.getRoles() != null ?
								utilisateur.getRoles().stream()
								.map(RolesDto::fromEntity)
								.collect(Collectors.toList()) : null
								)
						
				.build();
		
	
				
	}

	
}
