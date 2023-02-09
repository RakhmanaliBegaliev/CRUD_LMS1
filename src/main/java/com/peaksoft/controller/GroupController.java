package com.peaksoft.controller;

import com.peaksoft.entity.Course;
import com.peaksoft.entity.Group;
import com.peaksoft.entity.Student;
import com.peaksoft.service.CourseService;
import com.peaksoft.service.GroupService;
import com.peaksoft.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("groups")
public class GroupController {
    private final GroupService groupService;
    private final CourseService courseService;
    private final StudentService studentService;

    @Autowired
    public GroupController(GroupService groupService, CourseService courseService, StudentService studentService) {
        this.groupService = groupService;
        this.courseService = courseService;
        this.studentService = studentService;
    }

    @GetMapping
    public String groups(Model model) {
        model.addAttribute("groups", groupService.getAllGroups());
        return "group/groups";
    }

    @GetMapping("/addGroup")
    public String add(Model model) {
        model.addAttribute("group", groupService.getAllGroups());
        model.addAttribute("courses", courseService.getAllCourses());
        return "group/addGroup";
    }

    @PostMapping("/saveGroup")
    public String save(@ModelAttribute("group") Group group) {
        groupService.addGroup(group);
        return "redirect:/groups";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        Group group = groupService.getById(id);
        model.addAttribute("group", group);
        model.addAttribute("courses", courseService.getAllCourses());
        return "group/updateGroup";
    }

    @PatchMapping("/{id}")
    public String updateGroup(@PathVariable("id") Long id, @ModelAttribute("group") Group group) {
        groupService.updateGroup(id, group);
        return "redirect:/groups";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        Group group = groupService.getById(id);
        groupService.deleteGroup(group);
        return "redirect:/groups";
    }
    @GetMapping("/courses/{id}")
    public String getCourses(@PathVariable("id") Long id, Model model) {
        List<Course> courses = groupService.getCourseByGroupId(id);
        model.addAttribute("courses", courses);
        return "group/courses";
    }
    @GetMapping("/students/{id}")
    public String getStudents(@PathVariable("id") Long id, Model model) {
        List<Student> students = groupService.getStudentsByGroupId(id);
        model.addAttribute("students", students);
        return "group/students";
    }
    @GetMapping("/search/{name}")
    public String search(@PathVariable("groupId") Long groupId, Model model, @RequestParam ("firstName") String firstName){
       List <Student> student = groupService.search(firstName, groupId);
        model.addAttribute("students", student);
        return "group/search";
    }
}
