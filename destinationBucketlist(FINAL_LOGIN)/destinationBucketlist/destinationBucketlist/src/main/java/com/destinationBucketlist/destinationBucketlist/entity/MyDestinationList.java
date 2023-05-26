package com.destinationBucketlist.destinationBucketlist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name="MyDestinationList")
public class MyDestinationList {
    @Id
    private Long id;
    private String geolocation;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    public MyDestinationList() {
        super();
    }

    public MyDestinationList(Long id, String geolocation, String title, String description, LocalDate startDate, LocalDate endDate) {
        super();
        this.id = id;
        this.geolocation = geolocation;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
