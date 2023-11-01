package be.kdg.prog6.ticketing.adapters.in.web;

import be.kdg.prog6.ticketing.adapters.in.web.dto.CreateVisitorDTO;
import be.kdg.prog6.ticketing.ports.in.CreateVisitorCommand;
import be.kdg.prog6.ticketing.ports.in.CreateVisitorUseCase;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class VisitorController {

    private final CreateVisitorUseCase createVisitorUseCase;
    private final Logger logger = LoggerFactory.getLogger(VisitorController.class);

    @PostMapping("/visitor")
    public void createVisitor(@RequestBody CreateVisitorDTO createVisitorDTO) {

        logger.info("Creating visitor: {}", createVisitorDTO);
        createVisitorUseCase.createVisitor(
                new CreateVisitorCommand(
                        createVisitorDTO.getName(),
                        createVisitorDTO.getAddress(),
                        createVisitorDTO.getEmail(),
                        createVisitorDTO.getDateOfBirth()));
    }
}
