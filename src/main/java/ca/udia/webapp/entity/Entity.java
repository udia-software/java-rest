package ca.udia.webapp.entity;

public abstract class Entity {
    private String id;

    public Entity() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
