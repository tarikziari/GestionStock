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
@Table(name="Article")
public class Article extends AbstractEntity {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 188530208528536401L;

	@Column(name="codeaticle")
	private String codeArticle;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="prixunitaireht")
	private BigDecimal prixUnitaireHt;
	
	@Column(name="tauxtva")
	private BigDecimal tauxTva;
	
	@Column(name="prixunitairettc")
	private BigDecimal PrixUnitaireTtc;
	
	@Column(name="photo")
	private String photo;
	
	@ManyToOne
	@JoinColumn(name="idcategorie")
	private Categorie categorie;

	
}
