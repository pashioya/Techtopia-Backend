package be.kdg.prog6.parkInformationSystem.adapters.in.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Duration;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class AttractionDTO {
    private String name;
    private String description;
    private int currentCapacity;
    private int maxCapacity;
    private Duration averageWaitTime;
}
