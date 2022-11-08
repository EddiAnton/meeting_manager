package com.eddi.service;

import com.eddi.model.Department;
import com.eddi.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    public void saveDepartment(Department department) {
        departmentRepo.save(department);

        System.out.println(department);
    }

    public List<Department> getAllDepartment() {
        return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(departmentRepo.findAll().iterator(),
                        Spliterator.NONNULL), false)
                .collect(Collectors.toList());
    }
}
