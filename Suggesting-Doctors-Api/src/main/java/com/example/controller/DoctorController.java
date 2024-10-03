package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Doctor;
import com.example.service.DoctorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("doctor")
public class DoctorController 
{
	@Autowired  private DoctorService doctorServicve;

	@PostMapping("add")
	public  ResponseEntity<Doctor> addDoctor(@Valid @RequestBody Doctor doc)
	{
		doctorServicve.saveDoctor(doc);
		return ResponseEntity.status(HttpStatus.CREATED).body(doc);
	}
}
