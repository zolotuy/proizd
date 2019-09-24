package com.example.proizd.DTO;

import javax.validation.constraints.NotNull;

import com.example.proizd.model.Duration;
import com.example.proizd.model.TrainType;

import lombok.Data;

@Data
public class TicketDTO {
    private String id;

    @NotNull
    private int seat;

    @NotNull
    private Duration duration;

    @NotNull
    private TrainType trainType;

    private boolean tea;
    private boolean bedside;
    private boolean additionalBaggage;
}
