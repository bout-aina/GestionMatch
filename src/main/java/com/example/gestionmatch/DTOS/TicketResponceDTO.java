package com.example.gestionmatch.DTOS;

import com.example.gestionmatch.entities.Match;
import com.example.gestionmatch.enums.Statut;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponceDTO {
    private Long id;

    private String reference;

    private double prix;

    private Statut statut;
    private  Boolean achete;
private Long matchId;
}
