package com.example.gestionmatch.controllers;

import com.example.gestionmatch.DTOS.MatchDTOREQUEST;
import com.example.gestionmatch.DTOS.MatchDTOResponse;
import com.example.gestionmatch.DTOS.TicketRequestDTO;
import com.example.gestionmatch.DTOS.TicketResponceDTO;
import com.example.gestionmatch.entities.Match;
import com.example.gestionmatch.entities.Ticket;
import com.example.gestionmatch.mappers.TicketMapper;
import com.example.gestionmatch.repositories.MatchRepository;
import com.example.gestionmatch.repositories.TicketRepository;
import com.example.gestionmatch.service.MatchService;
import com.example.gestionmatch.service.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;
@Controller
public class GraphQLController {
    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private MatchService matchService;
    @Autowired
    TicketMapper ticketMapper;

    @QueryMapping
    private List<Ticket> ticketList(){
        return ticketRepository.findAll();
    }

    @QueryMapping
    public Ticket ticketById(@Argument Long id) {
        return ticketRepository.findById(id).orElseThrow(
                ()->new RuntimeException(String.format("Ticket %s not found ",id))
        );
    }
    @QueryMapping
    public List<Match> matchList(){
        return matchRepository.findAll();
    }
    @QueryMapping
    public Match matchById(@Argument Long id) {
        return matchRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Match %s not found",id)));
    }
    @MutationMapping
    private TicketResponceDTO addTicket(@Argument TicketRequestDTO ticket){
        return  ticketService.addTicket(ticket);
    }
    @MutationMapping
    private MatchDTOResponse addMatch(@Argument MatchDTOREQUEST match){

        return  matchService.addMatch(match);
    }
    @MutationMapping
    private TicketResponceDTO updateTicket(@Argument Long id, @Argument TicketRequestDTO ticket){

        return ticketService.updateTicket(id,ticket);

    }

    @MutationMapping
    private void deleteTicket(@Argument Long id){

        ticketService.deleteTicket(id);
    }
}
