package com.employee.api.service;

import com.employee.api.dto.DepartmentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        return null;
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        return null;
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        return List.of();
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment) {
        return null;
    }

    @Override
    public void deleteDepartment(Long departmentId) {

    }
}
