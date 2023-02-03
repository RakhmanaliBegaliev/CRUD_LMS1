package com.peaksoft.controller;

import com.peaksoft.entity.Group;
import com.peaksoft.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("groups")
public class GroupController {
    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public String groups(Model model) {
        model.addAttribute("groups", groupService.getAllGroups());
        return "group/groups";
    }

    @GetMapping("/addGroup")
    public String add(Model model) {
        model.addAttribute("group", new Group());
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
}
