package com.eddi.repository;

import com.eddi.model.Meeting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MeetingRepo extends CrudRepository<Meeting, Integer> {
    //public List<Meeting> findByEmployeeNameContaining(String name);
    public List<Meeting> findByTopicContaining(String topic);
    //public List<Meeting> findByDepartmentNameContaining(String departmentName);
    //public List<Meeting> findByDateSpendingBetween(Date fromDate, Date toDate);
}
