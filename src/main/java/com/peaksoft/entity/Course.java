package com.peaksoft.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "duration_month")
    private String durationMonth;
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name = "company_id")
    private Company company;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private List<Group> groups;
}
