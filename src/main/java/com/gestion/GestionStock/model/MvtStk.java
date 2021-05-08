package com.gestion.GestionStock.model;

import java.math.BigDecimal;
import java.time.Instant;

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
@Table(name="MvtStk")

public class MvtStk extends AbstractEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8270583199032199824L;

	@Column(name="datemvt")
	private Instant dateMvt;
	
	@Column(name="quantite")
	private BigDecimal quantite;
	
	@Column(name="typemvt")
	private String typeMvt;	
	
	@Column(name="identreprise")
	private Integer identreprise;
	
	@ManyToOne
	@JoinColumn(name="idarticle")
	private Article article;

}
