package com.example.proizd.model;

import javax.persistence.Embeddable;

@Embeddable
public enum TrainType {
    LOCAL("local"), REGIONAL("regional"), INTERNATIONAL("international");

    TrainType(String s) {

    }
}
