package com.example.gestionmatch.service;

import com.example.gestionmatch.DTOS.MatchDTOREQUEST;
import com.example.gestionmatch.DTOS.MatchDTOResponse;
import com.example.gestionmatch.DTOS.TicketRequestDTO;
import com.example.gestionmatch.DTOS.TicketResponceDTO;

public interface MatchService {
    MatchDTOResponse addMatch(MatchDTOREQUEST matchDTOREQUEST);
}
