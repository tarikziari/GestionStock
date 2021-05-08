package com.gestion.GestionStock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.GestionStock.model.Article;

public interface ArticleRepository extends JpaRepository<Article,Integer> {
	
	//Article findByCodeArticle(String codearticle,String designation);
	
	//Requte personalisé
		
	//@Query("Select * from Article where codeaticle=:code and designation=:designation")
	//List<String> findByCustomQuery(String Code,String designation);
	//List<String> findByCustomQuery(@Param("code")String c,@Param("designation")String d);
	
	
	//@Query(value="Select * from Article where codeaticle=:code",nativeQuery=true)
	//List<String> findByCustomQuery(String Code,String designation);
	
	//List<String> findByNativeQuery(@Param("code")String c,@Param("designation")String d);
	
	//Optional<Article> findArtcleByCodeArticle(String codeArticle);
	//Article delete(Integer id);

	Optional<Article> findArtcleByCodeArticle(String codeArticle);

}
