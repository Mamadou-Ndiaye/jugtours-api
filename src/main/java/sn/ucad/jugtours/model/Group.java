package sn.ucad.jugtours.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "table_group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String address;

    private String city;

    private String stateOrProvince;

    private String country;

    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private  User user;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Event> events;

    public Group(String name) {
        this.name = name;
    }

}