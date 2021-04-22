package com.gestion.GestionStock.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	@JsonIgnore
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
			//commandeclient.setClient(CommandeClientDto.fromEntity(commandeclient.getLigneCommandeClients()));
			return commandeclient;
			
			
		}
	
}
