package com.gestion.GestionStock.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@Column(name="identreprise")
	private Integer identreprise;
	
	@ManyToOne
	@JoinColumn(name="idcategorie")
	private Categorie categorie;
	
	@OneToMany(mappedBy="article")
	private List<LigneVente> ligneVente;
	
	@OneToMany(mappedBy="article")
	private List<LigneCommandeClient> ligneCommandeClient;
	
	@OneToMany(mappedBy="article")
	private List<LigneCommandeFournisseur> ligneCommandeFournisseur;
	
	@OneToMany(mappedBy="article")
	private List<MvtStk> mvtStk;
	
}
