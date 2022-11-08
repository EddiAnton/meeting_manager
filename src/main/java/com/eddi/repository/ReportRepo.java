package com.eddi.repository;

import com.eddi.model.Employee;
import com.eddi.model.Report;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepo extends CrudRepository<Report, Integer> {

    @Query(value = "SELECT * FROM report WHERE id =?1",
            nativeQuery = true)
    public Report findReportById(Integer id);
}
