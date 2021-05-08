package com.gestion.GestionStock.dto;

import java.math.BigDecimal;

import com.gestion.GestionStock.model.Article;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ArticleDto {
	
	private Integer id;

	private String codeArticle;
	
	private String designation;
		
	private BigDecimal prixUnitaireHt;
		
	private BigDecimal tauxTva;
		
	private BigDecimal PrixUnitaireTtc;
		
	private String photo;
		
	private CategorieDto categorie;
	
	private Integer identreprise;
	
	public static ArticleDto fromEntity(Article article) {
		
		if(article == null) {
			return null;				
		}
		
		return ArticleDto.builder()
			.id(article.getId())
			.codeArticle(article.getCodeArticle())
			.designation(article.getDesignation())
			.prixUnitaireHt(article.getPrixUnitaireHt())
			.tauxTva(article.getTauxTva())
			.PrixUnitaireTtc(article.getPrixUnitaireTtc())
			.photo(article.getPhoto())
			.identreprise(article.getIdentreprise())
			.categorie(CategorieDto.fromEntity(article.getCategorie()))
			.build();
		}
		
	
	
	public static Article toEntity(ArticleDto articleDto){
		if(articleDto == null) {
			return null;
		}
		Article article =new Article();
		article.setId(articleDto.getId());
		article.setCodeArticle(articleDto.getCodeArticle());
		article.setDesignation(articleDto.getDesignation());
		article.setPrixUnitaireHt(articleDto.getPrixUnitaireHt());
		article.setTauxTva(articleDto.getTauxTva());
		article.setPrixUnitaireTtc(articleDto.getPrixUnitaireTtc());
		article.setPhoto(articleDto.getPhoto());
		article.setIdentreprise(articleDto.getIdentreprise());
		//article.setCategorie(CategorieDto.toEntity(article.getCategorie()));
		
		return article;
	
		
	
		
	}

	

}
