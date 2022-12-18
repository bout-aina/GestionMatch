package com.example.gestionmatch.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchDTOREQUEST {



    private String ref_match ;

    private String lieu;

    private Date date_heure;
    private String equipe1;
    private String equipe2;
}
