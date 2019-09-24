package com.example.proizd.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.xml.bind.ValidationException;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proizd.DTO.TicketDTO;
import com.example.proizd.helper.Mapper;
import com.example.proizd.model.Ticket;
import com.example.proizd.repo.TicketRepository;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    private TicketRepository ticketRepository;
    private Mapper mapper;

    public TicketController(TicketRepository ticketRepository, Mapper mapper) {
        this.ticketRepository = ticketRepository;
        this.mapper = mapper;
    }

    @GetMapping("/all")
    public List<TicketDTO> all(){
        List<Ticket> tickets = ticketRepository.findAll();

       return tickets.stream()
            .map(ticket -> mapper.convertToTicketDto(ticket))
            .collect(Collectors.toList());
    }

    @GetMapping("/byId/{id}")
    public TicketDTO byId(@PathVariable String id) {
        Ticket ticket = ticketRepository.findById(UUID.fromString(id)).orElseThrow(EntityNotFoundException::new);
        return mapper.convertToTicketDto(ticket);
    }

    @PostMapping
    public Ticket save(@RequestBody TicketDTO ticketDTO, BindingResult bindingResult) throws ValidationException {
        if (bindingResult.hasErrors()) {
            throw new ValidationException("Put valid data");
        }
         Ticket ticket = mapper.convertToTicketEntity(ticketDTO);
        return ticketRepository.save(ticket);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        ticketRepository.deleteById(UUID.fromString(id));
    }
}
