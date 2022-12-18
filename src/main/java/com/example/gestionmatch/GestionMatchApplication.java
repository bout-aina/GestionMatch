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

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
@SpringBootApplication
public class GestionMatchApplication implements CommandLineRunner {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private MatchRepository matchRepository;
    public static void main(String[] args) {
        SpringApplication.run(GestionMatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        for(long i=1; i<7; i++){
            Match match = Match.builder()
                    .id(i)
                    .ref_match("Ref"+i)
                    .date_heure(new Date())
                    .equipe1("eq"+i)
                    .equipe2("eq"+i)
                    .lieu("abcd")

                    .build();
            matchRepository.save(match);
        }

        matchRepository.findAll().forEach(match -> {
            for(Long i = Long.valueOf(1); i<=10; i++){
                Ticket ticket = Ticket.builder()
                        .id(i)
                        .reference("ref "+i)
                        .prix(i)
                        .statut((i%2 == 0) ? Statut.ACTIVÉ : Statut.DESACTIVÉ)
                        .achete((i%2 == 0) ? Boolean.FALSE : Boolean.TRUE)
                        .match(match)
                        .build();
                ticketRepository.save(ticket);
            }});
    }
}
