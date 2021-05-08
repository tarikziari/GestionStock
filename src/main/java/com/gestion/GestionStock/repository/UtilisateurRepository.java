package com.gestion.GestionStock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.GestionStock.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {

}
