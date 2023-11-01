package be.kdg.prog6.entranceGate.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class ScannedTicket {

    private TicketUUID ticketUUID;
    private VisitorUUID visitorUUID;
    private LocalDateTime validFrom;
    private LocalDateTime validUntil;
    private ActivityWindow activityWindow;

    public record TicketUUID(UUID uuid) {
    }

    public record VisitorUUID(UUID uuid) {
    }

    public boolean isValid() {
        return LocalDateTime.now().isAfter(validFrom) && LocalDateTime.now().isBefore(validUntil);
    }
}
