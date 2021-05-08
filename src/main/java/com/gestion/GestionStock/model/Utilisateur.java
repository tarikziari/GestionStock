package com.gestion.GestionStock.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
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
@Table(name="Utilisateur")
@SuppressWarnings("serial")
public class Utilisateur extends AbstractEntity {

	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="email")
	private String email;
	
	@Column(name="dateDeNaissance")
	private String DateDeNaissance;
	
	@Column(name="motdepasse")
	private String motDePass;
	
	@Embedded
	private Adresse adresse;
	
	@Column(name="photo")
	private String photo;
	
	@ManyToOne
	@JoinColumn(name="identreprise")
	private Entreprise entreprise;

	
	
	@OneToMany(mappedBy="utilisateur")
	private List<Roles> roles;




	
}
