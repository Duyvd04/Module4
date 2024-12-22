package org.example.springbootdemo.controller;

import jakarta.validation.Valid;
import org.example.springbootdemo.model.Student;
import org.example.springbootdemo.model.StudentDTO;
import org.example.springbootdemo.service.IClazzService;
import org.example.springbootdemo.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@SessionAttributes("clazzes")
public class StudentController {
    @Autowired
    private IStudentService istudentService;
    @Autowired
    private IClazzService iclazzService;
    @ModelAttribute("clazzes")
    public void addAttribute(Model model){
        model.addAttribute("clazzes", iclazzService.findAll());
    }

    @GetMapping
    public String index(@RequestParam(name="page", required = false,defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("name").descending();
        Pageable pageable = PageRequest.of(page, 3, sort);
        Page<Student> list = istudentService.findAll(pageable);
        model.addAttribute("list", list);
        return "index";
    }

    @GetMapping("/show-create-form")
    public String showCreateForm(Model model) {
//        if(name==null){
//            throw new RuntimeException();
//        }
//        model.addAttribute("clazzes", iclazzService.findAll());
        model.addAttribute("student", new StudentDTO());
        return "create-form";
    }
    @PostMapping("save-student")
    public String create(@Valid @ModelAttribute("student") StudentDTO studentDTO, BindingResult bindingResult) {
        new StudentDTO().validate(studentDTO,bindingResult);
        if(bindingResult.hasErrors()){
//            model.addAttribute("clazzes", iclazzService.findAll());
            return "create-form";
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO,student);
//        student.setId(1);
        istudentService.save(student);
        return "redirect:/";
    }
//    @ExceptionHandler(RuntimeException.class)
//    public String handleRuntimeException(){
//        return "err";
//    }
}
