package com.gestion.GestionStock.model;

import java.time.Instant;
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
@Table(name="CommandeFourniseur")
public class CommandeFournisseur extends AbstractEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4176123026606479616L;

	@Column(name="code")
	private String code;
	
	@Column(name="datecommande")
	private Instant dateCommande;
	
	@ManyToOne
	@JoinColumn(name="idfournisseur")
	private Fournisseur fournisseur;
	
	@OneToMany(mappedBy="commandeFournisseur")
	private List<LigneCommandeFournisseur> ligneCommandeFournisseur;
	
	
	

}
