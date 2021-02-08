package fiap.on.jaxrs.sample.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import fiap.on.jaxrs.sample.models.Task;
import fiap.on.jaxrs.sample.models.TaskList;

@Path("/tasks")
public class TasksService {

	private static final List<Task> REPO = new ArrayList<Task>();

	@GET
	@Path("/echo")
	public String success() {
		return "success";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAll() {
		return Response.status(Status.OK).entity(new TaskList(REPO)).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("id") final Integer id) {
		final Optional<Task> opt = REPO.stream().filter(t -> id.equals(t.getId())).findFirst();
		if (!opt.isPresent()) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.status(Status.OK).entity(opt.get()).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(final Task task) {
		REPO.add(task);
		return Response.status(Status.CREATED).build();
	}
}
