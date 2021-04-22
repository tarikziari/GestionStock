package com.gestion.GestionStock.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestion.GestionStock.model.Client;

import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class ClientDto {
	
	private Integer id;
	
	private String Nom;
		
	private String Prenom;
	
	//private Adresse adresse;

	private AdresseDto adresse;
		
	private String photo;
		
	private String Mail;
		
	private String Tel;
	
	@JsonIgnore
	private List<CommandeClientDto> commandeClients;
	

	public static ClientDto fromEntity(Client client) {
		
		if(client == null) {
			return null;				
		}
	
		return ClientDto.builder()
				.id(client.getId())
				.Nom(client.getNom())
				.Prenom(client.getPrenom())
				.adresse(AdresseDto.fromEntity(client.getAdresse()))
				.photo(client.getPhoto())
				.Mail(client.getMail())
				.Tel(client.getTel())
				.build();
		}
	public Client toEntity(ClientDto clientDto) {
		if(clientDto == null) {
			return null;
		}
		
		Client client = new Client();
		client.setId(clientDto.getId());
		client.setNom(clientDto.getNom());
		client.setPrenom(clientDto.getPrenom());
		//client.setAdresse(clientDto.getAdresse());
		client.setPhoto(clientDto.getPhoto());
		client.setMail(clientDto.getMail());
		client.setTel(clientDto.getTel());
		return client;
		
	}


}
