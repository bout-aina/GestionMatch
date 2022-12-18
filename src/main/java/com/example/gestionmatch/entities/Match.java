package com.example.gestionmatch.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 16,unique = true)
    private String ref_match ;
    @Column(nullable = false )
    private String lieu;
    @Column(nullable = false)
    private Date date_heure;
    private String equipe1;
    private String equipe2;

    @OneToMany(mappedBy = "match",fetch = FetchType.LAZY)
    private List<Ticket> tickets;


}
