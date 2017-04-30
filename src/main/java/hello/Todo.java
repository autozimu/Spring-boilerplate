package hello;

import javax.persistence.*;

@Entity
public class Todo {
    @Id
    @GeneratedValue
    public long id;
    @Column(nullable = false)
    public String content;
}
