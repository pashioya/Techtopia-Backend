package be.keg.prog6.parkOperations.ports.in;


import java.util.UUID;

public record LoadQueGateCommand(
        UUID queGateUUID
) {
}
