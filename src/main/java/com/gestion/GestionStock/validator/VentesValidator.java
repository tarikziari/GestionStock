package com.gestion.GestionStock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.gestion.GestionStock.dto.VentesDto;

public class VentesValidator {
	

	public static List<String> validate(VentesDto ventesDto){
		List<String> errors =new ArrayList<>();
		
		if (ventesDto==null) {
			errors.add("Veuillez renseigner  le code de vente !");
			errors.add("veuillez renseiger la date de vente ! ");
			errors.add("veuillez renseiger le Commentaire de vente ! ");
			return errors;
		}
		
		if(!StringUtils.hasLength(ventesDto.getCode())) {
			errors.add("Veuillez renseigner  le code de vente !");
		}
		if (ventesDto.getDateVente() == null) {
			errors.add("veuillez renseiger la date de vente ! ");
		}
		if (ventesDto.getCommentaire() == null) {
			errors.add("veuillez renseiger le Commentaire de vente ! ");
		}
	
		return errors;
	}
	

}
