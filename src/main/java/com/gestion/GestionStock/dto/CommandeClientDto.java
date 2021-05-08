package com.gestion.GestionStock.dto;

import java.time.Instant;
import java.util.List;

import com.gestion.GestionStock.model.CommandeClient;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CommandeClientDto {

	private Integer id;
	
	private String code;
		
	private Instant dateCommande;
	
	private ClientDto client;
	
	private Integer identreprise;
	/*  
	@JsonIgnore   en vas suprimer   @JsonIgnore ----->
	pour creer  un autre objet  CommandeRequest   en vas encabsuler a l intèrieur  un
	objet de type CommandeClientDto et une listes LigneCommandeClientDto and ArticleDto
	par ce que trois objbet sera très defficile pour programme 
	*/
	
	private List<LigneCommandeClientDto> ligneCommandeClients;
		
		public static CommandeClientDto fromEntity(CommandeClient commandeclient) {
			
			if(commandeclient == null) {
				return null;
			}
			
			return CommandeClientDto.builder()
					.id(commandeclient.getId())
					.code(commandeclient.getCode())
					.dateCommande(commandeclient.getDateCommande())
					.client(ClientDto.fromEntity(commandeclient.getClient()))
					.identreprise(commandeclient.getIdentreprise())
					.build();
			
		}
		
		public static CommandeClient toEntity(CommandeClientDto commandeclientDto){
			if (commandeclientDto == null) {
				return null;
			}
			
			CommandeClient commandeclient = new CommandeClient();
			commandeclient.setId(commandeclientDto.getId());
			commandeclient.setCode(commandeclientDto.getCode());
			commandeclient.setDateCommande(commandeclientDto.getDateCommande());
			commandeclient.setIdentreprise(commandeclientDto.getIdentreprise());
			
			return commandeclient;
			
		}
	
}
