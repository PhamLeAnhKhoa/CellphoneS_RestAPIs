package com.hunganh.cellphones_restcontroller.entity.humanresources;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "Department")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private int id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(name = "group_name", length = 50, nullable = false)
    private String groupName;

    @Column(name = "modified_date", nullable = false)
    @UpdateTimestamp
    private Instant modifiedDate;
}
