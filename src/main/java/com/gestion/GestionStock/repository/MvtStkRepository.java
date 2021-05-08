package com.gestion.GestionStock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.GestionStock.model.MvtStk;

public interface MvtStkRepository extends JpaRepository<MvtStk,Integer> {

}
