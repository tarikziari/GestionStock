package com.gestion.GestionStock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.gestion.GestionStock.dto.ArticleDto;


public class ArticleValidator {

	public static List<String> validate(ArticleDto articleDto){
		List<String> errors =new ArrayList<>();
		
		if (articleDto==null) {
			errors.add("Veuillez renseigner  le code de l'article !");
			errors.add("Veuillez renseigner  la designation de l'article !");
			errors.add("Veuillez renseigner  le prix unitaire HT  de l'article !");
			errors.add("Veuillez renseigner  le Taux TVA de l'article !");
			errors.add("Veuillez renseigner  le prix unitaire TTC de l'article !");
			errors.add("Veuillez selectionner une Categorie !");
			return errors;
		}
		
		if(!StringUtils.hasLength(articleDto.getCodeArticle())) {
			errors.add("Veuillez renseigner  le code de l'article !");
		}
		if(!StringUtils.hasLength(articleDto.getDesignation())) {
			errors.add("Veuillez renseigner  la designation de l'article !");
		}
		if(articleDto.getPrixUnitaireHt()== null) {
			errors.add("Veuillez renseigner  le prix unitaire HT  de l'article !");
		}
		if(articleDto.getTauxTva()== null) {
			errors.add("Veuillez renseigner  le Taux TVA de l'article !");
		}
		if(articleDto.getPrixUnitaireTtc()==null) {
			errors.add("Veuillez renseigner  le prix unitaire TTC de l'article !");
		}
		if(articleDto.getCategorie()==null) {
			errors.add("Veuillez selectionner une Categorie !");
		}
	
		return errors;
	}
}
