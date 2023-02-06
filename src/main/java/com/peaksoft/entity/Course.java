package com.peaksoft.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "duration_month")
    private String durationMonth;
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "company_id")
    private Company company;
    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "courses")
    private List<Group> groups;
    @Transient
    private Long groupId;
    @Transient
    private Long companyId;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}
