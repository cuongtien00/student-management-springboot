package com.example.studentmanagementspringboot.controller;

import com.example.studentmanagementspringboot.model.Classes;
import com.example.studentmanagementspringboot.model.Student;
import com.example.studentmanagementspringboot.service.classes.IClassesService;
import com.example.studentmanagementspringboot.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/students")
public class StudentRestController {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IClassesService classesService;
    @GetMapping()
    public ModelAndView showAll(){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("students",studentService.findAll());
        return modelAndView;
    }

    @ModelAttribute("classes")
    public Iterable<Classes> classesList(){
        return classesService.findAll();
    }

    @GetMapping("/success")
    public ResponseEntity<List<Student>> successHandle(){
        List<Student> students = (List<Student>) studentService.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Student> addNewStu(@RequestBody Student student){
        return new ResponseEntity<>(studentService.save(student),HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Student> delete(@PathVariable Long id){
        studentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id){
       Student student = studentService.findById(id).get();
        studentService.save(student);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> viewUpdate(@PathVariable Long id){
        Student student = studentService.findById(id).get();
        return new ResponseEntity<>(student,HttpStatus.OK);
    }
}
