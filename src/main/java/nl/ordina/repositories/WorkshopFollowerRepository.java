package nl.ordina.repositories;

import nl.ordina.models.WorkshopFollower;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.UUID;

@Repository
public class WorkshopFollowerRepository {
    HashMap<UUID, WorkshopFollower> db;

    public WorkshopFollowerRepository() {
        this.db = new HashMap();
    }

    public UUID saveWorkshopFollower(WorkshopFollower workshopFollower) {
        UUID id = workshopFollower.getId();
        db.put(id, workshopFollower);
        return id;
    }

    public WorkshopFollower getWorkshopFollower(UUID id) {
        WorkshopFollower found = db.get(id);
        return found;
    }
}
