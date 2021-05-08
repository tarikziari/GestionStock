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
@Table(name="LigneCommandeClient")

public class LigneCommandeClient extends AbstractEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2711181784591567257L;

	@ManyToOne
	@JoinColumn(name="idarticle")
	private Article article;
	
	@ManyToOne
	@JoinColumn(name="idcommandeclient")
	private CommandeClient commandeClient;
	
	@Column(name="quantite")
	private BigDecimal quantite;
	
	@Column(name="prixunitaire")
	private BigDecimal prixUnitaire;
	
	@Column(name="identreprise")
	private Integer identreprise;
	
	
}
