package com.employee.api.service;

import com.employee.api.dto.DepartmentDto;
import com.employee.api.entity.Department;
import com.employee.api.mapper.DepartmentMapper;
import com.employee.api.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        //DTO => Entity
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        // 등록 처리
        Department savedDepartment = departmentRepository.save(department);
        // 등록은 Entity => DTO 변환
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Transactional(readOnly = true)
    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        return null;
    }

    @Transactional(readOnly = true)
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
