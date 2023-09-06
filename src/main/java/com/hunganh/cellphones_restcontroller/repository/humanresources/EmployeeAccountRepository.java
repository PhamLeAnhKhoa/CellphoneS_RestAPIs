package com.hunganh.cellphones_restcontroller.repository.humanresources;

import com.hunganh.cellphones_restcontroller.entity.humanresources.EmployeeAccount;
import com.hunganh.cellphones_restcontroller.dto.response.employee.AuthorInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeAccountRepository extends JpaRepository<EmployeeAccount, Integer> {

    AuthorInfo findById(int id);
}