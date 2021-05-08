package com.gestion.GestionStock.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestion.GestionStock.model.Entreprise;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntrepriseDto {
	
	private Integer id;
	
	private String nom;
	
	private String description;
	
	private AdresseDto adresse;
	
	private String codeFiscal;
	
	private String email;
	
	private String numTel;
	
	private String siteWeb;
	
	private Integer identreprise;
	@JsonIgnore
	private List<UtilisateurDto> utilisateurs;
	
	public static EntrepriseDto fromEntity(Entreprise entreprise) {
		if (entreprise == null) {
			return null;
		}
		return EntrepriseDto.builder()
				.id(entreprise.getId())
				.nom(entreprise.getNom())
				.description(entreprise.getDescription())
				.adresse(AdresseDto.fromEntity(entreprise.getAdresse()))
				.codeFiscal(entreprise.getCodeFiscal())
				.email(entreprise.getEmail())
				.numTel(entreprise.getNumTel())
				.siteWeb(entreprise.getSiteWeb())
				.identreprise(entreprise.getIdentreprise())
				.build();		
	}
	
	
	
	public	static Entreprise toEntity(EntrepriseDto entrepriseDto) {
		if(entrepriseDto == null) {
			return null;
		}
		
		Entreprise entreprise=new Entreprise();
		entreprise.setId(entrepriseDto.getId());
		entreprise.setNumTel(entrepriseDto.getNom());
		entreprise.setDescription(entrepriseDto.getDescription());
		entreprise.setCodeFiscal(entrepriseDto.getCodeFiscal());
		entreprise.setEmail(entrepriseDto.getEmail());
		entreprise.setNumTel(entreprise.getNumTel());
		entreprise.setSiteWeb(entrepriseDto.getSiteWeb());
		entreprise.setIdentreprise(entrepriseDto.getIdentreprise());
		
		return entreprise;
		
	}
}
