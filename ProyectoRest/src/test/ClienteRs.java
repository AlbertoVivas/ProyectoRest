package test;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ClienteRs {

	
	public static void main(String[] args) {
		
		Client cliente = Client.create();
		WebResource webResource = cliente.resource("http://localhost:8085/ProyectoRest/rest/User/Get/105");
		String s = webResource.get(String.class);
		System.out.println(s);
		
		
		
		
		/*
		Client cliente = Client.create();
		WebResource webResource = cliente.resource("http://localhost:8085/ProyectoRest/rest/equipo/");
		String s = webResource.get(String.class);
		System.out.println(s);
		/**/
		//miget
		/*
		Client cliente_miget = Client.create();
		WebResource webResource_miget = cliente_miget.resource("http://localhost:8085/ProyectoRest/rest/equipo/MiGet/30");
		String s_miget = webResource_miget.get(String.class);
		System.out.println(s_miget);
		//mipost
		Client cliente_mipost = Client.create();
		WebResource webResource_mipost = cliente_mipost.resource("http://localhost:8085/ProyectoRest/rest/equipo/MiPost/mikelkk/30");
		String s_mipost = webResource_mipost.post(String.class);
		System.out.println(s_mipost);
		//EJEMPLO DE CASO DOS
		
		Client client_dos = Client.create();
		WebResource webResource_dos = client_dos.resource("http://localhost:8085/ProyectoRest/rest/equipo/");
		String input_dos = "{\"nombre\":\"Juanita\",\"edad\":\"31\"}";
		ClientResponse response_dos = webResource_dos.type("application/json").post(ClientResponse.class, input_dos);
		if (response_dos.getStatus() != 201) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response_dos.getStatus());
		}
		System.out.println("Respuesta del servidor .... \n");
		String output_dos = response_dos.getEntity(String.class);
		System.out.println(output_dos);
		
		
		/*
		Client client_del = Client.create();
		String input_del = "{\"nombre\":\"Juanita\",\"edad\":\"31\"}";
		WebResource webResource_del = client_del.resource("http://localhost:8085/ProyectoRest/rest/equipo/");
		webResource_del.type("application/json").delete(ClientResponse.class, input_del);
		/*if (response_del.getStatus() != 201) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response_del.getStatus());
		}

		System.out.println("Respuesta del servidor .... \n");
		String output_del = response_del.getEntity(String.class);
		System.out.println(output_del);
		/**/
	}

}
