package ca.udia.webapp.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "todo")
@XmlAccessorType(XmlAccessType.FIELD)
public class Todo {

    private String id;
    private String name;
    private boolean done;
    private Date created;

    public Todo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Todo [id=" + this.getId() +
                ", name=" + this.getName() +
                ", done=" + String.valueOf(this.isDone()) +
                ", created=" + this.getCreated().toString() + "]";
    }
}
