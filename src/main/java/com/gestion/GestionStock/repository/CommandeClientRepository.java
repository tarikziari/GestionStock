package com.gestion.GestionStock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.GestionStock.model.CommandeClient;

public interface CommandeClientRepository extends JpaRepository<CommandeClient,Integer>{
	
	Optional<CommandeClient> findCommandeClientBycode(String code);
}
