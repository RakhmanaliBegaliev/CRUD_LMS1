package com.peaksoft.controller;

import com.peaksoft.entity.Teacher;
import com.peaksoft.service.CourseService;
import com.peaksoft.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("teachers")
public class TeacherController {

    private final TeacherService teacherService;
    private final CourseService courseService;

    @Autowired
    public TeacherController(TeacherService teacherService, CourseService courseService) {
        this.teacherService = teacherService;
        this.courseService = courseService;
    }
    @GetMapping
    public String teachers(Model model) {
        model.addAttribute("teachers", teacherService.getAllTeachers());
        return "teacher/teachers";
    }

    @GetMapping("/addTeacher")
    public String add(Model model) {
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("courses", courseService.getAllCourses());
        return "teacher/addTeacher";
    }

    @PostMapping("/saveTeacher")
    public String save(@ModelAttribute("teacher") Teacher teacher) {
        teacherService.addTeacher(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        Teacher teacher = teacherService.getById(id);
        model.addAttribute("teacher", teacher);
        model.addAttribute("courses", courseService.getAllCourses());
        return "teacher/updateTeacher";
    }

    @PatchMapping("/{id}")
    public String updateTeacher(@PathVariable("id") Long id, @ModelAttribute("teacher") Teacher teacher) {
        teacherService.updateTeacher(id, teacher);
        return "redirect:/teachers";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        Teacher teacher = teacherService.getById(id);
        teacherService.deleteTeacher(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/course/{id}")
    public String course(@PathVariable("id")Long id,Model model){
        model.addAttribute("course",teacherService.getByTeacherId(id));
        return "teacher/course";
    }
    @GetMapping("/students/{id}")
    public String sizeOfStudents(@PathVariable("id") Long id, Model model){
        model.addAttribute("students", teacherService.sizeOfStudents(id));
        model.addAttribute("size",teacherService.sizeOfStudents(id).size());
        return "teacher/students";
    }
}
