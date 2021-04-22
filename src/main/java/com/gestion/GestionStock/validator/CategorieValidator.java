package com.gestion.GestionStock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.gestion.GestionStock.dto.CategorieDto;

public class CategorieValidator {
	
	public static List<String> validate(CategorieDto categorieDto){
		List<String> errors =new ArrayList<>();
		
		if (categorieDto == null || !StringUtils.hasLength(categorieDto.getCode())) {
			errors.add("Veuillez renseiner le code de la categories");
			
		}
		return errors;
		
	}

}
