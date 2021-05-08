package com.gestion.GestionStock.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.gestion.GestionStock.controller.api.ArticleApi;
import com.gestion.GestionStock.dto.ArticleDto;
import com.gestion.GestionStock.services.ArticleService;

@RestController
public class ArticleController implements ArticleApi  {
	
	//fieled Injection
	//@Autowired
	private ArticleService  articleService;
	


	/*Setter Injection
	 * 
	@Autowired
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}*/
	
	//Constructor Injection
	/*@Autowired
	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}*/


	public ArticleService getArticleService() {
		return articleService;
	}


	@Override
	public ArticleDto save(ArticleDto dto) {
		
		return articleService.save(dto);
	}

	@Override
	public ArticleDto finById(Integer id) {
	
		return articleService.finById(id);
	}

	@Override
	public ArticleDto findByCodeArtcle(String codeArticle) {
		
		return articleService.findByCodeArticle(codeArticle);
	}

	@Override
	public List<ArticleDto> findAll() {
		
		return articleService.findAll();
	}

	@Override
	public void delete(Integer id) {
		
		articleService.delete(id);
	}
	

	
}
