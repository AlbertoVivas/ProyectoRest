package Jackson;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;

@Path("/equipoj")
public class Equipo {
	
	 	@PUT
		@Consumes(MediaType.APPLICATION_JSON)
		public Response creaPersona(Persona p) {
	 		
	 		System.out.println("desde put json");
	 		System.out.println(p.toString());
	        
			String result = "Ha ido bien, chaval ;)";
			return Response.status(201).entity(result).build();
	 
		}
	 
	 	@PUT
		@Consumes(MediaType.APPLICATION_XML)
		public Response creaPersonaXml(JAXBElement<Persona> xml_persona) {
		 
	 		System.out.println("desde put xml");
	 		
	 		System.out.println(xml_persona.getName());
	 		Persona precb = xml_persona.getValue();
	 		System.out.println(precb.toString());
	        
			String result = "Ha ido bien, chaval ;)";
			return Response.status(201).entity(result).build();
		}
	 	
	 	@GET
	 	@Consumes(MediaType.APPLICATION_XML)
	 	public Response getPersona(JAXBElement<Persona> xml_persona){
	 		
	 		String result ="Toma de tu get";
	 		return Response.status(201).entity(result).build();
	 	}
	 
}
