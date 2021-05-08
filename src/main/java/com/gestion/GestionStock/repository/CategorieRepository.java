package com.gestion.GestionStock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.GestionStock.model.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie,Integer > {

	Optional<Categorie> findCategorieByCode(String code);
}
