package org.example.springbootdemo.controller;

import org.example.springbootdemo.model.Student;
import org.example.springbootdemo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class StudentRestController {
    @Autowired
    private IStudentService istudentService;
    @GetMapping("/show-list")
    public ResponseEntity<Page<Student>> index(@RequestParam(name="page", required = false,defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("name").descending();
        Pageable pageable = PageRequest.of(page, 3, sort);
        Page<Student> list = istudentService.findAll(pageable);
        model.addAttribute("list", list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping("add-student")
    public ResponseEntity<Void> addStudent(@RequestBody Student student) {
        istudentService.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED  );
    }
}
