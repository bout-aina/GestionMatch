package com.example.gestionmatch.DTOS;

import com.example.gestionmatch.entities.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchDTOResponse {


    private  Long id;
    private String ref_match ;

    private String lieu;

    private Date date_heure;
    private String equipe1;
    private String equipe2;
    private List<Ticket> tickets;
}