package com.hunganh.cellphones_restcontroller.entity.person;

import com.hunganh.cellphones_restcontroller.common.Gender;
import com.hunganh.cellphones_restcontroller.entity.humanresources.Employee;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "Person")
@Data
@NoArgsConstructor
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int id;

    @Column(name = "national_id_number", length = 15, nullable = false, unique = true)
    private String nationalIdNumber;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthdate;

    @Column(name = "gender", length = 15, nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "email", length = 150)
    private String email;

    @Column(name = "email_promotion", columnDefinition = "boolean default false")
    private boolean emailPromotion;

    @Column(name = "phone_number", length = 15, nullable = false)
    private String phoneNumber;

    @Column(name = "photo_url", length = 1000)
    private String photoUrl;

    @Column(name = "created_date", nullable = false)
    @CreationTimestamp
    private Instant createDate;

    @Column(name = "modified_date", nullable = false)
    @UpdateTimestamp
    private Instant modifiedDate;
}
