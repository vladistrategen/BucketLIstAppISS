package com.destinationBucketlist.destinationBucketlist.repository;

import com.destinationBucketlist.destinationBucketlist.entity.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepository extends JpaRepository<Destination,Long> {
}
