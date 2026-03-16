package com.employee.api.mapper;

import com.employee.api.dto.EmployeeDto;
import com.employee.api.entity.Employee;

public class EmployeeMapper {
    // Entity -> DTO (ID만 포함)
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return EmployeeDto.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .departmentId(employee.getDepartment().getId())
                .build();
    }

    // Entity -> DTO (전체 부서 정보 포함)
    // 여기가 문제가 된다.
    /*
    * 이 메서드는 직원의 정보뿐만 아니라 전체 부서 정보도 DTO로 변환하기 위해
    * employee.getDepartment()를 호출하여 DepartmentMapper로 넘깁니다.
    * 발생 과정: DTO 변환 과정에서 가짜 객체였던 부서의 실제 데이터(이름, 설명 등)를 읽으려 시도하게 되고,
    * 이때 JPA는 어쩔 수 없이 DB에 부서 정보를 묻는 추가 쿼리를 실행합니다.
    * 결과 (N+1 문제): 만약 직원 100명의 목록을 조회(쿼리 1번)한 뒤 이 매퍼를 100번 반복 실행하면,
    * 각 직원의 부서 정보를 가져오기 위해 DB에 100번의 추가 쿼리(N번)가 연속으로 날아가게 됩니다.
    * */

    public static EmployeeDto mapToEmployeeDepartmentDto(Employee employee){
        return EmployeeDto.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .departmentDto(DepartmentMapper.mapToDepartmentDto(employee.getDepartment()))
                .build();
    }

    // DTO -> Entity
    public static Employee mapToEmployee(EmployeeDto employeeDto){
        // 엔티티에 Setter를 사용하는 기존 방식보다 빌더가 있다면 빌더 사용을 권장합니다.
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        // 필요 시 부서 세팅 로직 추가 가능
        return employee;
    }

}