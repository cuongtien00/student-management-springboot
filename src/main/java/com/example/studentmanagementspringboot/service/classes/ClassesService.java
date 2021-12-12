package com.example.studentmanagementspringboot.service.classes;

import com.example.studentmanagementspringboot.model.Classes;
import com.example.studentmanagementspringboot.repository.IClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ClassesService implements IClassesService{

    @Autowired
    private IClassesRepository classesRepository;


    @Override
    public Iterable<Classes> findAll() {
        return classesRepository.findAll();
    }

    @Override
    public Optional<Classes> findById(Long id) {
        return classesRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
classesRepository.deleteById(id);
    }

    @Override
    public Classes save(Classes classes) {
        return classesRepository.save(classes);
    }
}
