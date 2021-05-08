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
@Table(name="Fournisseur")
public class Fournisseur extends AbstractEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6841008948098821650L;

	@Column(name="nom")
	private String Nom;
	
	@Column(name="prenom")
	private String Prenom;
	
	//private Adresse adresse;
	@Embedded
	private Adresse adresse;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="mail")
	private String Mail;
	
	@Column(name="numtel")
	private String numTel;
	
	@Column(name="identreprise")
	private Integer identreprise;
	
	
	@OneToMany(mappedBy="fournisseur")
	private List<CommandeFournisseur> commandeFournisseur;
	

}
