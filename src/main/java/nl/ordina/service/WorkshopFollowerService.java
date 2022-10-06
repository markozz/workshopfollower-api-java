package nl.ordina.service;

import nl.ordina.exceptions.WorkshopFollowerNotFoundException;
import nl.ordina.models.WorkshopFollower;
import nl.ordina.repositories.WorkshopFollowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WorkshopFollowerService {

    @Autowired
    private WorkshopFollowerRepository repo;

    public WorkshopFollower getWorkshopFollower(UUID id) throws WorkshopFollowerNotFoundException {
        WorkshopFollower found = repo.getWorkshopFollower(id);
        if (found != null) {
            return found;
        } else {
            throw new WorkshopFollowerNotFoundException();
        }
    }

    public UUID saveWorkshopFollower(WorkshopFollower workshopFollower) throws Exception {
        try{
            UUID id = repo.saveWorkshopFollower(workshopFollower);
            return id;
        } catch (Exception e) {
            throw new Exception("Failed to store workshopfollower");
        }
    }
}
