package com.gestion.GestionStock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.GestionStock.model.Ventes;

public interface VentesRepository extends JpaRepository<Ventes,Integer> {
	
	Optional<Ventes> findVentsByCode(String  code);

}
