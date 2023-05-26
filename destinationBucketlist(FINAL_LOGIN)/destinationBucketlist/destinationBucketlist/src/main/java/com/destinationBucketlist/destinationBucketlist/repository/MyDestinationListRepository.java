package com.destinationBucketlist.destinationBucketlist.repository;

import com.destinationBucketlist.destinationBucketlist.entity.MyDestinationList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyDestinationListRepository extends JpaRepository<MyDestinationList,Long> {
}
