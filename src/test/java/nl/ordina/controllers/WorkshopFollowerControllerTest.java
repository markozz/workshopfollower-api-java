package nl.ordina.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkshopFollowerControllerTest {
    WorkshopFollowerController controller = new WorkshopFollowerController();

    @Test
    public void testUuidConvertion() {
        int expected = 400;
        ResponseEntity response = controller.getWorkshopFollower("123");
        int actual = response.getStatusCodeValue();
        assertEquals(expected, actual);
    }
}
