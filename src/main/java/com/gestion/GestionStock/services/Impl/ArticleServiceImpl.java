package com.gestion.GestionStock.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gestion.GestionStock.dto.ArticleDto;
import com.gestion.GestionStock.exception.EntityNotFoundException;
import com.gestion.GestionStock.exception.ErrorCodes;
import com.gestion.GestionStock.exception.InvalidEntityException;
import com.gestion.GestionStock.model.Article;
import com.gestion.GestionStock.repository.ArticleRepository;
import com.gestion.GestionStock.services.ArticleService;
import com.gestion.GestionStock.validator.ArticleValidator;

import lombok.extern.slf4j.Slf4j;

//@Service("ArticleServiceImpl1")
@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService{


	private ArticleRepository articleRepository;
	
	public ArticleServiceImpl(ArticleRepository articleRepository){
		this.articleRepository=articleRepository;
	}
	
	@Override
	public ArticleDto save(ArticleDto dto) {
		
		List<String> errors = ArticleValidator.validate(dto);
		if(!errors.isEmpty()) {
			log.error("Article is not valid {}  ",dto);
			throw new InvalidEntityException("L'Article n'est pas Valid",ErrorCodes.ARTICLE_NOT_VALID,errors);
		}
		return ArticleDto.fromEntity(
				articleRepository.save(
						ArticleDto.toEntity(dto)
				));
	}

	@Override
	public ArticleDto finById(Integer id) {
		if(id==null) {
			log.error("Article ID is null");
		}
		Optional<Article> article=articleRepository.findById(id);
		
		//ArticleDto dto=ArticleDto.fromEntity(article.get());
		
		return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(() -> 
		new EntityNotFoundException(
				"Aucun article avec l'ID =" + id + "n'a ete trouve dans la BDD",
				ErrorCodes.ARTICLE_NOT_FOUND)
		);
	}

	@Override
	public ArticleDto findByCodeArticle(String codeArticle) {
		
		if(StringUtils.hasLength(codeArticle)) {
			log.error("Article CODE is null");
		}
		
		Optional<Article> article=articleRepository.findArtcleByCodeArticle(codeArticle);
				
				//ArticleDto dto=ArticleDto.fromEntity(article.get());
				
				return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(() -> 
				new EntityNotFoundException(
						"Aucun article avec le CODE =" + codeArticle + "n'a ete trouve dans la BDD",
						ErrorCodes.ARTICLE_NOT_FOUND)
				);
	}

	@Override
	public List<ArticleDto> findAll() {
		return articleRepository.findAll().stream()
			.map(ArticleDto::fromEntity)
			.collect(Collectors.toList());
			
		
	}

	@Override
	public void delete(Integer id) {
		if(id==null) {
			log.error("Article ID is null");
		}
		articleRepository.deleteById(id);
	}
	
	

}
