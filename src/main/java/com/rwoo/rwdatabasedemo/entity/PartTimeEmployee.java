package com.rwoo.rwdatabasedemo.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="PartTimeEmployee")
public class PartTimeEmployee extends Employee{
    private BigDecimal hourlyWage;

    protected PartTimeEmployee() {
        super();
    }
    public PartTimeEmployee(String name, BigDecimal hourlyWage) {
        super(name);
        this.hourlyWage = hourlyWage;
    }
}

