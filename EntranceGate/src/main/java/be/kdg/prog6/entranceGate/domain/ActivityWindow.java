package be.kdg.prog6.entranceGate.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
public class ActivityWindow {

    private final List<TicketActivity> ticketActivities = new ArrayList<>();

    public boolean add(TicketActivity ticketActivity) {
        return ticketActivities.add(ticketActivity);
    }

    public TicketActivity getLatestActivity() {
        return ticketActivities.get(ticketActivities.size() - 1);
    }
}
