package com.presta.soapweb.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "employee")
@Data
public class Employee implements Serializable {
    @Serial
    private static final long serialVersionUID=1L;
    @Id
    @Column(name="employee_id")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private  long employeeId;
    @Column(name="name")
    private String name;
    @Column(name="department")
    private  String department;
    @Column(name="phone")
    private String phone;
//    @Column(name="address")
//    private String address;
//@Column(name="department")
//private String department;
}
