package com.nt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Students;
import com.nt.service.IStudentMgmtService;

@RestController
@RequestMapping("/student/api")
public class StudentOperationController {
    @Autowired
	private IStudentMgmtService service;
    
    @PostMapping("/save")
    public ResponseEntity<String> saveStudent(@RequestBody Students student) 
    {
    	try {
    		String msg=service.registerStudent(student);
    		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	
    }
    @GetMapping("/report")
    public ResponseEntity<?> fetchActors()
    {
    	try {
    		Iterable<Students> it=service.getAllStudents();
    		return new ResponseEntity<Iterable<Students>>(it,HttpStatus.CREATED);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);    	}
    }
    
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getStudent(@PathVariable int id)
    {
    	
    	Students student=service.getStudentById(id);
    	
    	return new ResponseEntity<Students>(student,HttpStatus.OK);		
    }
    
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeStudent(@PathVariable int id)
    {
    	
    	String student=service.deleteStudentById(id);
    	
    	return new ResponseEntity<String>(student,HttpStatus.OK);		
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id,@RequestBody Students student)
    {
    	
    	String stud=service.updateStudentById(id,student);
    	
    	return new ResponseEntity<String>(stud,HttpStatus.OK);		
    }
}
