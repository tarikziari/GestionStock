package com.gestion.GestionStock.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestion.GestionStock.model.Fournisseur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FournisseurDto {
	
	private Integer id;
	
	private String Nom;
	
	private String Prenom;
	
	private AdresseDto adresse;
	
	private String photo;

	private String Mail;

	private String numTel;
	
	private Integer identreprise;
	
	@JsonIgnore
	private List<CommandeFournisseurDto> commandeFournisseur;

	public static FournisseurDto fromEntity(Fournisseur fournisseur) {
		if(fournisseur == null) {
			return null;
		}
		return FournisseurDto.builder()
				.id(fournisseur.getId())
				.Nom(fournisseur.getNom())
				.Prenom(fournisseur.getPrenom())
				.adresse(AdresseDto.fromEntity(fournisseur.getAdresse()))
				.photo(fournisseur.getPhoto())
				.Mail(fournisseur.getMail())
				.numTel(fournisseur.getNumTel())
				.identreprise(fournisseur.getIdentreprise())
				.build();
			}
	public static Fournisseur toEntity(FournisseurDto fournisseurDto) {
		if (fournisseurDto == null) {
			return null;
		}
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setId(fournisseurDto.getId());
		fournisseur.setNom(fournisseurDto.getNom());
		fournisseur.setPrenom(fournisseurDto.getPrenom());
		//fournisseur.setAdresse(fournisseurDto.getAdresse());
		fournisseur.setPhoto(fournisseurDto.photo);
		fournisseur.setIdentreprise(fournisseurDto.getIdentreprise());
		
		
		return fournisseur;
		
	}

	
}
