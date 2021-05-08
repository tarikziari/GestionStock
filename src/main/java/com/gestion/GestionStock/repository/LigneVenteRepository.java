package com.gestion.GestionStock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.GestionStock.model.LigneVente;

public interface LigneVenteRepository extends JpaRepository<LigneVente,Integer> {

}
