package com.gestion.GestionStock.controller.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gestion.GestionStock.dto.ArticleDto;

import static com.gestion.GestionStock.utils.Constants.APP_ROOT;


public interface ArticleApi {
	
	@PostMapping(value=APP_ROOT+"/articles/create", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	
	ArticleDto save(@RequestBody ArticleDto dto);
	
	@GetMapping(value=APP_ROOT+"/articles/{idArticle}",produces=MediaType.APPLICATION_JSON_VALUE)
	ArticleDto finById(@PathVariable("idArticle") Integer id);
	
	@GetMapping(value=APP_ROOT+"/articles/{codeArticle}",produces=MediaType.APPLICATION_JSON_VALUE)
	ArticleDto findByCodeArtcle(@PathVariable("codeArticle") String codeArticle);
	
	@GetMapping(value=APP_ROOT+"/articles/all",produces=MediaType.APPLICATION_JSON_VALUE)
	List<ArticleDto> findAll();
	
	@DeleteMapping(value=APP_ROOT+"/articles/delete/{idArticle}")
	void delete(@PathVariable("idArticle") Integer id);


}
