package com.gestion.GestionStock.validator;

import java.util.ArrayList;
import java.util.List;

import com.gestion.GestionStock.dto.LigneCommandeClientDto;

public class LigneCommandeClientValidator {
	
	public static List<String> validate(LigneCommandeClientDto ligneCommandeClientDto){
		
		List<String> errors =new ArrayList<>();
		
		if (ligneCommandeClientDto==null) {
			errors.add("Veuillez renseigner  le code de la Commande Client !");
			errors.add("veuillez renseiger la date Commande Client ");
			errors.add("Veuillez selectionner le client !");
			return errors;
		}
		
		if (ligneCommandeClientDto.getQuantite() == null) {
			errors.add("veuillez renseiger Quantité de Ligne Commande Client ");
		}
		if (ligneCommandeClientDto.getPrixUnitaire() == null) {
			errors.add("veuillez renseiger le prix unitaire de Ligne Commande Client ");
		}
		if(ligneCommandeClientDto.getArticle()==null) {
			errors.add("Veuillez selectionner le Article !");
		}
		if(ligneCommandeClientDto.getCommandeClient()==null) {
			errors.add("Veuillez selectionner la Commande Client !");
		}
	
		return errors;
	}}
