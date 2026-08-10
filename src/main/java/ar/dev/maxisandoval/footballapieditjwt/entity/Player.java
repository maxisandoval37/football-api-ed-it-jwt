package ar.dev.maxisandoval.footballapieditjwt.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data //getters, setters, toString, hashCode, equals
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}