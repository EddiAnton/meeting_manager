package com.eddi.repository;

import com.eddi.model.Meeting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepo extends CrudRepository<Meeting, Integer> {

}
