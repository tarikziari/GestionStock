package com.gestion.GestionStock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.gestion.GestionStock.dto.CommandeFournisseurDto;



public class CommandeFournisseurValidator {
	
	public static List<String> validate(CommandeFournisseurDto commandeFournisseuDto){
		List<String> errors =new ArrayList<>();
		
		if (commandeFournisseuDto==null) {
			
			errors.add("Veuillez renseigner  le code de la Commande Fournisseur !");
			errors.add("Feuillez renseiger la date Commande Fournisseur ");
			errors.add("Veuillez selectionner le Fournisseur !");
			
			return errors;
		}
		
		if(!StringUtils.hasLength(commandeFournisseuDto.getCode())) {
			
			errors.add("Veuillez renseigner  le code de la Commande Fournisseur !");
			
		}
		if (commandeFournisseuDto.getDateCommande() == null) {
			
			errors.add("Veuillez renseiger la date Commande Fournisseur ");
			
		}
		if(commandeFournisseuDto.getFournisseur()==null) {
			
			errors.add("Veuillez selectionner le Fournisseur !");
			
		}
	
		return errors;

	}
}
