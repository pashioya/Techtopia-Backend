package be.keg.prog6.parkOperations.adapters.out.db;

import be.keg.prog6.parkOperations.domain.QueGate;
import be.keg.prog6.parkOperations.domain.TicketInQue;
import be.keg.prog6.parkOperations.ports.out.LoadQueGatePort;
import be.keg.prog6.parkOperations.ports.out.UpdateQueGatePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class QueGateDBAdapter implements LoadQueGatePort, UpdateQueGatePort {
    private final QueGateRepository queGateRepository;
    @Override
    public Optional<QueGate> loadQueGate(UUID uuid) {
        return queGateRepository.findByQueGateUUID(uuid).map(
                queGateJPAEntity -> {
                    List<TicketInQue> ticketsInQueue = new ArrayList<>();
                    return new QueGate(
                            new QueGate.QueGateUUID(queGateJPAEntity.getQueGateUUID()),
                            queGateJPAEntity.getMaxCapacity(),
                            queGateJPAEntity.getCurrentCapacity(),
                            queGateJPAEntity.getAverageWaitTime(),
                            new QueGate.AttractionUUID(queGateJPAEntity.getAttractionUUID()),
                            ticketsInQueue
                    );
                }
        );
    }

    @Override
    public void updateQueGate(QueGate queGate) {
        Optional<QueGateJPAEntity> queGateJPAEntity = queGateRepository.findByQueGateUUID(queGate.getQueGateUUID().uuid());

        queGateJPAEntity.ifPresent(queGateJPAEntity1 -> {
            queGateJPAEntity1.setAverageWaitTime(queGate.getAverageWaitTime());
            queGateJPAEntity1.setCurrentCapacity(queGate.getCurrentCapacity());

            queGateRepository.save(queGateJPAEntity.get());
        });
    }
}
