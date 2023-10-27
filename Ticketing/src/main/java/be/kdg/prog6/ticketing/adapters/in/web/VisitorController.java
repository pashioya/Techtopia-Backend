package be.kdg.prog6.ticketing.adapters.in.web;

import be.kdg.prog6.ticketing.adapters.in.web.dto.CreateVisitorDTO;
import be.kdg.prog6.ticketing.domain.Visitor;
import be.kdg.prog6.ticketing.ports.in.CreateVisitorUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class VisitorController {

    private final CreateVisitorUseCase createVisitorUseCase;

    @PostMapping("/visitor")
    public void createVisitor(@RequestBody CreateVisitorDTO createVisitorDTO) {
        createVisitorUseCase.createVisitor(
                new Visitor(
                        new Visitor.VisitorUUID(UUID.randomUUID()),
                        createVisitorDTO.getName(),
                        createVisitorDTO.getAddress(),
                        createVisitorDTO.getEmail(),
                        createVisitorDTO.getPhone()
                )
        );
    }
}
