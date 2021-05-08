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
@Table(name="Client")

public class Client extends AbstractEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="nom")
	private String Nom;
	
	@Column(name="prenom")
	private String Prenom;
	
	@Embedded
	private Adresse adresse;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="mail")
	private String Mail;
	
	@Column(name="tel")
	private String Tel;
	
	@Column(name="identreprise")
	private Integer identreprise;
	
	@OneToMany(mappedBy="client")
	private List<CommandeClient> commandeClients;

}
