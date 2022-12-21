package com.example.gestionmatch.repositories;



import com.example.gestionmatch.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@RepositoryRestResource
public interface TicketRepository extends JpaRepository<Ticket,Long> {
    Ticket findByReferenceContains(String ref);

    @Query("select count(t.id) from  Ticket t where t.match.id = :m_id group by t.match.id")
   public int NbrticketParMatch(@Param("m_id") Long m_id);

}
