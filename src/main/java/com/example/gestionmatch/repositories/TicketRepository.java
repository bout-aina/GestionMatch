package com.example.gestionmatch.repositories;



import com.example.gestionmatch.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface TicketRepository extends JpaRepository<Ticket,Long> {
    Ticket findByReferenceContains(String ref);
}
