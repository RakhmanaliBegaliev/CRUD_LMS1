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
    @Enumerated(EnumType.STRING)
    private StudyFromat studyFromat;
//    @Transient
//    private Long groupId;
//    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.REMOVE})
//    private Group group;
}
