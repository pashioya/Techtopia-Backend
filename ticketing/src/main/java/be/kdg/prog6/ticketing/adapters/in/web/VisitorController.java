package be.kdg.prog6.ticketing.adapters.in.web;

import be.kdg.prog6.ticketing.ports.in.CreateVisitorCommand;
import be.kdg.prog6.ticketing.ports.in.CreateVisitorUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class VisitorController {

    private final CreateVisitorUseCase createVisitorUseCase;

    @PostMapping("/visitor")
    public void createVisitor(CreateVisitorDTO createVisitorDTO) {
        createVisitorUseCase.createVisitor(
                new CreateVisitorCommand(
                        createVisitorDTO.getName(),
                        createVisitorDTO.getAddress(),
                        createVisitorDTO.getEmail(),
                        createVisitorDTO.getPhone()
                )
        );
    }
}
