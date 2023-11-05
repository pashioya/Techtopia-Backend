package be.keg.prog6.parkOperations.core;

import be.keg.prog6.parkOperations.domain.Attraction;
import be.keg.prog6.parkOperations.domain.QueGate;
import be.keg.prog6.parkOperations.ports.in.CreateAttractionCommand;
import be.keg.prog6.parkOperations.ports.in.CreateAttractionUseCase;
import be.keg.prog6.parkOperations.ports.out.CreateAttractionPort;
import be.keg.prog6.parkOperations.ports.out.CreateQueGatePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DefaultCreateAttractionUseCase implements CreateAttractionUseCase  {

    private final List<CreateAttractionPort> createAttractionPorts;
    private final CreateQueGatePort createQueGatePort;

    @Override
    public void createAttraction(CreateAttractionCommand command) {

        UUID attractionUUID = UUID.randomUUID();
        UUID queGateUUID = UUID.randomUUID();

        createQueGatePort.createQueGate(new QueGate(
                queGateUUID,
                command.queGateMaxCapacity(),
                attractionUUID
        ));

        createAttractionPorts.forEach(
                port -> port.createAttraction(new Attraction(
                        attractionUUID,
                        command.name(),
                        command.description(),
                        command.location(),
                        queGateUUID
                )
        )
        );


    }
}
