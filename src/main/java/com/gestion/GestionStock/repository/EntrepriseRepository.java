package com.gestion.GestionStock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.GestionStock.model.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise,Integer> {

}
