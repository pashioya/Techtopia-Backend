package be.kdg.prog6.parkInformationSystem.adapters.in.web;

import be.kdg.prog6.parkInformationSystem.adapters.in.web.dto.RefreshmentStandDTO;
import be.kdg.prog6.parkInformationSystem.domain.RefreshmentStand;
import be.kdg.prog6.parkInformationSystem.ports.In.LoadRefreshmentStandUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@AllArgsConstructor
public class RefreshmentStandController {

    private final LoadRefreshmentStandUseCase loadRefreshmentStandUseCase;

     @GetMapping("/refreshmentStands")
        public List<RefreshmentStandDTO> getRefreshmentStands() {
            return loadRefreshmentStandUseCase.loadRefreshmentStands().stream().map(RefreshmentStand::toDTO).toList();
        }
}
