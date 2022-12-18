package com.example.gestionmatch.mappers;

import com.example.gestionmatch.DTOS.MatchDTOResponse;
import com.example.gestionmatch.DTOS.TicketResponceDTO;
import com.example.gestionmatch.entities.Match;
import com.example.gestionmatch.entities.Ticket;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class MatchMapper {
    public MatchDTOResponse fromMatch(Match match){
        MatchDTOResponse matchDTOResponse = new MatchDTOResponse();
        BeanUtils.copyProperties(match,matchDTOResponse);
        return matchDTOResponse;
    }
}

