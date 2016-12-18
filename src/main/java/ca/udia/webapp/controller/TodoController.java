package ca.udia.webapp.controller;

import ca.udia.webapp.entity.Todo;
import ca.udia.webapp.entity.Todos;
import ca.udia.webapp.service.DefaultTodoService;
import ca.udia.webapp.service.TodoService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;

@Path("/todos")
public class TodoController {

    private TodoService todoService = DefaultTodoService.getInstance();

    /**
     * Get all todos
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Todos getAllTodos() {
        Collection<Todo> todosCollection = todoService.getTodos();
        ArrayList<Todo> todoHolder = new ArrayList<>();
        Todos todos = new Todos();
        todos.setTodoList(todoHolder);

        if (todosCollection == null || todosCollection.size() == 0) {
            return todos;
        }

        for (Todo todo : todosCollection) {
            todoHolder.add(todo);
        }
        todos.setTodoList(todoHolder);
        return todos;
    }

    /**
     * Create a Todo
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTodo(Todo todo) throws URISyntaxException {
        if (todo == null) {
            return Response.status(400).entity("400 - Please add todo details.").build();
        }
        todo = todoService.save(todo);
        return Response.created(new URI("/todos/" + todo.getId())).build();
    }

    /**
     * Get a single Todo
     * @param id
     * @return
     */
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTodo(@PathParam("id") String id) {
        Todo todo = todoService.getById(id);
        if (todo == null) {
            return Response.status(404).entity("404 - Todo Not Found").build();
        }
        return Response.ok(todo, MediaType.APPLICATION_JSON).build();
    }

    /**
     * Update an existing todo. (Fragments)
     * @param id
     * @param todo
     * @return
     */
    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateTodoByIdLossy(@PathParam("id") String id, Todo todo) {
        Todo existing = todoService.getById(id);
        if (existing == null) {
            return Response.status(404).entity("404 - Todo Not Found").build();
        }

        if (todo.getName() != null) {
            existing.setName(todo.getName());
        }
        if (todo.getUser() != null) {
            existing.setUser(todo.getUser());
        }
        if (todo.getCreated() != null) {
            existing.setCreated(todo.getCreated());
        }

        existing = todoService.save(existing);
        return Response.ok(existing, MediaType.APPLICATION_JSON).build();
    }

    /**
     * Update an existing todo. (Replace)
     * @param id
     * @param todo
     * @return
     */
    @Path("/{id}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateTodoByIdFull(@PathParam("id") String id, Todo todo) {
        Todo existing = todoService.getById(id);
        if (existing == null) {
            return Response.status(404).entity("404 - Todo Not Found").build();
        }

        existing = todoService.save(todo);
        return Response.ok(existing, MediaType.APPLICATION_JSON).build();
    }

    /**
     * Delete a todo.
     * @param id
     * @return
     */
    @Path("/{id}")
    @DELETE
    public Response deleteTodo(@PathParam("id") String id) {
        Todo todo = todoService.deleteById(id);
        if (todo == null) {
            return Response.status(404).entity("404 - Todo Not Found").build();
        }
        return Response.status(202).entity("202 - Todo deleted successfully.").build();
    }
}
