package com.peaksoft.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column
    private String email;
    @Column(name = "last_name")
    private String lastName;
    @Enumerated
    private StudyFormat studyFormat;
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name = "group_id")
    private Group group;
}
