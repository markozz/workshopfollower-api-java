package nl.ordina.models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

public class WorkshopFollower {

    private UUID id;
    private String name;
    private String email;
    private Date createdAt;

    public WorkshopFollower(UUID id, String name, String email, Date createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public Date getCreatedAt() {
        return createdAt;
    }

    public String toString() {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
        formatter.setTimeZone(tz);
        return String.format("{\"id\": \"%s\", \"name\": \"%s\", \"email\": \"%s\", \"createdAt\": \"%s\"}", id.toString(), name, email, formatter.format(createdAt));
    }
}
