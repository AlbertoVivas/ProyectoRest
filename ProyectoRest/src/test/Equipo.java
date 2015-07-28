package test;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
@Path("/equipo")
public class Equipo {
	private final Logger log = LogManager.getRootLogger();
	
	@GET
	@Path("/info/{team}")
	@Produces("application/xml")
	public String getMsg(@PathParam("team") String inicial) {
		String stateDetails = null;
		if (inicial.equals("RM")) {
			stateDetails = "<Equipo><name>REAL</name><nombrecorto>RM</nombrecorto>" +
					"<copas>10</copas><entrenador>Benitez</entrenador></Equipo>";
		} else if (inicial.equals("AT")) {
			stateDetails = "<Equipo><name>ATELETICO</name><nombrecorto>ATM</nombrecorto>" +
					"<copas>0</copas><entrenador>Cholo</entrenador></Equipo>";
		} else if (inicial.equals("BCN")) {
			stateDetails = "<Equipo><name>BARCELONA</name><nombrecorto>FCB</nombrecorto>" +
					"<copas>5</copas><entrenador>LuisEn</entrenador></Equipo>";
		} else {
			stateDetails = "Equipo No encontrado";
		}
		return stateDetails;
	}
	
	 @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public String getProfe() {
		    Persona p = new Persona("Vale", 31);
		    Gson gson = new Gson();
		    String persona_json = gson.toJson(p);
	        return persona_json;
	    }
	 @GET
	 	@Path("/MiGet/{edad}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public String getPersona(@PathParam("edad") String edadI) {
		 	int edad = Integer.parseInt(edadI);
		    Persona p = new Persona("kk", edad);
		    Gson gson = new Gson();
		    String persona_json = gson.toJson(p);
	        return persona_json;
	    }
	 
	 @POST
		@Consumes(MediaType.APPLICATION_JSON)
		public Response creaPersona(String p) {
	 
		 	Gson gson = new Gson();
		 	Persona person = gson.fromJson(p, Persona.class);
		 	System.out.println(person.toString());
		 	System.out.println(p.toString());
			String result = "Ha ido bien, chaval ;)";
			return Response.status(201).entity(result).build();
		}
	 
	 @POST
	 	@Path("/MiPost/{nombre}/{edad}")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response creaPersonaMiPost(@PathParam("nombre")String nombreI,@PathParam("edad")String edadI) {
		 	Gson gson = new Gson();
		 	String nombre = nombreI;
		 	int edad = Integer.parseInt(edadI);
		 	Persona p = new Persona(nombre, edad);
		 	String persona_json = gson.toJson(p);
		 	System.out.println(p.toString());
			String result = "Persona creada correctamente "+persona_json;
			return Response.status(201).entity(result).build();
		}
	 
	 @DELETE
	 	@Consumes(MediaType.APPLICATION_JSON)
	 	public void borrarPersona(String p){
		 
		 Gson gson = new Gson();
		 Persona person = gson.fromJson(p, Persona.class);
		 String result = "Borrado correctamente"+person;
		 log.debug(result);
	 }
	 
	 @PUT
	 	@Consumes(MediaType.APPLICATION_JSON)
	 	public void modificarPersona(String p){
		 
		
	 }
}
