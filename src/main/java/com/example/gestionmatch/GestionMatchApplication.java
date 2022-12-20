package com.example.gestionmatch;


import com.example.gestionmatch.entities.Match;
import com.example.gestionmatch.entities.Ticket;
import com.example.gestionmatch.enums.Statut;
import com.example.gestionmatch.repositories.MatchRepository;
import com.example.gestionmatch.repositories.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
@SpringBootApplication
public class GestionMatchApplication  {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private MatchRepository matchRepository;
    public static void main(String[] args) {
        SpringApplication.run(GestionMatchApplication.class, args);
    }


}
