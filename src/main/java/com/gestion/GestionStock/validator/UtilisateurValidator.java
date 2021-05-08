package com.gestion.GestionStock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.gestion.GestionStock.dto.UtilisateurDto;

public class UtilisateurValidator {
	
	public static List<String> validate(UtilisateurDto utilisateurDto){
		List<String> errors =new ArrayList<>();
		
		if(utilisateurDto == null) {
			errors.add("Veuillez renseigner le Nom d'utilisateur ");
			errors.add("Veuillez renseigner le prenom d'utilisateur ");
			errors.add("Veuillez renseigner le mot de passe d'utilisateur ");
			errors.add("Veuillez renseigner l'adresse d'utilisateur ");
			return errors;
		}
		
		if (!StringUtils.hasLength(utilisateurDto.getNom()))
		{
			errors.add("Veuillez renseigner le Nom d'utilisateur ");
		}
		if (!StringUtils.hasLength(utilisateurDto.getPrenom()))
		{
			errors.add("Veuillez renseigner le prenom d'utilisateur ");
		}
		if (!StringUtils.hasLength(utilisateurDto.getEmail()))
		{
			errors.add("Veuillez renseigner l'email de l'utilisateur ");
		}
		
		if (!StringUtils.hasLength(utilisateurDto.getMotDePass()))
		{
			errors.add("Veuillez renseigner le mot de passe d'utilisateur ");
		}
		if (utilisateurDto.getDateDeNaissance() == null) {
			errors.add("veuillez renseiger la date de naissance de l'utilisateur");
		}
		if (utilisateurDto.getAdresse() == null)
		{
			errors.add("Veuillez renseigner l'adresse d'utilisateur ");
		}else
		{
			if (!StringUtils.hasLength(utilisateurDto.getAdresse().getAdresse1()))
			{
				errors.add("Le champ 'Adresse 1' et obligatoire ");
			}
			if (!StringUtils.hasLength(utilisateurDto.getAdresse().getVille()))
			{
				errors.add("Le champ 'ville' et obligatoire");
			}
			if (!StringUtils.hasLength(utilisateurDto.getAdresse().getCodePostale()))
			{
				errors.add("Le champ 'code postale' et obligatoire");
			}	
			if (!StringUtils.hasLength(utilisateurDto.getAdresse().getPays()))
			{
				errors.add("Le champ 'pays' et obligatoire");
			}	
		}

		return errors;
		
	}

}
