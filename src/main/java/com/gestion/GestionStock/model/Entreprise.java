package com.gestion.GestionStock.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
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
@Table(name="Entreprise")

public class Entreprise  extends AbstractEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5337611308320365505L;

	@Column(name="nom")	
	private String nom;
	
	@Column(name="description")	
	private String description;
	
	@Embedded
	private Adresse adresse;
	
	@Column(name="codefiscal")	
	private String codeFiscal;
	
	@Column(name="email")	
	private String email;
	
	@Column(name="numtel")	
	private String numTel;
	
	@Column(name="siteweb")	
	private String siteWeb;
	
	@Column(name="identreprise")
	private Integer identreprise;
	
	@OneToMany(mappedBy="entreprise")
	private List<Utilisateur> utilisateurs;


}
