package com.gestion.GestionStock.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name="Categorie")

public class Categorie extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6755957026593383691L;

	@Column(name="code")
	private String code;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="identreprise")
	private Integer identreprise;

	@OneToMany(mappedBy="categorie")
	private List<Article> articles;

	





	
}
