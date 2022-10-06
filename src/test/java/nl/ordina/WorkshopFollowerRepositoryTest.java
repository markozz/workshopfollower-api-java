package nl.ordina;

import nl.ordina.models.WorkshopFollower;
import nl.ordina.repositories.WorkshopFollowerRepository;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkshopFollowerRepositoryTest {

    @Test
    public void testNonFoundUser() {
        WorkshopFollowerRepository repo = new WorkshopFollowerRepository();
        UUID id = UUID.randomUUID();
        WorkshopFollower found = repo.getWorkshopFollower(id);
        assertEquals(null, found);
    }
}
