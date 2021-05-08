package com.gestion.GestionStock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.GestionStock.model.CommandeFournisseur;

public interface CommandeFournisseurRepository  extends JpaRepository<CommandeFournisseur,Integer >{
	
	Optional<CommandeFournisseur> findCommandeFournisseurBycode(String code);
	
}
