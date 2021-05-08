package com.gestion.GestionStock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.gestion.GestionStock.dto.ClientDto;

public class ClientValidator {
	
	public static List<String>validate(ClientDto clientDto){
		List<String> errors =new ArrayList<>();
		
		if(clientDto == null) {
			errors.add("Veuillez renseigner le nom de client");
			errors.add("Veuillez renseigner le prenom de client");
			errors.add("Veuillez renseigner le Mail de client");
			errors.add("Veuillez renseigner le Tel de client");
			return errors;
		}
		
		
		if(!StringUtils.hasLength(clientDto.getNom())) {
			errors.add("Veuillez renseigner le nom de client");
		}
		
		if(!StringUtils.hasLength(clientDto.getPrenom())) {
			errors.add("Veuillez renseigner le prenom de client");
		}
		
		if(!StringUtils.hasLength(clientDto.getMail())) {
			errors.add("Veuillez renseigner le Mail de client");
		}
		
		if(!StringUtils.hasLength(clientDto.getTel())) {
			errors.add("Veuillez renseigner le Tel de client");
		}
		
		
		return errors;
	}

}
