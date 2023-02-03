package com.peaksoft.controller;

import com.peaksoft.entity.Student;
import com.peaksoft.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public String students(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "student/students";
    }

    @GetMapping("/addStudent")
    public String add(Model model) {
        model.addAttribute("student", new Student());
        return "student/addStudent";
    }

    @PostMapping("/saveStudent")
    public String save(@ModelAttribute("student") Student student) {
        studentService.addStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        Student student = studentService.getById(id);
        model.addAttribute("student", student);
        return "student/updateStudent";
    }

    @PatchMapping("/{id}")
    public String updateStudent(@PathVariable("id") Long id, @ModelAttribute("student") Student student) {
        studentService.updateStudent(id, student);
        return "redirect:/students";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        Student student = studentService.getById(id);
        studentService.deleteStudent(student);
        return "redirect:/students";
    }
}
