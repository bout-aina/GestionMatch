package com.example.gestionmatch.service;

import com.example.gestionmatch.DTOS.TicketRequestDTO;
import com.example.gestionmatch.DTOS.TicketResponceDTO;
import com.example.gestionmatch.entities.Match;
import com.example.gestionmatch.entities.Ticket;
import com.example.gestionmatch.mappers.TicketMapper;
import com.example.gestionmatch.repositories.MatchRepository;
import com.example.gestionmatch.repositories.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {
    @Autowired

    TicketRepository ticketRepository;
    @Autowired

    MatchRepository matchRepository;
    @Autowired
    TicketMapper ticketMapper;
    @Override
    public TicketResponceDTO addTicket(TicketRequestDTO ticket)  {
        Match match = matchRepository.findById(ticket.getMatchId()).orElse(null);
        int totalticket=  ticketRepository.NbrticketParMatch(match.getId());

        System.out.println(totalticket);
       //test que le match ne doit pas depasser 6 tickets
        if( totalticket > 5 ) {
            throw new RuntimeException("Les tickets ne sont plus dispo   pour ce match !!!");

        }


        Ticket ticketToSave = new Ticket();
        ticketToSave.setPrix(ticket.getPrix());
        ticketToSave.setReference(ticket.getReference());
        ticketToSave.setStatut(ticket.getStatut());
        ticketToSave.setAchete(ticket.getAchete());
        ticketToSave.setMatch(match);


        Ticket savedTicket = ticketRepository.save(ticketToSave);

        TicketResponceDTO ticketResponceDTO = ticketMapper.fromTicket(savedTicket);
        return ticketResponceDTO;
    }

    @Override
    public TicketResponceDTO updateTicket(Long id, TicketRequestDTO ticket) {
        Match match = matchRepository.findById(ticket.getMatchId()).orElse(null);
        Ticket ticketToSave = ticketRepository.findById(id).get();
        if (ticketToSave != null)
        {
            ticketToSave.setPrix(ticket.getPrix());
            ticketToSave.setReference(ticket.getReference());
            ticketToSave.setStatut(ticket.getStatut());
            ticketToSave.setAchete(ticket.getAchete());
            ticketToSave.setMatch(match);


            Ticket savedTicket = ticketRepository.save(ticketToSave);

            TicketResponceDTO ticketResponceDTO = ticketMapper.fromTicket(savedTicket);
            return ticketResponceDTO;
        }
        return  null;


    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }


}
