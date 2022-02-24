package mazurek.run.todoudemy.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;



@Entity
@Table(name="tasks")
public class Task {

    public Task() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @NotBlank(message="Description nie może być null")
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    private boolean done;

}
