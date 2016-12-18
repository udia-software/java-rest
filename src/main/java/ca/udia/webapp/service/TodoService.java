package ca.udia.webapp.service;

import ca.udia.webapp.entity.Todo;

import java.util.Collection;

public interface TodoService {
    Collection<Todo> getTodos();

    Todo getById(String id);

    Todo save(Todo todo);

    Todo deleteById(String id);
}
