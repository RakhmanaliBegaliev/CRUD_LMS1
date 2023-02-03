package com.peaksoft.controller;

import com.peaksoft.entity.Student;
import com.peaksoft.entity.Teacher;
import com.peaksoft.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("teachers")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @GetMapping
    public String teachers(Model model) {
        model.addAttribute("teachers", teacherService.getAllTeachers());
        return "teacher/teachers";
    }

    @GetMapping("/addTeacher")
    public String add(Model model) {
        model.addAttribute("teacher", new Teacher());
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
}
