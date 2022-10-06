package nl.ordina.controllers;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import nl.ordina.exceptions.WorkshopFollowerNotFoundException;
import nl.ordina.models.WorkshopFollower;
import nl.ordina.service.WorkshopFollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin
public class WorkshopFollowerController {

    @Autowired
    WorkshopFollowerService workshopFollowerService;

    @GetMapping("/workshopfollowers/{id}")
    public ResponseEntity<String> getWorkshopFollower(@PathVariable String id) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json");
        ResponseEntity<String> response;
        try {
            UUID uuid = UUID.fromString(id);
            WorkshopFollower found = workshopFollowerService.getWorkshopFollower(uuid);
            response = new ResponseEntity<>(found.toString(), headers, HttpStatus.OK);
        } catch(IllegalArgumentException e) {
            String body = String.format("{\"error\": \"%s\"}", e.getMessage());
            response  = new ResponseEntity<>(body, headers, HttpStatus.BAD_REQUEST);
        } catch (WorkshopFollowerNotFoundException e) {
            String body = String.format("{\"error\": \"%s\"}", e.getMessage());
            response = new ResponseEntity<>(body, headers, HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @PostMapping("/workshopfollowers")
    public ResponseEntity<String> saveWorkshopFollower(@RequestBody String workshopFollower) {
        ResponseEntity response;
        try{
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ").create();
            WorkshopFollower user = gson.fromJson(workshopFollower, WorkshopFollower.class);
            UUID id = workshopFollowerService.saveWorkshopFollower(user);
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.add("Content-Type", "application/json");
            response = new ResponseEntity<>(String.format("{\"id\": \"%s\"}", id.toString()), headers, HttpStatus.CREATED);
        } catch (Exception e) {
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return response;
    }
}
