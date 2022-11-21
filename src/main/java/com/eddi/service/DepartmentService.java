package com.eddi.service;

import com.eddi.model.Department;
import com.eddi.repository.DepartmentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DepartmentService {

    private final DepartmentRepo departmentRepo;

    public DepartmentService(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public void saveDepartment(Department department) {
        departmentRepo.save(department);
    }

    public List<Department> getAllDepartment() {
        return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(departmentRepo.findAll().iterator(),
                        Spliterator.NONNULL), false)
                .collect(Collectors.toList());
    }
}
