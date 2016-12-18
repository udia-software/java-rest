package ca.udia.webapp.service;

import ca.udia.webapp.entity.Todo;

import java.util.Collection;

public interface TodoService {
    Collection<Todo> getTodos();

    Todo getById(String id);

    Todo create(Todo todo);

    Todo update(Todo todo);

    Todo deleteById(String id);
}
