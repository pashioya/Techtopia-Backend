package be.kdg.prog6.ticketing.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class Visitor {

    private VisitorUUID visitorUUID;
    private String name;
    private String address;
    private String email;


    public record VisitorUUID(UUID uuid){
    }
}
