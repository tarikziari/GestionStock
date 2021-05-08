package com.gestion.GestionStock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.gestion.GestionStock.dto.CommandeClientDto;

public class CommandeClientValidator {

	public static List<String> validate(CommandeClientDto commandeClientDto){
		List<String> errors =new ArrayList<>();
		
		if (commandeClientDto==null) {
			errors.add("Veuillez renseigner  le code de la Commande Client !");
			errors.add("veuillez renseiger la date Commande Client ");
			errors.add("Veuillez selectionner le client !");
			return errors;
		}
		
		if(!StringUtils.hasLength(commandeClientDto.getCode())) {
			errors.add("Veuillez renseigner  le code de la Commande Client !");
		}
		if (commandeClientDto.getDateCommande() == null) {
			errors.add("veuillez renseiger la date Commande Client ");
		}
		if(commandeClientDto.getClient()==null) {
			errors.add("Veuillez selectionner le client !");
		}
	
		return errors;
	}
	
		
}
