package com.eddi.repository;

import com.eddi.model.Meeting;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MeetingRepo extends CrudRepository<Meeting, Integer> {
    @Query(value = "SELECT * FROM meeting INNER JOIN participants ON meeting.id=participants.meeting_id LEFT JOIN employee ON participants.employee_id=employee.id WHERE employee.name=?1",
           nativeQuery = true)
    public List<Meeting> findByEmployeesContaining(String name);

    public List<Meeting> findByTopicContaining(String topic);

    @Query(value = "SELECT * FROM meeting INNER JOIN department ON meeting.organized_department_id=department.id WHERE department.department_name = ?1",
            nativeQuery = true)
    public List<Meeting> findByDepartmentNameContaining(String departmentName);

    @Query(value = "SELECT * FROM meeting WHERE date_spending BETWEEN ?1 AND ?2",
           nativeQuery = true)
    public List<Meeting> findByDateSpendingBetween(Date fromDate, Date toDate);
}
