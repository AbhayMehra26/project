package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Doctor;
import com.example.entity.Patient;
import com.example.service.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("patient")
public class PatientController 
{
	@Autowired  private PatientService ps;

	@PostMapping("add")
	public  ResponseEntity<Patient> addDoctor(@Valid @RequestBody Patient pat)
	{
		ps.saveDoctor(pat);
		return ResponseEntity.status(HttpStatus.CREATED).body(pat);
	}
	
	@GetMapping("doctor/bypid")
	public  ResponseEntity<List<Doctor>> getDoctorByPatientId(@RequestParam int pid)
	{
		
		List<Doctor> doctorList=ps.findDoctorListByPatientId(pid);
		return ResponseEntity.ok(doctorList);
	}
	
}
