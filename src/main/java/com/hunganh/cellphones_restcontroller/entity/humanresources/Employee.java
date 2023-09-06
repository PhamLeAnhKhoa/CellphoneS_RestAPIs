package com.hunganh.cellphones_restcontroller.entity.humanresources;

import com.hunganh.cellphones_restcontroller.common.MaritalStatus;
import com.hunganh.cellphones_restcontroller.entity.person.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "Employee")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private long id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "person_id")
    private Person person;

//    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//    @JoinColumn(name = "employee_account_id")
//    private EmployeeAccount account;

    @Column(name = "job_title", length = 50, nullable = false)
    private String jobTitle;

    @Column(name = "marital_status", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;

    @Column(name = "salaried_flag", nullable = false)
    private boolean salariedFlag;

    @Column(name = "vacation_hours", nullable = false)
    private int vacationHours;

    @Column(name = "sick_leave_hours", nullable = false)
    private int sickLeaveHours;

    @Column(name = "current_flag", nullable = false)
    private boolean currentFlag;

    @Column(name = "modified_date", nullable = false)
    @UpdateTimestamp
    private Instant modifiedDate;
}
