package be.kdg.prog6.ticketing.ports.in;

import java.time.LocalDate;

public record CreateVisitorCommand(String name, String address, String email, LocalDate dateOfBirth) {
}
