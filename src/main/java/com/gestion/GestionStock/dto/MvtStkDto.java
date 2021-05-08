package com.gestion.GestionStock.dto;

import java.math.BigDecimal;
import java.time.Instant;	

import com.gestion.GestionStock.model.MvtStk;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MvtStkDto {

	private Integer id;
	
	private Instant dateMvt;
	
	private BigDecimal quantite;
	
	private String typeMvt;	

	private ArticleDto article;
	
	private Integer identreprise ;
	
	public static MvtStkDto fromEntity(MvtStk mvtstk) {
		if(mvtstk ==null) {
			return null;
		}
		return MvtStkDto.builder()
				.id(mvtstk.getId())
				.dateMvt(mvtstk.getDateMvt())
				.quantite(mvtstk.getQuantite())
				.typeMvt(mvtstk.getTypeMvt())
				.article(ArticleDto.fromEntity(mvtstk.getArticle()))
				.identreprise(mvtstk.getIdentreprise())
				.build();
				
		}
	public static MvtStk toEntity(MvtStkDto mvtstkDto) {
		if(mvtstkDto == null) {
			return null;
		}
		MvtStk mvtstk = new MvtStk() ;
		mvtstk.setId(mvtstkDto.getId());
		mvtstkDto.setDateMvt(mvtstkDto.getDateMvt());
		mvtstkDto.setQuantite(mvtstkDto.getQuantite());
		mvtstkDto.setTypeMvt(mvtstkDto.getTypeMvt());
		mvtstkDto.setIdentreprise(mvtstkDto.getIdentreprise());
		
		return mvtstk;
		
	}

}
