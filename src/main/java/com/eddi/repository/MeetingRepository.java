package com.eddi.repository;

import com.eddi.model.Meeting;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MeetingRepository extends CrudRepository<Meeting, Long> {

    @Query(value = "SELECT * FROM meeting INNER JOIN participants ON meeting.id=participants.meeting_id LEFT JOIN employee ON participants.employee_id=employee.id WHERE employee.name=?1",
           nativeQuery = true)
    List<Meeting> findByEmployeesContaining(String name);

    @Query(value = "SELECT * FROM meeting INNER JOIN department ON meeting.organized_department_id=department.id WHERE department.department_name = ?1",
           nativeQuery = true)
    List<Meeting> findByDepartmentNameContaining(String departmentName);

    List<Meeting> findByTopicContainingAndDateSpendingBetween(String topic, Date fromDate, Date toDate);

    @Query(value = "SELECT * FROM meeting WHERE date_spending IS NOT NULL ORDER BY date_spending DESC LIMIT 5;",
           nativeQuery = true)
    List<Meeting> findLastMeeting();
}
