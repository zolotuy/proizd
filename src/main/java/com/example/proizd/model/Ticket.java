package com.example.proizd.model;

import java.util.UUID;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.MapKey;

import lombok.Data;

@Data
@Entity
public class Ticket {
    @Id
    private UUID id;
    private int seat;
    private int price;
    private Boolean tea;
    private Boolean bedside;
    private Boolean additionalBaggage;
    private String fromPos;
    private String toPos;
}
