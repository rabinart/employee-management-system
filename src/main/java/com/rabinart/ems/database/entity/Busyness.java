package com.rabinart.ems.database.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.springframework.data.repository.history.RevisionRepository;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
@Table(name = "busyness")
public class Busyness extends AuditingEntity<Long>  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    private Office office;

    @Column(nullable = false, name = "busy_from")
    private LocalDateTime busyFrom;

    @Column(nullable = false, name = "busy_till")
    private LocalDateTime busyTill;

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
