package com.gestion.GestionStock.services;

import java.util.List;

import com.gestion.GestionStock.dto.ArticleDto;

public interface ArticleService {
	
	ArticleDto save(ArticleDto dto);
	
	ArticleDto finById(Integer id);
	
	ArticleDto findByCodeArticle(String codeArticle);
	
	List<ArticleDto> findAll();
	
	void delete(Integer id);




}
