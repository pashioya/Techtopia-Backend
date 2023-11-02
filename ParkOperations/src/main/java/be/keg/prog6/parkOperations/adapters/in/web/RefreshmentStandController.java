package be.keg.prog6.parkOperations.adapters.in.web;

import be.keg.prog6.parkOperations.ports.in.CreateRefreshmentStandCommand;
import be.keg.prog6.parkOperations.ports.in.CreateRefreshmentStandUseCase;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RefreshmentStandController {
    private final static Logger logger = LoggerFactory.getLogger(RefreshmentStandController.class);
    private final CreateRefreshmentStandUseCase createRefreshmentStandUseCase;

    @PostMapping("/refreshmentStand")
    public void createRefreshmentStand(@RequestBody CreateRefreshmentStandCommand createRefreshmentStandCommand) {
        logger.debug("creating refreshment stand");
        createRefreshmentStandUseCase.createRefreshmentStand(
                createRefreshmentStandCommand
        );
    }
}
