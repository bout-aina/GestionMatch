package com.example.gestionmatch.repositories;

import com.example.gestionmatch.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface MatchRepository extends JpaRepository<Match,Long> {

}
