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
@Table(name="CommandeClient")
public class CommandeClient extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1601313259261127150L;

	@Column(name="code")
	private String code;
	
	@Column(name="datecommande")
	private Instant dateCommande;
	
	@ManyToOne
	@JoinColumn(name="idclient")
	private Client client;
	

	@OneToMany(mappedBy="commandeClient")
	private List<LigneCommandeClient> ligneCommandeClients;


}
