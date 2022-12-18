package com.example.gestionmatch.entities;

import com.example.gestionmatch.enums.Statut;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 16,unique = true)
    private String reference ;
    @Column(nullable = false )
    private double prix;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Statut statut;
    @Column(nullable = false)
    private Boolean achete;
    @ManyToOne
    private Match match;

}
