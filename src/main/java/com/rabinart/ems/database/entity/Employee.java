package com.rabinart.ems.database.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "employee")
public class Employee implements BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private Integer balance;

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "info_id")
    private PersonalInfo personalInfo;

    @Builder.Default
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Busyness> busyness = new ArrayList<>();
}
