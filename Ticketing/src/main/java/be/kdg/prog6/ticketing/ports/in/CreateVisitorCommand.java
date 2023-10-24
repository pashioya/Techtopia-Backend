package be.kdg.prog6.ticketing.ports.in;

public record CreateVisitorCommand(String name, String address, String email, String phone) {
}
