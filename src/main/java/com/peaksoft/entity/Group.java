package com.peaksoft.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "group_name")
    private String groupName;
    @Column(name = "date_of_start")
    private String dateOfStart;
    @Column(name = "date_of_finish")
    private String dateOfFinish;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "course_id",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private List<Student> students;
    @Transient
    private Long courseId;
}
