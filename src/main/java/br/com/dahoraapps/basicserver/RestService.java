package br.com.dahoraapps.basicserver;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public class RestService {

	@GET
	@Path("/check")
	public Response printMessage() {
		String result = "Restful check: OK";
		return Response.status(200).entity(result).build();
	}
	
}
