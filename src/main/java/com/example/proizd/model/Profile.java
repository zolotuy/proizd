package com.example.proizd.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Profile {
    @Id
    private int id;
    @ManyToOne
    private List<Ticket> tickets;
}
