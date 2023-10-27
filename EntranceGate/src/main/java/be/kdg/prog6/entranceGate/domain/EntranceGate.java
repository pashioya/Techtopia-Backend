package be.kdg.prog6.entranceGate.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class EntranceGate {

    private EntranceGateUUID entranceGateUUID;
    private String name;

    public record EntranceGateUUID(UUID uuid){
    }
}
