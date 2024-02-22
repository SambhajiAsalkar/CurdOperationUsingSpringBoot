package com.nt.repository;

import org.springframework.data.repository.CrudRepository;

import com.nt.model.Students;

public interface IStudentRepo extends CrudRepository<Students, Integer> {

}
