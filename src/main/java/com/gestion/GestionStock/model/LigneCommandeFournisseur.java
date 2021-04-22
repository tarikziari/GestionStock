package com.gestion.GestionStock.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name="LigneCommandeFournisseur")

public class LigneCommandeFournisseur extends AbstractEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1853413505961065631L;

	@ManyToOne
	@JoinColumn(name="idarticle")
	private Article article;
	
	@ManyToOne
	@JoinColumn(name="idcommandefournisseur")
	private CommandeFournisseur commandeFournisseur;
	
	@Column(name="quantite")
	private BigDecimal quantite;
	
	@Column(name="prixunitaire")
	private BigDecimal prixUnitaire;

}
