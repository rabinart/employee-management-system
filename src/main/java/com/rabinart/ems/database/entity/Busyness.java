package com.rabinart.ems.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "busyness")
public class Busyness implements BaseEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Office office;

    @Column(nullable = false)
    private LocalDateTime busy_from;

    @Column(nullable = false)
    private LocalDateTime busy_till;

    @Column(nullable = false)
    private Integer earned;

    @Column(nullable = false)
    private String jobType;

    public void setEmployee(Employee employee) {
        this.employee = employee;
        employee.getBusyness().add(this);
    }

    public void setOffice(Office office) {
        this.office = office;
        office.getBusyness().add(this);
    }
}
