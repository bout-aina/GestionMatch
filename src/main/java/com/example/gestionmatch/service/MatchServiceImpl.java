package com.example.gestionmatch.service;

import com.example.gestionmatch.DTOS.MatchDTOREQUEST;
import com.example.gestionmatch.DTOS.MatchDTOResponse;
import com.example.gestionmatch.entities.Match;
import com.example.gestionmatch.mappers.MatchMapper;
import com.example.gestionmatch.mappers.TicketMapper;
import com.example.gestionmatch.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MatchServiceImpl implements MatchService {
    @Autowired

    MatchRepository matchRepository;
    @Autowired
    MatchMapper matchMapper;

    @Override
    public MatchDTOResponse addMatch(@Argument MatchDTOREQUEST match){

        Match matchTosave = new Match();
        matchTosave.setRef_match(match.getRef_match());
        matchTosave.setLieu(match.getLieu());
        matchTosave.setDate_heure(match.getDate_heure());
        matchTosave.setEquipe1(match.getEquipe1());
        matchTosave.setEquipe2(match.getEquipe2());


        Match savedMatch = matchRepository.save(matchTosave);
        MatchDTOResponse matchDTOResponse = matchMapper.fromMatch(savedMatch);
        return matchDTOResponse;
    }
}

