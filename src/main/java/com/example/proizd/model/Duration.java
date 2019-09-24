package com.example.proizd.model;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Duration {
    private String from;
    private String to;
}
