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
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "company_id")
    private Company company;
    @ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name = "course_groups",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<Group> groups;
    @Transient
    private Long groupId;
    @Transient
    private Long companyId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "course")
    private Teacher teacher;

    public String teacher(){
        if (this.teacher==null){
            return " ";
        }else {
            return teacher.getFirstName()+" "+teacher.getLastName();
        }
    }
}
