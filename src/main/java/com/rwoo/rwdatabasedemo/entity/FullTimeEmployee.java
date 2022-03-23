package com.rwoo.rwdatabasedemo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name="FullTimeEmployee")
public class FullTimeEmployee extends Employee{
    private BigDecimal salary;

    protected FullTimeEmployee() {
        super();
    }
    public FullTimeEmployee(String name, BigDecimal salary) {
        super(name);
        this.salary = salary;
    }
}

