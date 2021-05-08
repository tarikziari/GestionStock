package com.gestion.GestionStock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.gestion.GestionStock.dto.FournisseurDto;

public class FournisseurValidator {
	public static List<String>validate(FournisseurDto fournisseurDto){
		List<String> errors =new ArrayList<>();
		
		if(fournisseurDto == null) {
			errors.add("Veuillez renseigner le nom de fournisseur");
			errors.add("Veuillez renseigner le prenom de fournisseur");
			errors.add("Veuillez renseigner le Mail de fournisseur");
			errors.add("Veuillez renseigner le Tel de fournisseurD");
			return errors;
		}
		
		
		if(!StringUtils.hasLength(fournisseurDto.getNom())) {
			errors.add("Veuillez renseigner le nom de fournisseur");
		}
		
		if(!StringUtils.hasLength(fournisseurDto.getPrenom())) {
			errors.add("Veuillez renseigner le prenom de fournisseur");
		}
		
		if(!StringUtils.hasLength(fournisseurDto.getMail())) {
			errors.add("Veuillez renseigner le Mail de fournisseur");
		}
		
		if(!StringUtils.hasLength(fournisseurDto.getNumTel())) {
			errors.add("Veuillez renseigner le Tel de fournisseur");
		}
		
		
		return errors;
	}

}
