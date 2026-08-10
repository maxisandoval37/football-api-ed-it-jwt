package ar.dev.maxisandoval.footballapieditjwt.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data //getters, setters, toString, hashCode, equals
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer capacity;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Player> players;
}