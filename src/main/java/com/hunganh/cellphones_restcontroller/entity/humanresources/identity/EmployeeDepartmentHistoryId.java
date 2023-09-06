package com.hunganh.cellphones_restcontroller.entity.humanresources.identity;

import com.hunganh.cellphones_restcontroller.entity.humanresources.Department;
import com.hunganh.cellphones_restcontroller.entity.humanresources.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@Setter
@Getter
@NoArgsConstructor
public class EmployeeDepartmentHistoryId implements Serializable {
    private Department department;
    private Employee employee;
    private Instant startDate;
}
