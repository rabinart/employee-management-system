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
@Table(name = "office")
public class Office implements BaseEntity<Integer>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String address;

    @Builder.Default
    @OneToMany(mappedBy = "office", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Busyness> busyness = new ArrayList<>();
}

