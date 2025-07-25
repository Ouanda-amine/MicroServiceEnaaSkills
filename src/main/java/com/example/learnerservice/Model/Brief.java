package com.example.learnerservice.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Brief {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String titre ;
    private String description ;
    @ManyToOne
    private Formateur formateur;

    @ElementCollection
    private List<Long> competencesIds ;

    public Brief(Long id, String titre, String description, Formateur formateur) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.formateur = formateur;
    }
}
