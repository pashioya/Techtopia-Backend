package be.kdg.prog6.parkInformationSystem.adapters.in.web;

import be.kdg.prog6.parkInformationSystem.ports.In.LoadRefreshmentStandUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RefreshmentStandController {

    private final LoadRefreshmentStandUseCase loadRefreshmentStandUseCase;

     @GetMapping("/refreshmentStands")
        public String getRefreshmentStands() {
            return loadRefreshmentStandUseCase.loadRefreshmentStands().toString();
        }
}
