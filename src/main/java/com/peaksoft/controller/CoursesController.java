package com.peaksoft.controller;

import com.peaksoft.entity.Company;
import com.peaksoft.entity.Course;
import com.peaksoft.service.CompanyService;
import com.peaksoft.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("courses")
public class CoursesController {
    private CourseService courseService;

    private CompanyService companyService;

    @Autowired
    public CoursesController(CourseService courseService, CompanyService companyService) {
        this.courseService = courseService;
        this.companyService = companyService;
    }

    @GetMapping
    public String courses(Model model) {
        model.addAttribute("courses", courseService.getAllCourse());
        return "course/courses";
    }

    @GetMapping("/addCourse")
    public String add(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("companies", companyService.getAllCompanies());
        return "course/addCourse";
    }

    @PostMapping("/saveCourse")
    public String save(@ModelAttribute("course") Course course){
        courseService.addCourse(course);
        return "redirect:/courses";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        Course course = courseService.getById(id);
        model.addAttribute("course", course);
        return "course/updateCourse";
    }

    @PatchMapping("/{id}")
    public String updateCourse(@PathVariable("id") Long id, @ModelAttribute("course") Course course) {
        courseService.updateCourse(id, course);
        return "redirect:/courses";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        Course course = courseService.getById(id);
        courseService.deleteCourse(course);
        return "redirect:/courses";
    }
}
