package com.gestion.GestionStock.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestion.GestionStock.model.Categorie;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Data
@Getter
@Setter
public class CategorieDto {
	
	private Integer id;
	
	private String code;
	
	
	private String designation;

	@JsonIgnore
	private List<ArticleDto> articles;
	
	
	public static CategorieDto fromEntity(Categorie categorie) {
	
		if (categorie == null) {
			return null;
		}
		
		return CategorieDto.builder()
				.id(categorie.getId())
				.code(categorie.getCode())
				.designation(categorie.getDesignation())
				.build();
		}
	
	public static Categorie toEntity(CategorieDto categorieDto) {
		
		if(categorieDto == null) {
			return null;
			//TODO THROW AN EXCPTION
		}
		Categorie categorie =new Categorie();
		categorie.setId(categorieDto.getId());
		categorie.setCode(categorieDto.getCode());
		categorie.setDesignation(categorieDto.getDesignation());

		return categorie;

	}


	

}
