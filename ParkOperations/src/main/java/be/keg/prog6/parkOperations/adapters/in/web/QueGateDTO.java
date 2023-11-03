package be.keg.prog6.parkOperations.adapters.in.web;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.time.Duration;

@AllArgsConstructor
@ToString
public class QueGateDTO {
    private int maxCapacity;
    private int currentCapacity;
    private Duration averageWaitTime;
    private String attractionUUID;
}
