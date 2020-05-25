package com.eddi.repository;

import com.eddi.model.Report;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepo extends CrudRepository<Report, Integer> {
}
