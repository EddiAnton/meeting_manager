package com.eddi.repository;

import com.eddi.model.Report;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends CrudRepository<Report, Integer> {

    @Query(value = "SELECT * FROM report WHERE id =?1",
            nativeQuery = true)
    Report findReportById(Integer id);
}
