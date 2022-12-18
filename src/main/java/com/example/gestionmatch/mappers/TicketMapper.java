package com.example.gestionmatch.mappers;

import com.example.gestionmatch.DTOS.TicketResponceDTO;
import com.example.gestionmatch.entities.Ticket;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {
    public TicketResponceDTO fromTicket(Ticket ticket){
        TicketResponceDTO ticketResponceDTO = new TicketResponceDTO();
        BeanUtils.copyProperties(ticket,ticketResponceDTO);
        return ticketResponceDTO;
    }
}
