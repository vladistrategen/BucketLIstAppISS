package com.destinationBucketlist.destinationBucketlist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Destination{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String geolocation;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    public Destination() {}

    public Destination(Long id, String geolocation, String title, String description, LocalDate startDate, LocalDate endDate) {
        super();
        this.id = id;
        this.geolocation = geolocation;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
