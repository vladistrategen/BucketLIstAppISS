package com.destinationBucketlist.destinationBucketlist.service;

import com.destinationBucketlist.destinationBucketlist.entity.Destination;
import com.destinationBucketlist.destinationBucketlist.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService {
    @Autowired
    private DestinationRepository dRepo;

    public void save(Destination d) {dRepo.save(d);}

    public List<Destination> getAllDestination() {return dRepo.findAll();}

    public Destination getDestinationById(Long id) {
        return dRepo.findById(id).get();
    }

    public void deleteById(Long id)
    {
        dRepo.deleteById(id);
    }
}
