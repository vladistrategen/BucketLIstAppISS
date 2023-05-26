package com.destinationBucketlist.destinationBucketlist.service;

import com.destinationBucketlist.destinationBucketlist.entity.Destination;
import com.destinationBucketlist.destinationBucketlist.entity.MyDestinationList;
import com.destinationBucketlist.destinationBucketlist.repository.MyDestinationListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyDestinationListService {
    @Autowired
    private MyDestinationListRepository mydest;

    public void saveMyDestinations(MyDestinationList destination)
    {
        mydest.save(destination);
    }

    public List<MyDestinationList> getAllMyDestinations()
    {
        return mydest.findAll();
    }

    public void deleteById(Long id) {
        mydest.deleteById(id);
    }
}
