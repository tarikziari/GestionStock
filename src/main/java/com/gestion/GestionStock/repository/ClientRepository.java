package com.gestion.GestionStock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.GestionStock.model.Client;

public interface ClientRepository extends JpaRepository<Client,Integer> {

}
