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
@Table(name="LigneVente")

public class LigneVente extends AbstractEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4398861402428501257L;

	@ManyToOne
	@JoinColumn(name="idvente")
	private Ventes vente;
	
	@Column(name="quantite")
	private BigDecimal quantite;
	
	@Column(name="prixunitaire")
	private BigDecimal prixUnitaire;



}
