package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Students;
import com.nt.repository.IStudentRepo;
@Service("studentMgmtService")
public class IStudentMgmtServiceImpl implements IStudentMgmtService{

	@Autowired
	private IStudentRepo repo;
	@Override
	public String registerStudent(Students student) {
		@SuppressWarnings("null")
		Students s=repo.save(student);
		return "Student is registered with id "+ s.getStudentID();
	}
	@Override
	public Iterable<Students> getAllStudents() {
		Iterable<Students> it=repo.findAll();
		List<Students> list1=(List<Students>) it;
		list1.sort((t1,t2)->t1.getStudent_name().compareTo(t2.getStudent_name()));
       return it;
	}
@Override
public Students getStudentById(int id) {

	return repo.findById(id).orElseThrow(()->new IllegalArgumentException());
	 
	
}
@Override
public String deleteStudentById(int id) {
	 if(repo.existsById(id))
	 {
		 repo.deleteById(id);
		 return "student with id "+id+" deleted succesfully";
	 }
	 else
	return "record not found..";
}
 @Override
 public String updateStudentById(int id,Students student) {
	    if (student == null) {
	        return "Updated student object is null";
	    }

	    try {
	        Optional<Students> opt = repo.findById(id);
	        if (opt.isPresent()) {
	            Students stud = opt.get();
	            // Update the fields of the existing student with the values from the incoming student
	            
	            stud.setAddrs(student.getAddrs());
	            stud.setAge(student.getAge());
	            stud.setMobileno(student.getMobileno());
	            stud.setStudent_name(student.getStudent_name());
	            // Save the updated student
	            repo.save(stud);
	            return "Records updated successfully";
	        } else {
	            return "Record not found";
	        }
	    } catch (Exception e) {
	        // Handle exceptions
	        return "Error updating record: " + e.getMessage();
	    }
	}

}
