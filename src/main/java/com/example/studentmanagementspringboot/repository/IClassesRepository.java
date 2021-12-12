package com.example.studentmanagementspringboot.repository;

import com.example.studentmanagementspringboot.model.Classes;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassesRepository extends PagingAndSortingRepository<Classes,Long> {
}
