package com.example.gestionmatch.service;

import com.example.gestionmatch.DTOS.TicketRequestDTO;
import com.example.gestionmatch.DTOS.TicketResponceDTO;


public interface TicketService {

    TicketResponceDTO addTicket(TicketRequestDTO ticketRequestDTO);
    TicketResponceDTO updateTicket(Long id, TicketRequestDTO ticketRequestDTO);
    void deleteTicket(Long id);
}
