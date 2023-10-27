package be.kdg.prog6.ticketing.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ActivityWindow {

    private final List<TicketActivity> activities = new ArrayList<>();

    public LocalDateTime getStartTimestamp() {
        return activities.stream()
                .min(Comparator.comparing(TicketActivity::timestamp))
                .orElseThrow(IllegalStateException::new).timestamp();
    }

    public LocalDateTime getEndTimestamp() {
        return activities.stream()
                .max(Comparator.comparing(TicketActivity::timestamp))
                .orElseThrow(IllegalStateException::new)
                .timestamp();
    }

    public boolean add(TicketActivity activity){
        return activities.add(activity);
    }
}
