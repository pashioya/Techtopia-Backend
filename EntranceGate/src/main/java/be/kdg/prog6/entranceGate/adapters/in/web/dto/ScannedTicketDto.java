package be.kdg.prog6.entranceGate.adapters.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ScannedTicketDto {
    private String ticketUUID;
    private boolean isValid;
    private boolean isCheckedIn;
}
