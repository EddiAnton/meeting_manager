package com.eddi.service;

import com.eddi.model.Report;
import com.eddi.repository.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ReportService {

    private final ReportRepository reportRepo;

    public ReportService(ReportRepository reportRepo) {
        this.reportRepo = reportRepo;
    }

    public void saveReport(Report report) {
        Date dateCreated = new Date();
        report.setDateCreated(dateCreated);
        reportRepo.save(report);
    }

    public List<Report> getAllReport() {
        return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(reportRepo.findAll().iterator(),
                        Spliterator.NONNULL), false)
                .collect(Collectors.toList());
    }

    public Report getReportById(String reportId) {
        Long id = Long.parseLong(reportId);
        return reportRepo.findReportById(id);
    }
}
