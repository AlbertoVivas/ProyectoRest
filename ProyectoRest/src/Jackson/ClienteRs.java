package Jackson;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class ClienteRs {

	
	public static void main(String[] args) {
		 
		
		
		Client client1 = Client.create();
		WebResource webResource1 = client1.resource("http://localhost:8085/ProyectoRest/rest/equipoj/");
		Persona p = new Persona("Val", 31);

		ClientResponse response1 = webResource1.type("application/json").entity(p).put(ClientResponse.class);
		
		if (response1.getStatus() != 201) { throw new RuntimeException("Failed : HTTP error code : " + response1.getStatus());}

		System.out.println("Respuesta del servidor .... \n");
		String output1 = response1.getEntity(String.class);
		System.out.println(output1);
		
		Client client2 = Client.create();
		WebResource webResource2 = client2.resource("http://localhost:8085/ProyectoRest/rest/equipoj/");
		Persona p2 = new Persona("Val", 31);

		ClientResponse response2 = webResource2.type("application/xml").entity(p2).put(ClientResponse.class);
		
		if (response2.getStatus() != 201) { throw new RuntimeException("Failed : HTTP error code : " + response2.getStatus());}

		System.out.println("Respuesta del servidor .... \n");
		String output2 = response2.getEntity(String.class);
		System.out.println(output2);
		
		
		Client client3 = Client.create();
		WebResource webResource3 = client3.resource("http://localhost:8085/ProyectoRest/rest/equipoj/");
		Persona p3 = new Persona("Val", 31);
	
		ClientResponse response3 = webResource3.type("application/xml").entity(p3).get(ClientResponse.class);
		
		if (response3.getStatus() != 201) { throw new RuntimeException("Failed : HTTP error code : " + response3.getStatus());}
	
		System.out.println("Respuesta del servidor .... \n");
		String output3 = response3.getEntity(String.class);
		System.out.println(output3);
		
		
		
		
		
		}
	
		
		
		

}
