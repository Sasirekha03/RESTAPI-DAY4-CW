package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;

import com.example.demo.service.StudentService;

@RestController
public class ApiController {
	
	@Autowired
	StudentService sser;
	
	@PostMapping("/")
	public boolean add(@RequestBody Student s)
	{
		 sser.saveinfo(s);
		return true;
	}
	@PostMapping("addnstud")
	public boolean addndetails(@RequestBody List<Student> ss)
	{
		sser.savedetails(ss);
		return true;
	}
	
	@GetMapping("/")
	public List<Student> show()
	{
		return sser.showinfo();
	}
	@GetMapping("showbyid/{id}")
	public Optional<Student> showid(@PathVariable int id)
	{
		return sser.showbyid(id);
	}
	@PutMapping("updatebyid/{id}")
	public String modifybyid(@PathVariable int id,@RequestBody Student ss )
	{
		return sser.updateinfobyid(id, ss);
	}
	@DeleteMapping("delid/{id}")
	public boolean deleteinfo(@PathVariable int id)
	{
		sser.deletepvid(id);
		return true ;
	}

}