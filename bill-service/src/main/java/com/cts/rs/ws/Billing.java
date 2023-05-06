package com.cts.rs.ws;

import java.util.List;

import com.cts.rs.ws.dto.Consumer;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/consumer")
@Produces("application/json,application/xml")
@Consumes("application/json,application/xml")
public interface Billing {
	
	@POST
	public Consumer create(Consumer consumer);
	
	@GET
	public List<Consumer> findAll();
	
	@GET
	@Path("/{billId}")
	public Response findById(@PathParam("billId") int id);
	
	@DELETE
	@Path("/{billId}")
	public Response deleteById(@PathParam("billId") int id);
	
	@PUT
	@Path("/{billId}")
	public Response update( Consumer consumer);
	
	@GET
	@Path("/{billId}/cost")
	public Response calculateBill(@PathParam("billId") int id);
}
