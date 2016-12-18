package ca.udia.webapp.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "todo")
@XmlAccessorType(XmlAccessType.FIELD)
public class Todo extends Entity {

    private String name;
    private boolean done;
    private Date created;
    private User user;

    public Todo() {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Todo [id=" + this.getId() +
                ", name=" + this.getName() +
                ", done=" + String.valueOf(this.isDone()) +
                ", created=" + this.getCreated().toString() +
                ", user=" + this.getUser().toString() + "]";
    }
}
