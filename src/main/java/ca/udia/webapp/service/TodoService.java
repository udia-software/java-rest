package ca.udia.webapp.service;

import ca.udia.webapp.entity.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getTodos();

    Todo getById(String id);

    Todo create(String name, boolean done);

    Todo update(Todo todo);

    Todo deleteById(String id);
}
