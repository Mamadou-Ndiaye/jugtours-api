package sn.ucad.jugtours.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "table_event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Instant date;

    private String title;

    private String description;

    @ManyToMany
    private Set<User> users;

    public Event(Instant date, String title, String description) {
        this.date = date;
        this.title = title;
        this.description = description;
    }


}