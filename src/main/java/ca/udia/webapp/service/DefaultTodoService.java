package ca.udia.webapp.service;

import ca.udia.webapp.entity.Todo;
import ca.udia.webapp.entity.User;

import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultTodoService implements TodoService {
    // For demonstration purposes only, use a concurrent hash map to store in memory
    // In practical scenarios, use a data access object to store in DB
    Map<String, Todo> todos = new ConcurrentHashMap<String, Todo>();

    // Singleton for demonstration
    // Practical scenario, use dependency injection
    private static final DefaultTodoService INSTANCE = new DefaultTodoService();

    // Simulate single user for demo
    private final User user;

    public DefaultTodoService() {
        // create a user
        User user = new User();
        user.setId(UUID.randomUUID().toString().replace("-", ""));
        user.setUsername("udia");
        user.setGivenName("Adam");
        user.setSurname("West");
        this.user = user;

        // add one sample todoObject
        Todo sampleTodo = new Todo();
        sampleTodo.setName("Hello World!");
        save(sampleTodo);
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
    public Todo save(Todo todo) {
        String id = todo.getId();
        if (id == null) {
            id = UUID.randomUUID().toString().replace("-", "");
            todo.setId(id);
            todo.setCreated(new Date());
            todo.setUser(getCurrentUser());
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
