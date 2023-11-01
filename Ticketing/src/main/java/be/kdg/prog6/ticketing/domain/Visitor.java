package be.kdg.prog6.ticketing.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class Visitor {

    private VisitorUUID visitorUUID;
    private String name;
    private String address;
    private String email;
    private LocalDate dateOfBirth;

    public record VisitorUUID(UUID uuid) {
    }
}
