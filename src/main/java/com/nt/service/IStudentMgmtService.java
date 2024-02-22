package com.nt.service;

import com.nt.model.Students;

public interface IStudentMgmtService {
public String registerStudent(Students student);
public Iterable<Students> getAllStudents();
public Students getStudentById(int id);
public String deleteStudentById(int id);
public String updateStudentById(int id,Students student);
}
