package ca.udia.webapp.service;

import ca.udia.webapp.entity.Todo;
import ca.udia.webapp.entity.User;

import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
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

    // Simulate single user for demo
    private final User user;

    public DefaultTodoService() {
        // create a user
        User user = new User();
        user.setUsername("udia");
        user.setGivenName("Adam");
        user.setSurname("West");
        this.user = user;

        // add one sample todoObject
        Todo sampleTodo = new Todo();
        sampleTodo.setName("Hello World!");
        create(sampleTodo);
    }

    @Override
    public Collection<Todo> getTodos() {
        return this.todos.values();
    }

    @Override
    public Todo getById(String id) {
        return this.todos.get(id);
    }

    @Override
    public Todo create(Todo todo) {
        String id = UUID.randomUUID().toString();
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

    protected User getCurrentUser() {
        return this.user;
    }

    public static TodoService getInstance() {
        return INSTANCE;
    }
}
