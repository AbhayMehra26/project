package com.example.service;

import com.example.entity.Doctor;

import jakarta.validation.Valid;

public interface DoctorService 
{


	void saveDoctor(@Valid Doctor doc);


}
