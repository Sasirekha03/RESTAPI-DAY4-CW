package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;

import com.example.demo.repository.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	StudentRepo sr;
	
	public Student saveinfo(Student s)
	{
		return sr.save(s);
	}
	public List<Student> showinfo()
	{
		return sr.findAll();
	}
	public List<Student> savedetails(List<Student> ss)
	{
		return (List<Student>)sr.saveAll(ss);
	}
	
	public Optional<Student> showbyid(int id)
	{
		return sr.findById(id);
	}
	public String updateinfobyid(int id,Student s)
	{
		sr.saveAndFlush(s);
		if(sr.existsById(id))
		{
			return "Updated";
		}
		else
		{
			return "Enter valid id";
		}
	}
	public void deletepvid(int id)
	{
		sr.deleteById(id);
	}
	
	

}