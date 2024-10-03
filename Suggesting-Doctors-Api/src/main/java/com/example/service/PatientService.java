package com.example.service;

import java.util.List;

import com.example.entity.Doctor;
import com.example.entity.Patient;

import jakarta.validation.Valid;

public interface PatientService 
{

	void saveDoctor(@Valid Patient pat);

	List<Doctor> findDoctorListByPatientId(int pid);




}
