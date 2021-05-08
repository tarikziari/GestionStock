package com.gestion.GestionStock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.GestionStock.model.LigneCommandeClient;

public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient,Integer> {

}
