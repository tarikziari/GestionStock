package com.gestion.GestionStock.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="Ventes")
public class Ventes extends AbstractEntity{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//fixme
	@Column(name="code")
	private String code;

	@Column(name="datevente")
	private Instant dateVente;
	
	@Column(name="commentaire")
	private String commentaire;
	
	@Column(name="identreprise")
	private Integer identreprise;
}
