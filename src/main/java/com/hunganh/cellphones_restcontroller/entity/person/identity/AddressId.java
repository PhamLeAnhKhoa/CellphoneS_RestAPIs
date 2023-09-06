package com.hunganh.cellphones_restcontroller.entity.person.identity;

import com.hunganh.cellphones_restcontroller.entity.person.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddressId implements Serializable {
    private Person person;

    private int addressId;
}
