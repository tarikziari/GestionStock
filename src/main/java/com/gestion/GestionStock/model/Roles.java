package com.gestion.GestionStock.model;

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
@Table(name="Roles")
public class Roles extends AbstractEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4859458581033074106L;

	@Column(name="rolename")
	private String roleName;
	
	@ManyToOne
	@JoinColumn(name="idutilisateur")
	private Utilisateur utilisateur;

}
