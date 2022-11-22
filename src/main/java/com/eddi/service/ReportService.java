package com.eddi.service;

import com.eddi.model.Report;
import com.eddi.repository.ReportRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ReportService {

    private final ReportRepo reportRepo;

    public ReportService(ReportRepo reportRepo) {
        this.reportRepo = reportRepo;
    }

    public void saveReport(Report report) {
        reportRepo.save(report);
    }

    public List<Report> getAllReport() {
        return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(reportRepo.findAll().iterator(),
                        Spliterator.NONNULL), false)
                .collect(Collectors.toList());
    }

    public Report getReportById(String reportId) {
        Integer id = Integer.parseInt(reportId);
        return reportRepo.findReportById(id);
    }
}
