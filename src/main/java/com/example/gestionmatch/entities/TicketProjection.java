package com.example.gestionmatch.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = Ticket.class,name = "proj1")
public interface TicketProjection {
    public  Long getId();
    public String getRef();
}
