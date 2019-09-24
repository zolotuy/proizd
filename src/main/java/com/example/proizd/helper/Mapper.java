package com.example.proizd.helper;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.proizd.DTO.TicketDTO;
import com.example.proizd.model.Ticket;

@Component
public class Mapper {

    public TicketDTO convertToTicketDto(Ticket ticket){
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setId(ticket.getId().toString());

        ticketDTO.setSeat(ticket.getSeat());
        ticketDTO.setBedside(ticket.getBedside());
        ticketDTO.setTea(ticket.getTea());
        ticketDTO.setAdditionalBaggage(ticket.getAdditionalBaggage());


        return  ticketDTO;
    }

    public Ticket convertToTicketEntity(TicketDTO ticketDTO) {
        Ticket ticket = new Ticket();
        ticket.setId(UUID.fromString(ticketDTO.getId()));

        ticket.setSeat(ticketDTO.getSeat());
        ticket.setBedside(ticketDTO.isBedside());
        ticket.setTea(ticketDTO.isTea());
        ticket.setAdditionalBaggage(ticketDTO.isAdditionalBaggage());


        return ticket;
    }
}
