package ca.udia.webapp.service;

import ca.udia.webapp.entity.Todo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Demonstration purposes only.
 *
 * Use a concurrent hash map to store the todos in memory.
 * For more practical scenarios, this should be replaced with a data access object for managing communication with a
 * persistence layer, like a SQL/NoSQL DB
 */
public class DefaultTodoService implements TodoService {
    Map<String, Todo> todos = new ConcurrentHashMap<>();

    // Singleton for demonstration, in a practical scenario, use dependency injection
    private static final DefaultTodoService INSTANCE = new DefaultTodoService();

    public DefaultTodoService() {
        // add one sample todoObject
        create("Hello world!", false);
    }

    @Override
    public List<Todo> getTodos() {
        List<Todo> lTodos = new ArrayList<>();
        lTodos.addAll(this.todos.values());
        return lTodos;
    }

    @Override
    public Todo getById(String id) {
        return this.todos.get(id);
    }

    @Override
    public Todo create(String name, boolean done) {
        String id = UUID.randomUUID().toString();
        Todo todo = new Todo();
        todo.setId(id);
        todo.setName(name);
        todo.setDone(done);
        this.todos.put(id, todo);
        return todo;
    }

    @Override
    public Todo update(Todo todo) {
        String id = todo.getId();
        if (id == null) {
            return null;
        }
        this.todos.put(id, todo);
        return todo;
    }

    @Override
    public Todo deleteById(String id) {
        return this.todos.remove(id);
    }

    public static TodoService getInstance() {
        return INSTANCE;
    }
}
